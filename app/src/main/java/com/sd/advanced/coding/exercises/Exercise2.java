package com.sd.advanced.coding.exercises;

import java.util.Arrays;
import java.util.List;

/*
Create a method that takes a string list as a parameter, then returns that list sorted alphabetically from Z to
A case-insensitive.
 */
public class Exercise2 implements Exercise {
    @Override
    public void run() {
        List<String> listToSort = Arrays.asList(
                "Jonas",
                "jaunas",
                "Benas",
                "burgeris",
                "Vitalijus",
                "Zebra"
        );
        sortDescStringIgnoreCase(listToSort);

        System.out.println(listToSort);
    }

    private void sortDescStringIgnoreCase(final List<String> listToSort) {
        listToSort.sort((o1, o2) -> o2.toLowerCase().compareTo(o1.toLowerCase()));
        /*
        listToSort.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.toLowerCase().compareTo(o1.toLowerCase());
            }
        });
        */
    }
}
