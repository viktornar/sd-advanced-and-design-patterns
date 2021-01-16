package com.sd.advanced.coding.examples;

/*
    Deadlock describes a situation where two or more threads are blocked forever, waiting for each other.
    Here's an example.
 */
public class ExampleDeadlock implements Example {
    @Override
    public void run() throws InterruptedException {
        final Friend alphonse = new Friend("Alphonse");
        final Friend gaston = new Friend("Gaston");

        Thread t1 = new Thread(() -> alphonse.bow(gaston));
        Thread t2 = new Thread(() -> gaston.bow(alphonse));

        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

    static class Friend {
        private final String name;

        public Friend(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public synchronized void bow(Friend bower) {
            System.out.format("%s: %s has bowed to me!%n", name, bower.getName());
            bower.bowBack(this);
        }

        public synchronized void bowBack(Friend bower) {
            System.out.format("%s: %s has bowed back to me!%n", name, bower.getName());
        }
    }

}
