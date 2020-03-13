package com.vincent.concurrency.chapter10;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Title:  concurrency_tutorial
 * Description TODO
 * Company: https://www.zhishinet.com
 *
 * @Author Vincent Li
 * @Date 2020/3/12 23:54
 */
public class BooleanLock implements Lock {

    // the initValue is true indicated the lock have geen get;
    // the initValue is false indicated the lock is free( other thread can get this)
    private boolean initValue;

    private Collection<Thread> blockedThreadCollection = new ArrayList<>();

    public BooleanLock(){
        this.initValue = false;
    }

    @Override
    public synchronized void lock() throws InterruptedException {
        while (initValue){
            blockedThreadCollection.add(Thread.currentThread());
            this.wait();
        }
        blockedThreadCollection.remove(Thread.currentThread());
        this.initValue = true;
    }

    @Override
    public void lock(long mills) throws InterruptedException, TimeOutException {

    }

    @Override
    public synchronized void unlock() {
        this.initValue = false;
        System.out.println(Thread.currentThread() + "release the lock monitor.");
        this.notifyAll();
    }

    @Override
    public Collection<Thread> getBlockedThread() {
        return Collections.unmodifiableCollection(blockedThreadCollection);
    }

    @Override
    public int getBlockedSize() {
        return 0;
    }
}
