package com.sd.advanced.coding.exercises;

import java.util.Arrays;

/*
    Design the Joiner<T> class, which in the constructor will take a separator (string) and have a join() method
    that allows you to specify any number of T-type objects. This method will return a string joining all passed
    elements by calling their toString() method and separating them with a separator.
    e.g. for Integers and separator "-" it should return: 1-2-3-4
 */
public class Exercise5 implements Exercise {
    @Override
    public void run() {
        Joiner<Integer> joinerInt = new Joiner<>("-");
        System.out.printf("%s%n", joinerInt.join(1, 2, 3, 4));

        Joiner<String> joinerString = new Joiner<>("-");
        System.out.printf("%s%n", joinerString.join("a", "b", "c", "d"));
    }

    private static class Joiner<T> {
        private final String separator;

        public Joiner(String separator) {
            this.separator = separator;
        }

        String join(T... objects) {
            return Arrays
                    .stream(objects)
                    .map(Object::toString)
                    .reduce("", (acc, e) -> acc.isEmpty() ? acc + e : acc + separator + e);
        }
    }
}
