package com.sd.advanced.coding.examples;

public class ExampleEncapsulation implements Example {
    @Override
    public void run() throws InterruptedException {
        System.out.println("Running from encapsulation");
        Person p = new Person();

        p.setName("ssss");
        p.getName();
    }

    private class Person {
        private String name;
        private String surname;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }
    }
}
