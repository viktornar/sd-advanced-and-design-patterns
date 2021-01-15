package com.sd.advanced.coding.examples;

import java.util.ArrayList;
import java.util.List;

public class ExampleAggregators implements Example {
    @Override
    public void run() throws InterruptedException {
        List<Person> roster = new ArrayList<>() {{
            add(new Person(20, "John", "Wayne", "john.wayne@gmail.com", Person.Sex.MALE));
            add(new Person(25, "Ben", "Willson", "ben.willson@gmail.com", Person.Sex.MALE));
            add(new Person(22, "Theodor", "Merlin", "theodor.merlin@gmail.com", Person.Sex.MALE));
            add(new Person(30, "Gustav", "Klaud", "gustav.klaud@gmail.com", Person.Sex.MALE));
            add(new Person(30, "Augustina", "Klaud", "augustina.klaud@gmail.com", Person.Sex.FEMALE));
        }};
    }

    private static class Person {
        public enum Sex {
            MALE, FEMALE
        }

        public Sex getGender() {
            return gender;
        }

        public void setGender(Sex gender) {
            this.gender = gender;
        }

        private Person.Sex gender;
        private int age;
        private String name;
        private String surname;
        private String email;

        public Person(int age, String name, String surname, String email, Sex gender) {
            this.age = age;
            this.name = name;
            this.surname = surname;
            this.email = email;
            this.gender = gender;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

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

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void printPerson() {
            System.out.println(this);
        }

        @Override
        public String toString() {
            return "Person{" +
                    "gender=" + gender +
                    ", age=" + age +
                    ", name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", email='" + email + '\'' +
                    '}';
        }
    }
}
