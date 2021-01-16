package com.sd.advanced.coding.exercises;

import com.sd.advanced.coding.util.FileUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    Write a program that will count the occurrences of each word in a text file
    and then display words count in console.
 */
public class Exercise6 implements Exercise {
    @Override
    public void run() {
        List<String> lines = FileUtil.readData("/home/viktornareiko/words.txt");

        Map<String, Integer> wordCounter = new HashMap<>();

        for (String line: lines) {
            String[] words = line.split(" ");
            for (String w: words) {
                if (wordCounter.containsKey(w)) {
                    wordCounter.put(w, wordCounter.get(w) + 1);
                } else {
                    wordCounter.put(w, 1);
                }
            }
        }

        for (Map.Entry<String, Integer> e: wordCounter.entrySet()) {
            System.out.printf("Word: %s - count: %d%n", e.getKey(), e.getValue());
        }
    }
}
