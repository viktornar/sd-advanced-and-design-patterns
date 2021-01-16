package com.sd.advanced.coding.exercises;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
Create a method that takes the map as a parameter, where the key is string and the value number, and then
prints each map element to the console in the format: Key: <k>, Value: <v>. There should be a comma at the
end of every line except the last, and a period at the last.
*/
public class Exercise3 implements Exercise {
    @Override
    public void run() {
        Map<String, Integer> store = new HashMap<>() {{
            put("Java", 18);
            put("Python", 1);
            put("PHP", 0);
        }};

        printEntries(store);
    }

    private void printEntries(Map<String, Integer> store) {
        Iterator<Map.Entry<String, Integer>> i = store.entrySet().iterator();

        do {
            Map.Entry<String, Integer> e = i.next();

            if (i.hasNext()) {
                System.out.printf("Key: %s, Value: %s,%n", e.getKey(), e.getValue());
            } else {
                System.out.printf("Key: %s, Value: %s.%n", e.getKey(), e.getValue());
            }

        } while (i.hasNext());
    }
}
