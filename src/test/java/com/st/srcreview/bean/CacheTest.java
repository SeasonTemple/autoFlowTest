package com.st.srcreview.bean;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


class CacheTest {
    private static final Logger LOG = LoggerFactory.getLogger(CacheTest.class);

    private static final Cache cache = Cache.getInstance();

    @Test
    public void testCache() throws InterruptedException {
        LOG.info("cache size0: {}", Cache.getSize());
        UserInfo info = new UserInfo();
        info.setUserId("006");
        info.setCardNo("006");
        info.setUserName("nigema");
        UserInfo info2 = new UserInfo();
        info2.setUserId("007");
        info2.setCardNo("007");
        info2.setUserName("nisha");
        cache.put(info.getUserId(), info, 2000);
        cache.put(info2.getUserId(), info, 3000);
        Thread.sleep(4000);
        LOG.info("cache size1: {}", Cache.getSize());

        long start = System.currentTimeMillis();
        for (;;) {
            if (Cache.getSize() == 0) {
//                LOG.info("cache size2: {}", Cache.getSize());
                break;
            }
        }
        long end = System.currentTimeMillis();
        LOG.info("weak consistency: {}", end - start);

//        LOG.info("cache info: {}", cache.get(info.getUserId()));
//        LOG.info("cache info2: {}", cache.get(info2.getUserId()));
    }
}