package org.guojing.demo.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created at: 2016-01-08
 *
 * @author guojing
 */
public class CountDownLatchDemo {

    private static final int SIZE = 3;
    private static CountDownLatch finishSignal;

    public static void main(String[] args) throws InterruptedException{
        finishSignal = new CountDownLatch(SIZE);

        for (int i = 0; i < SIZE; i++) {
            new Thread(new Worker()).start();
        }

        System.out.println("main thread await");
        finishSignal.await();
        System.out.println("main thread finished");

        System.out.println(TimeUnit.MILLISECONDS.toNanos(0));

    }

    static class Worker implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " starting...");
            try {
                //mock do something
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            finishSignal.countDown();
            System.out.println(Thread.currentThread().getName() + " finished..");
        }
    }
}
