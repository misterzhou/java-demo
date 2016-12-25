package org.guojing.thread;

/**
 * Created at: 2016-04-16
 *
 * @author guojing
 */
public class ThreadLocalDemo {

    public static void main(String[] args) {
        ThreadLocal<Logger> tl1 = new ThreadLocal<Logger>(){
            @Override
            protected Logger initialValue() {
                return new Logger();
            }
        };

        new Thread(new Worker(tl1)).start();
    }

    static class Worker implements Runnable {
        ThreadLocal<Logger> tl1;

        public Worker(ThreadLocal<Logger> tl1) {
            this.tl1 = tl1;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Logger logger = tl1.get();
            logger.setRequestID("111111");
            logger.setRespCode("200");
            System.out.println("tl1: " + tl1.get());
        }
    }
}
