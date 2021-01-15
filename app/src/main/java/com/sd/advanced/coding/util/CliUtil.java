package com.sd.advanced.coding.util;

import java.util.HashMap;
import java.util.Map;

public class CliUtil {
    public static Map<String, String> parseArguments(String... args) {
        Map<String, String> arguments = new HashMap<>();

        String key;

        for (int i = 0; i < args.length; i++) {
            if (args[i].startsWith("--")) {
                key = args[i].substring(2);
            } else {
                arguments.put(args[i], null);
                continue;
            }

            if ((i + 1) < args.length) {
                if (args[i + 1].charAt(0) != '-') {
                    arguments.put(key, args[i + 1]);
                    i++;
                } else {
                    arguments.put(args[i], null);
                }
            } else {
                arguments.put(args[i], null);
            }
        }
        return arguments;
    }
}
