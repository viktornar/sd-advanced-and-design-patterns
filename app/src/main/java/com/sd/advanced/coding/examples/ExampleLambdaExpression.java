package com.sd.advanced.coding.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class ExampleLambdaExpression implements Example {
    @Override
    public void run() throws InterruptedException {
        List<Person> roster = new ArrayList<>() {{
            add(new Person(20, "John", "Wayne", "john.wayne@gmail.com"));
            add(new Person(25, "Ben", "Willson", "ben.willson@gmail.com"));
            add(new Person(22, "Theodor", "Merlin", "theodor.merlin@gmail.com"));
            add(new Person(30, "Gustav", "Klaud", "gustav.klaud@gmail.com"));
        }};

        Function<Person, Person> func = (p) -> new Person(
                p.getAge(),
                p.getName().substring(0, 1).toUpperCase(),
                p.getSurname().substring(0, 1).toUpperCase(),
                p.getEmail()
        );

        Person.printPersons(
                roster,
                (p) -> p.getAge() > 22,
                func,
                (p) -> System.out.printf("User initials: %s%s%n", p.getName(), p.getSurname())
        );
    }

    private static class Person {
        public enum Sex {
            MALE, FEMALE
        }

        private Sex gender;
        private int age;
        private String name;
        private String surname;
        private String email;

        public Person(int age, String name, String surname, String email) {
            this.age = age;
            this.name = name;
            this.surname = surname;
            this.email = email;
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

        public static void printPersons(
                List<Person> roster,
                Predicate<Person> tester
        ) {
            for (Person p : roster) {
                if (tester.test(p)) {
                    p.printPerson();
                }
            }
        }

        public static void printPersons(
                List<Person> roster,
                Predicate<Person> tester,
                Consumer<Person> block
        ) {
            for (Person p : roster) {
                if (tester.test(p)) {
                    block.accept(p);
                }
            }
        }

        public static void printPersons(
                List<Person> roster,
                Predicate<Person> tester,
                Function<Person, Person> mapper,
                Consumer<Person> block
        ) {
            for (Person p : roster) {
                if (tester.test(p)) {
                    Person newP = mapper.apply(p);
                    block.accept(newP);
                }
            }
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
