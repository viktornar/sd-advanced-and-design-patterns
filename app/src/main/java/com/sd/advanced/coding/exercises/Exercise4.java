package com.sd.advanced.coding.exercises;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    Create a Storage class that will have a private Map field, a public constructor, and methods:
        addToStorage(String key, String value) → adding elements to the storage
        printValues(String key) → displaying all elements under a given key
        findValues(String value) → displaying all keys that have a given value
    The Storage class should allow you to store multiple values under one key.
*/
public class Exercise4 implements Exercise {
    @Override
    public void run() {
        Storage storage = new Storage();
        storage.addToStorage("key1", "value1");
        storage.addToStorage("key1", "value2");
        storage.addToStorage("key2", "value3");

        storage.findValues("value1");
        storage.findValues("value2");
        storage.findValues("value3");
    }

    private static class Storage {
        private final Map<String, List<String>> store = new HashMap<>();

        void addToStorage(String key, String value) {
            if (store.containsKey(key)) {
                store.get(key).add(value);
            } else {
                store.put(key, new ArrayList<>() {{ add(value); }});
            }
        }

        void printValues(String key) {
            System.out.println(store.get(key));
        }

        void findValues(String value) {
            store.forEach((k, v) -> {
                if (v.contains(value)) {
                    printValues(k);
                }
            });
        }
    }
}
