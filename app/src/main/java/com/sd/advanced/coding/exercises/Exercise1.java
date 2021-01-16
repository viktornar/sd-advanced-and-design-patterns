package com.sd.advanced.coding.exercises;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
Create a method that takes a string list as a parameter,
then returns the list sorted alphabetically from Z to A.
 */
public class Exercise1 implements Exercise {
    @Override
    public void run() {
        List<String> listToSort = Arrays.asList(
                "Jonas",
                "jaunas",
                "Benas",
                "Vitalijus",
                "Zebra"
        );

        sortDescString(listToSort);

        System.out.println(listToSort);
    }

    private void sortDescString(final List<String> listToSort) {
        listToSort.sort(Comparator.reverseOrder());
        /*
        listToSort.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        */

        /*
        listToSort.sort((o1, o2) -> o2.compareTo(o1));
        */
    }
}
