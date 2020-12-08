package com.tanerus.adventofcode.advent2020.day1;

import java.util.ArrayList;
import java.util.List;
/*
* --- Day 1: Report Repair ---
After saving Christmas five years in a row, you've decided to take a vacation at a nice resort on a tropical island. Surely, Christmas will go on without you.

The tropical island has its own currency and is entirely cash-only. The gold coins used there have a little picture of a starfish; the locals just call them stars. None of the currency exchanges seem to have heard of them, but somehow, you'll need to find fifty of these coins by the time you arrive so you can pay the deposit on your room.

To save your vacation, you need to get all fifty stars by December 25th.

Collect stars by solving puzzles. Two puzzles will be made available on each day in the Advent calendar; the second puzzle is unlocked when you complete the first. Each puzzle grants one star. Good luck!

Before you leave, the Elves in accounting just need you to fix your expense report (your puzzle input); apparently, something isn't quite adding up.

Specifically, they need you to find the two entries that sum to 2020 and then multiply those two numbers together.

For example, suppose your expense report contained the following:

1721
979
366
299
675
1456
In this list, the two entries that sum to 2020 are 1721 and 299. Multiplying them together produces 1721 * 299 = 514579, so the correct answer is 514579.

Of course, your expense report is much larger. Find the two entries that sum to 2020; what do you get if you multiply them together?

Your puzzle answer was 145875.
* */
public class Part1 {

    public static void main(String[] args) {

        List<Integer> total2020 = new ArrayList<>();

        Integer[] array = Input.inputArray;

        for (int i=0; i<array.length; i++) {
            int result1 = array[i];
            for(int j=0; j<array.length; j++) {
                if ( i == j )
                    continue;
                if(result1+array[j] == 2020 ) {
                    int result2 = array[j];
                    int multipleResult = result1*result2;
                    if ( !total2020.contains(multipleResult)) {
                        total2020.add(multipleResult);
                    }
                }
            }
        }

        int total = total2020.stream().reduce(0, Integer::sum);

        System.out.println(total);

    }

}
