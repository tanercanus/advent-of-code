package com.tanerus.adventofcode.advent2020.day15;

import java.util.List;

/*
* --- Part Two ---
Impressed, the Elves issue you a challenge: determine the 30000000th number spoken. For example, given the same starting numbers as above:

Given 0,3,6, the 30000000th number spoken is 175594.
Given 1,3,2, the 30000000th number spoken is 2578.
Given 2,1,3, the 30000000th number spoken is 3544142.
Given 1,2,3, the 30000000th number spoken is 261214.
Given 2,3,1, the 30000000th number spoken is 6895259.
Given 3,2,1, the 30000000th number spoken is 18.
Given 3,1,2, the 30000000th number spoken is 362.
Given your starting numbers, what will be the 30000000th number spoken?

Your puzzle answer was 3745954.

Both parts of this puzzle are complete! They provide two gold stars: **

At this point, you should return to your Advent calendar and try another puzzle.

Your puzzle input was 9,6,0,10,18,2,1.
* */
public class Part2 {
    public static void main(String[] args) {
        int fixesSize = 30_000_000;
        List<Integer> input = Input.input(fixesSize);
        System.out.println(Part1.calculateNextValue(input, fixesSize));
    }
}
