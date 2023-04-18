package io.github.vitaliynagai.string.function.tasks;

import java.util.*;

import static java.util.Arrays.sort;
import static java.util.Arrays.stream;

public class StringFunctions {
    public static String printIndexOfTheSameSymbolsInStringArray(String[] arrayOfStrings) {
        final Map<String, Integer> numberOfIncludedStringMap = new HashMap<>();
        final Map<String, String> indexOfIncludedStringMap = new HashMap<>();

        // calculate the number of unique strings
        stream(arrayOfStrings).forEach(eachString -> {
            char [] charArrayOfString = eachString.toCharArray();
            sort(charArrayOfString);
            String sortedStr = new String(charArrayOfString);

            int numberOfStrings = numberOfIncludedStringMap.get(sortedStr) == null ? 0 : numberOfIncludedStringMap.get(sortedStr);
            numberOfIncludedStringMap.put(sortedStr, ++numberOfStrings);
        });

        // find indexes of repeated element in the input array
        for (int i = 0; i < arrayOfStrings.length; i++) {
            for (Map.Entry<String, Integer> entry : numberOfIncludedStringMap.entrySet()) {
                String entryKeyStr = entry.getKey();

                // prepare/sort each element in arrayOfStrings to use in comparison later on
                char [] sortedArray = arrayOfStrings[i].toCharArray();
                sort(sortedArray);

                // compare each char in the input array with each char in numberOfIncludedStringMap keys
                if (Arrays.equals(entryKeyStr.toCharArray(), sortedArray)) {
                    String indexes = indexOfIncludedStringMap.get(entryKeyStr);
                    if (indexes == null) {
                        indexes = "";
                    }
                    indexes += (i + "; ");
                    Integer count = entry.getValue();
                    if (count >= 2) {
                        indexOfIncludedStringMap.put(entryKeyStr, indexes);
                    }
                }
            }
        }

        StringBuilder finalStringResult = new StringBuilder();

        // print results
        for (Map.Entry<String, Integer> entry : numberOfIncludedStringMap.entrySet()) {
            String str = entry.getKey();

            String indexes = indexOfIncludedStringMap.get(str);
            if (indexes != null) {
                finalStringResult.append(str).append(" = ").append(indexes);
            }
        }
        System.out.println(finalStringResult);
        return finalStringResult.toString();

    }
}