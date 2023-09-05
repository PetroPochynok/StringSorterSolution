package com.example.stringsortersolution;

import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Marking will be based upon producing a readable, well engineered solution rather than factors
 * such as speed of processing or other performance-based optimizations, which are less
 * important.
 *
 *
 * Implement in single class.
 */
public class StringSorter {
    /**
     * The StringSorter class defines the contract for sorting strings based on
     * alphabetical order while skipping words that start with a specific prefix.
     *
     * Example:
     *  Input: ["apple", "banana", "grape", "avocado", "cherry"], Exception prefix: "a"
     *  Output: ["banana", "cherry", "grape", "avocado", "apple"]
     *
     *  Here, "banana", "cherry", and "grape" are sorted in alphabetical order
     *  whereas "avocado" and "apple" (that start with 'a') are sorted in reverse alphabetical order
     *  at the end of the list.
     */
    public List<String> sortStrings(List<String> unsortedStrings, String exceptionChar) {
        return unsortedStrings.stream()
                .sorted(createCustomComparator(exceptionChar))
                .collect(toList());
    }

    private Comparator<String> createCustomComparator(String exceptionChar) {
        return (str1, str2) -> {
            if (str1.startsWith(exceptionChar) && !str2.startsWith(exceptionChar)) {
                return 1;
            } else if (!str1.startsWith(exceptionChar) && str2.startsWith(exceptionChar)) {
                return -1;
            } else {
                return str1.compareTo(str2);
            }
        };
    }

    public static void main(String[] args) {
        StringSorter stringSorter = new StringSorter();
        List<String> unsortedList = List.of("apple", "banana", "grape", "avocado", "cherry");

        List<String> result = stringSorter.sortStrings(unsortedList, "a");
        result.forEach(System.out::println);
    }
}