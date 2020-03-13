package com.vincent.concurrency.chapter10;

import java.util.Collection;

/**
 * Title:  concurrency_tutorial
 * Description TODO
 * Company: https://www.zhishinet.com
 *
 * @Author Vincent Li
 * @Date 2020/3/12 23:52
 */
public interface Lock {

    static class TimeOutException extends Exception {
        public TimeOutException(String message ){
            super(message);
        }
    }

    void lock() throws InterruptedException;

    void lock(long mills) throws InterruptedException, TimeOutException;

    void unlock();

    Collection<Thread> getBlockedThread();

    int getBlockedSize();
}
