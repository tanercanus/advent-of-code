package com.tanerus.adventofcode.advent2020.day3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Util {

    public static void convertInput(String[] inputStrings, List<List<String>> list) {
        Arrays.stream(inputStrings).forEach(str -> {
            list.add(Stream.of(str.split(""))
                    .collect(Collectors.toList()));
        });
    }

}
