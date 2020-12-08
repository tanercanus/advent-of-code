package com.tanerus.adventofcode.advent2020.day1;

import java.util.ArrayList;
import java.util.List;
/*
* --- Part Two ---
The Elves in accounting are thankful for your help; one of them even offers you a starfish coin they had left over from a past vacation. They offer you a second one if you can find three numbers in your expense report that meet the same criteria.

Using the above example again, the three entries that sum to 2020 are 979, 366, and 675. Multiplying them together produces the answer, 241861950.

In your expense report, what is the product of the three entries that sum to 2020?
* */
public class Part2 {
    public static void main(String[] args) {

        List<Integer> total2020 = new ArrayList<>();

        Integer[] array = Input.inputArray;

        for (int i = 0; i < array.length; i++) {
            int result1 = array[i];
            for (int j = 0; j < array.length; j++) {
                if (i == j) {
                    continue;
                }
                int result2 = array[j];
                for (int k = 0; k < array.length; k++) {
                    if ( i == k || j == k ) {
                        continue;
                    }

                    if(result1+result2 + array[k] == 2020 ) {
                        int result3 = array[k];
                        int multipleResult = result1*result2*result3;
                        if ( !total2020.contains(multipleResult)) {
                            total2020.add(multipleResult);
                        }
                    }

                }

            }
        }

        int total = total2020.stream().reduce(0, Integer::sum);

        System.out.println(total);
    }
}
