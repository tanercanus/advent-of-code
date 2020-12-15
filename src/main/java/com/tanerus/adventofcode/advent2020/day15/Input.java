package com.tanerus.adventofcode.advent2020.day15;

import java.util.Arrays;
import java.util.List;

public class Input {
    protected static List<Integer> input(int fixedSize) {
        List<Integer> input = Arrays.asList(new Integer[fixedSize]);
        input.set(0, 9);
        input.set(1, 6);
        input.set(2, 0);
        input.set(3, 10);
        input.set(4, 18);
        input.set(5, 2);
        input.set(6, 1);
        return input;
    }
}
