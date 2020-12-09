package com.tanerus.adventofcode.advent2020.day4;

import java.util.List;

public class Part2 {
    public static void main(String[] args) {
        String[] inputArray = Input.initializeString();
        List<Passport> passportList = Part1.createAllPassport(inputArray, true);
        long count = Part1.validPasswordsCount(passportList);
        System.out.println(count);
    }
}
