package com.tanerus.adventofcode.advent2020.day6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
* --- Part Two ---
As you finish the last group's customs declaration, you notice that you misread one word in the instructions:

You don't need to identify the questions to which anyone answered "yes"; you need to identify the questions to which everyone answered "yes"!

Using the same example as above:

abc

a
b
c

ab
ac

a
a
a
a

b
This list represents answers from five groups:

In the first group, everyone (all 1 person) answered "yes" to 3 questions: a, b, and c.
In the second group, there is no question to which everyone answered "yes".
In the third group, everyone answered yes to only 1 question, a. Since some people did not answer "yes" to b or c, they don't count.
In the fourth group, everyone answered yes to only 1 question, a.
In the fifth group, everyone (all 1 person) answered "yes" to 1 question, b.
In this example, the sum of these counts is 3 + 0 + 1 + 1 + 1 = 6.

For each group, count the number of questions to which everyone answered "yes". What is the sum of those counts?
* */
public class Part2 {

    public static void main(String[] args) {
        String fileName = "data/data_day6.txt";
        List<String> inputList = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            inputList = stream
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Integer> groupAnswers = calculateGroupAnswerCorrect(inputList);
        System.out.println(groupAnswers.stream().mapToInt(x -> x).sum());
    }

    public static List<Integer> calculateGroupAnswerCorrect(List<String> inputList) {
        List<Integer> groupAnswers = new ArrayList<>();

        Map<Character, Integer> groupChars = new HashMap<>();
        int countIntGroup = 0;
        for (int i = 0; i < inputList.size(); i++) {
            int countIntGroupEff = countIntGroup;
            if ("".equals(inputList.get(i)) ||
                    i == inputList.size() - 1) {
                groupAnswers.add((int) groupChars.entrySet().stream().
                        filter(map -> map.getValue() == countIntGroupEff)
                        .count());
                groupChars = new HashMap<>();
                countIntGroup = 0;
            } else {
                countIntGroup++;
            }


            char[] charArray = inputList.get(i).toCharArray();
            for (int j = 0; j < charArray.length; j++) {

                if (groupChars.get(charArray[j]) != null) {
                    groupChars.put(charArray[j], groupChars.get(charArray[j]) + 1);
                } else {
                    groupChars.put(charArray[j], 1);
                }

            }

        }


        return groupAnswers;

    }

}
