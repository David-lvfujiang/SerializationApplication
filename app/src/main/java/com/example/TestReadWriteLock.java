package com.example;

import android.util.Log;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author: david.lvfujiang
 * @Date: 2019/12/28
 * @Describe:
 */
public class TestReadWriteLock {

    //模拟共享资源--Number
    private int number = 0;
    // 实际实现类--ReentrantReadWriteLock，默认非公平模式
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    //读
    public void get(){
        //使用读锁
        readWriteLock.readLock().lock();
        try {
            //启动100个读线程
            for (int i = 0; i < 2; i++) {
                Log.e("TAG",Thread.currentThread().getName()+" : "+i);
            }
        }finally {
            readWriteLock.readLock().unlock();
        }
    }
    //写
    public void set(int number){
        readWriteLock.writeLock().lock();
        try {
            //启动100个读线程
            for (int i = 0; i < 2; i++) {
                Log.e("TAG",Thread.currentThread().getName()+" : "+i);

            }

        }finally {
            readWriteLock.writeLock().unlock();
        }
    }
}

