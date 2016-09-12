package com.slt.test;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by Administrator on 2016/8/6.
 */
public class ThreadRunnable implements Runnable {
    private CyclicBarrier barrier;
    private int sum=0;
    private int n=1;


    public ThreadRunnable() {
    }

    public ThreadRunnable(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
                while (sum<10) {

                    synchronized (this) {
                        if(sum>=10){
                            break;
                        }
                        n = n + n;
                        sum++;
                        System.out.println(n);
                    }

                }
                System.out.println(Thread.currentThread().getName()+"执行完毕");


            barrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
