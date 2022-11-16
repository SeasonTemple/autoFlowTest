package com.st.srcreview.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Cache {
    private static final Logger LOG = LoggerFactory.getLogger(Cache.class);
    private static final long TIME_OUT_STAMP = 6000L;

    private static final int CLEAN_PERIOD = 5;

    private static final int INIT_DELAY_TIME = 1;

    private static final int CACHE_SIZE = 1024;

    private static volatile Cache cache;

    private static Map<String, Long> CACHE_ID_MAP;

    private static Map<String, UserInfo> CACHE_OBJ_MAP;

    private static final ReadWriteLock rwl = new ReentrantReadWriteLock();

    private static final ScheduledExecutorService scheduledService = Executors.newScheduledThreadPool(1);

    private Cache() {
        CACHE_ID_MAP = new ConcurrentHashMap<>(CACHE_SIZE);
        CACHE_OBJ_MAP = new ConcurrentHashMap<>(CACHE_SIZE);
        scheduledService.scheduleAtFixedRate(() -> {
            try {
                removeAll();
            } catch (Exception e) {
                LOG.error("scheduled delete userInfo failed.");
            }
        }, INIT_DELAY_TIME, CLEAN_PERIOD, TimeUnit.SECONDS);
    }

    public static Cache getInstance() {
        if (cache == null) {
            synchronized (Cache.class) {
                if (cache == null) {
                    cache = new Cache();
                }
            }
        }
        return cache;
    }

    public boolean put(String id, UserInfo info, long expireTime) {
        if (checkSize()) {
            CACHE_ID_MAP.put(id, System.currentTimeMillis() + expireTime);
            CACHE_OBJ_MAP.put(id, info);
            return true;
        }
        return false;
    }

    public UserInfo get(String id) {
        if (System.currentTimeMillis() - CACHE_ID_MAP.getOrDefault(id, 0L) < TIME_OUT_STAMP) {
            return CACHE_OBJ_MAP.getOrDefault(id, null);
        } else {
            CACHE_OBJ_MAP.remove(id);
        }
        return null;
    }

    private void remove(String id) {
        CACHE_OBJ_MAP.remove(id);
        CACHE_ID_MAP.remove(id);
    }

    private void removeAll() {
        if (CACHE_OBJ_MAP.isEmpty()) {
            return;
        }
        for (Map.Entry<String, Long> entry : CACHE_ID_MAP.entrySet()) {
            if (entry.getValue() > 0 && System.currentTimeMillis() - entry.getValue() > TIME_OUT_STAMP) {
                remove(entry.getKey());
                LOG.info("scheduled delete userInfo success.");
            }
        }
    }

    public static boolean checkSize() {
        return getSize() < CACHE_SIZE;
    }

    public static int getSize() {
        return CACHE_OBJ_MAP.size();
    }
}
