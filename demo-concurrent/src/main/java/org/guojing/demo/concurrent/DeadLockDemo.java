package org.guojing.demo.concurrent;

/**
 * Created at: 2016-01-08
 *
 * @author guojing
 */
public class DeadLockDemo {

    public static void main(String[] args) throws InterruptedException {
        Object obj1 = new Object();
        Object obj2 = new Object();

        Thread t1 = new Thread(new Worker(obj1, obj2), "t1");
        Thread t2 = new Thread(new Worker(obj2, obj1), "t2");

        t1.start();
        Thread.sleep(1000); // #1
        t2.start();
    }

    static class Worker implements Runnable {

        Object obj1;
        Object obj2;

        public Worker(Object obj1, Object obj2) {
            this.obj1 = obj1;
            this.obj2 = obj2;
        }

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();

            System.out.println(threadName + " acquiring lock on: " + obj1);
            synchronized (obj1) {
                System.out.println(threadName + " already acquired lock on: " + obj1);
                doSomething();
                System.out.println(threadName + " acquiring lock on: " + obj2);
                //在已经持有obj1锁的情况下试图获取obj2的锁
                synchronized (obj2) {
                    System.out.println(threadName + " already acquired lock on: " + obj2);
                    doSomething();
                }
                System.out.println(threadName + " released lock on: " + obj2);
            }
            System.out.println(threadName + " released lock on: " + obj1);
            System.out.println(threadName + " finished");
        }

        private void doSomething() {
            try {
                Thread.sleep(5000); // 此处的时间需大于#1处的时间
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
