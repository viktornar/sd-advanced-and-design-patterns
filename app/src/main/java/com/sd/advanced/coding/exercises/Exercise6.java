package com.sd.advanced.coding.exercises;

import com.sd.advanced.coding.util.FileUtil;

import java.util.Arrays;
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

        lines.stream().flatMap(l -> Arrays.stream(l.split(" "))).forEach((w) -> {
            if (wordCounter.containsKey(w)) {
                wordCounter.put(w, wordCounter.get(w) + 1);
            } else {
                wordCounter.put(w, 1);
            }
        });

        wordCounter.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));
    }
}
