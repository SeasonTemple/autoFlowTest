package com.st.srcreview.bean;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class UserInfo {
    //题目：
    // 你是用户信息系统的负责同学，因上游系统消费场景诉求(高时效+高并发)，需要构建一个本地缓存，来保存用户信息。供上游系统使用。
    // 2.要求：1.完成 缓存的构建、更新、消费功能。完成如下方法。可自行补充其他相关内容。
    // 3.提示：技术实现方面注意考虑缓存失效、高并发访问、近端缓存容量等情况。
    // ——————————————————————————————————————————
    // 补充：UserInfo结构
    private String userId;
    private String userName;
    private String cardNo;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    //: TODO 可自行定义需要的变量
    private static final UserInfo EMPTY_NODE = new UserInfo();

    private static Cache INFO_CACHE;

    private static final ReadWriteLock rwl = new ReentrantReadWriteLock();

    //完成下面的代码
    private static final ThreadLocal<ConcurrentHashMap<String, UserInfo>> tll = new ThreadLocal<>();

    /**
     * 初始化用户信息缓存
     */
    public void initUserInfoCache() {
        //: TODO 完成此处的代码
        INFO_CACHE = Cache.getInstance();
    }

    public Object getUserInfoFromCacheById(String id) {
        //: TODO 完成此处的代码
        Lock lock = rwl.writeLock();
        if (lock.tryLock()) {
            try {
                return INFO_CACHE.get(id);
            } finally {
                lock.unlock();
            }
        } else {
            return null;
        }
    }

    public void updateUserInfoCache() {
        //: TODO 完成此处的代码
        Lock lock = rwl.writeLock();
        if (lock.tryLock()) {
            try {

            } finally {
                lock.unlock();
            }
        }
    }
}
