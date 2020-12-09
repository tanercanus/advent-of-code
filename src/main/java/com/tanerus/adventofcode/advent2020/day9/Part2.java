package com.tanerus.adventofcode.advent2020.day9;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

public class Part2 {
    public static void main(String[] args) {
        Long[] inputArray = Input.initializeValues();
        long errorValue = calculateWeaknessSum(inputArray, 25);
        System.out.println(errorValue);
    }

    private static long calculateWeaknessSum(Long[] inputArray, int backTraceCount) {
        int index = 0;
        Long selectedItem = 0l;
        for (int i = backTraceCount; i < inputArray.length; i++) {
            boolean isCorrectValue = false;
            selectedItem = inputArray[i];
            for (int j = i - backTraceCount; j < i; j++) {

                for (int k = i - backTraceCount; k < i; k++) {
                    if (k == j)
                        continue;

                    if (inputArray[j] + inputArray[k] == selectedItem) {
                        isCorrectValue = true;
                        break;
                    }

                }
                if (isCorrectValue) {
                    break;
                }


            }

            if (!isCorrectValue) {
                index = i;
                break;
            }

        }


        boolean isFound = false;
        int i;
        int j = 0;
        for (i = 0; i < index; i++) {
            j = i + 1;
            Long count = inputArray[i];

            if (count.compareTo(selectedItem) >= 0)
                continue;

            while (j < index && !isFound) {

                count += inputArray[j];
                if (count.equals(selectedItem)) {
                    isFound = true;
                } else if (count > selectedItem) {
                    break;
                }

                j++;
            }

            if (isFound)
                break;
        }

        Long[] newArray = Arrays.copyOfRange(inputArray, i, j);
        Optional<Long> min = Arrays.stream(newArray).min(Comparator.comparing(Long::longValue));
        Optional<Long> max = Arrays.stream(newArray).max(Comparator.comparing(Long::longValue));

        return min.get() + max.get();
    }
}
