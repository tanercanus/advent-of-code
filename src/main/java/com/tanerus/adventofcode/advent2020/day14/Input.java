package com.tanerus.adventofcode.advent2020.day14;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Input {

    public static List<InputWithMaskValue> input() {
        String fileName = "data/data_day14.txt";
        List<String> givenInput = readInput(fileName);

        boolean isEnd = false;
        int i = 0;

        List<InputWithMaskValue> inputWithMaskValues = new ArrayList<>();
        while (!isEnd) {
            InputWithMaskValue item = new InputWithMaskValue();
            item.setMask(givenInput.get(i).substring(7));

            i++;

            List<String> addedList = new ArrayList<>();
            boolean loopEnd = false;
            while (!loopEnd) {
                if (givenInput.get(i).contains("mask")) {
                    loopEnd = true;
                    //i--;
                } else if ((givenInput.size() - 1) == i) {
                    addedList.add(givenInput.get(i));
                    loopEnd = true;
                    isEnd = true;
                } else {
                    addedList.add(givenInput.get(i));
                    i++;
                }
            }

            item.setValues(addedList);
            inputWithMaskValues.add(item);
            /*if ( givenInput.size() - 1 == i)
                isEnd = true;*/

        }

        return inputWithMaskValues;

    }

    public static List<String> readInput(String fileName) {
        try {
            return Files.lines(Paths.get(fileName)).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    static class InputWithMaskValue {
        private String mask;
        private List<String> values = new ArrayList<>();

        public String getMask() {
            return mask;
        }

        public void setMask(String mask) {
            this.mask = mask;
        }

        public List<String> getValues() {
            return values;
        }

        public void setValues(List<String> values) {
            this.values = values;
        }
    }

}
