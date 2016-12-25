package org.guojing.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created at: 2016-04-15
 *
 * @author guojing
 */
public class CyclicBarrierDemo {

    private static final int threadNum = 3;

    public static void main(String[] args) {

        CyclicBarrier cb = new CyclicBarrier(threadNum, new Runnable() {
            @Override
            public void run() {
                System.out.println("Current thread name: " + Thread.currentThread().getName());
            }
        });
        new Thread(new Student(cb)).start();
        new Thread(new Student(cb)).start();
        new Thread(new Student(cb)).start();

        //System.out.println("teacher began the class...");
    }

    static class Student implements Runnable {
        CyclicBarrier cb;

        public Student(CyclicBarrier cb) {
            this.cb = cb;
        }

        @Override
        public void run() {
            System.out.println("Student: " + Thread.currentThread().getName() + " start coming to classroom...");
            try {
                //模拟正在往教室走
                Thread.sleep(3000);
                cb.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("Student: " + Thread.currentThread().getName() + " play with others");
        }
    }
}
