package com.sd.advanced.coding.examples;

// https://docs.oracle.com/javase/tutorial/essential/concurrency/index.html
public class ExampleThreads implements Example {
    @Override
    public void run() throws InterruptedException {
//        createRunnable();
//        createThread();
        runThreadsWithWaitJoin(4000);
    }

    private void createRunnable() {
        new Thread(new ImplementedRunnable()).start();
    }

    private static class ImplementedRunnable implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                System.out.println("Running <ImplementedRunnable>");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void createThread() {
        (new ExtendedThread()).start();
    }

    private static class ExtendedThread extends Thread {
        public void run() {
            System.out.println("Running <ExtendedThread>");
        }
    }

    private void runThreadsWithWaitJoin(long timeout) throws InterruptedException {
        threadMessage("Starting MessageLoop thread");
        long startTime = System.currentTimeMillis();
        Thread t = new Thread(new MessageLoop());
        t.start();

        threadMessage("Waiting for MessageLoop thread to finish");
        while (t.isAlive()) {
            threadMessage("Still waiting...");
            t.join(1000);
            if (((System.currentTimeMillis() - startTime) > timeout)
                    && t.isAlive()) {
                threadMessage("Tired of waiting!");
                t.interrupt();
                t.join();
            }
        }
        threadMessage("Finally!");
    }


    static void threadMessage(String message) {
        String threadName = Thread.currentThread().getName();
        System.out.printf("%s: %s%n", threadName, message);
    }


    private static class MessageLoop implements Runnable {
        @Override
        public void run() {
            String[] importantInfo = {
                    "Mares eat oats",
                    "Does eat oats",
                    "Little lambs eat ivy",
                    "A kid will eat ivy too"
            };

            try {
                for (String s : importantInfo) {
                    Thread.sleep(4000);
                    threadMessage(s);
                }
            } catch (InterruptedException e) {
                threadMessage("I wasn't done!");
            }
        }
    }
}
