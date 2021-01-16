package com.sd.advanced.coding.examples;

/*
    This example demonstrates:
    * Thread interference that describes how errors are introduced when multiple threads access shared data.
    * Memory consistency error that describes errors that result from inconsistent views of shared memory.
 */
public class ExampleSync implements Example {
    @Override
    public void run() throws InterruptedException {
        runCounter();
//        runSyncCounter();
//        runLockCounter();
        // TODO write AtomicCounter as example
    }

    private void runCounter() throws InterruptedException {
        Counter c = new Counter();

        for (int i = 0; i < 100; i++) {
            Thread t1 = new Thread(() -> {
                try {
                    Thread.sleep(150);
                    c.increment();
                    System.out.printf("%s: %d%n", Thread.currentThread().getName(), c.value());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            Thread t2 = new Thread(() -> {
                try {
                    Thread.sleep(150);
                    c.decrement();
                    System.out.printf("%s: %d%n", Thread.currentThread().getName(), c.value());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            t1.start();
            t2.start();
            t1.join();
            t2.join();
        }

        System.out.printf("Final value %d%n", c.value());
    }

    private void runSyncCounter() throws InterruptedException {
        SynchronizedCounter c = new SynchronizedCounter();

        for (int i = 0; i < 100; i++) {
            Thread t1 = new Thread(() -> {
                try {
                    Thread.sleep(150);
                    c.increment();
                    System.out.printf("%s: %d%n", Thread.currentThread().getName(), c.value());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            Thread t2 = new Thread(() -> {
                try {
                    Thread.sleep(150);
                    c.decrement();
                    System.out.printf("%s: %d%n", Thread.currentThread().getName(), c.value());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            t1.start();
            t2.start();
            t1.join();
            t2.join();
        }

        System.out.printf("Final value %d%n", c.value());
    }

    private void runLockCounter() throws InterruptedException {
        SynchronizedCounter c = new SynchronizedCounter();

        for (int i = 0; i < 100; i++) {
            Thread t1 = new Thread(() -> {
                try {
                    Thread.sleep(150);
                    c.increment();
                    System.out.printf("%s: %d%n", Thread.currentThread().getName(), c.value());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            Thread t2 = new Thread(() -> {
                try {
                    Thread.sleep(150);
                    c.decrement();
                    System.out.printf("%s: %d%n", Thread.currentThread().getName(), c.value());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            t1.start();
            t2.start();
            t1.join();
            t2.join();
        }

        System.out.printf("Final value %d%n", c.value());
    }

    private class Counter {
        private int c = 0;

        public void increment() {
            c++;
        }

        public void decrement() {
            c--;
        }

        public int value() {
            return c;
        }

    }

    private class SynchronizedCounter {
        private int c = 0;

        public synchronized void increment() {
            c++;
        }

        public synchronized void decrement() {
            c--;
        }

        public synchronized int value() {
            return c;
        }
    }

    private class LockCounter {
        private long c1 = 0;
        private long c2 = 0;
        private Object lock1 = new Object();
        private Object lock2 = new Object();

        public void inc1() {
            synchronized(lock1) {
                c1++;
            }
        }

        public void inc2() {
            synchronized(lock2) {
                c2++;
            }
        }
    }
}
