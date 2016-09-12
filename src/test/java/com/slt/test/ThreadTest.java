package com.slt.test;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by Administrator on 2016/8/6.
 */
public class ThreadTest {

    public static void main(String[] args) {
        CyclicBarrier barrier=new CyclicBarrier(4, new Runnable() {
            @Override
            public void run() {
                System.out.println("game over!");
            }
        });
        ThreadRunnable threadRunnable=new ThreadRunnable(barrier);
        Thread thread1=new Thread(threadRunnable);
        Thread thread2=new Thread(threadRunnable);
        Thread thread3=new Thread(threadRunnable);
        Thread thread4=new Thread(threadRunnable);
//        Thread thread5=new Thread(runnable);
//        Thread thread6=new Thread(runnable);
//        Thread thread7=new Thread(runnable);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
//        thread5.start();
//        thread6.start();
//        thread7.start();

//        ExecutorService exec= Executors.newFixedThreadPool(3);
//        barrier=new CyclicBarrier(2);
//        exec.execute(runnable);
//        exec.execute(runnable);
//        exec.execute(runnable);
//
//        barrier.await();
//        exec.shutdown();


    }

}
