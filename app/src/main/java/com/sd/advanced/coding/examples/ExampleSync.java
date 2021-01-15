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
}
