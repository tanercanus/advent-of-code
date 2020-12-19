package com.tanerus.adventofcode.advent2020.day18;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Part1 {

    /*
    * --- Day 18: Operation Order ---
    As you look out the window and notice a heavily-forested continent slowly appear over the horizon, you are interrupted by the child sitting next to you. They're curious if you could help them with their math homework.

    Unfortunately, it seems like this "math" follows different rules than you remember.

    The homework (your puzzle input) consists of a series of expressions that consist of addition (+), multiplication (*), and parentheses ((...)). Just like normal math, parentheses indicate that the expression inside must be evaluated before it can be used by the surrounding expression. Addition still finds the sum of the numbers on both sides of the operator, and multiplication still finds the product.

    However, the rules of operator precedence have changed. Rather than evaluating multiplication before addition, the operators have the same precedence, and are evaluated left-to-right regardless of the order in which they appear.

    For example, the steps to evaluate the expression 1 + 2 * 3 + 4 * 5 + 6 are as follows:

    1 + 2 * 3 + 4 * 5 + 6
      3   * 3 + 4 * 5 + 6
          9   + 4 * 5 + 6
             13   * 5 + 6
                 65   + 6
                     71
    Parentheses can override this order; for example, here is what happens if parentheses are added to form 1 + (2 * 3) + (4 * (5 + 6)):

    1 + (2 * 3) + (4 * (5 + 6))
    1 +    6    + (4 * (5 + 6))
         7      + (4 * (5 + 6))
         7      + (4 *   11   )
         7      +     44
                51
    Here are a few more examples:

    2 * 3 + (4 * 5) becomes 26.
    5 + (8 * 3 + 9 + 3 * 4 * 3) becomes 437.
    5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4)) becomes 12240.
    ((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2 becomes 13632.
    Before you can help with the homework, you need to understand it yourself. Evaluate the expression on each line of the homework; what is the sum of the resulting values?

    Your puzzle answer was
    * */
    public static void main(String[] args) {

        List<List<String>> parseInputList = readInput();

        for (int i = 0; i < parseInputList.size(); i++) {
            List<String> item = parseInputList.get(i);
            int closeParenthesisIndex = item.indexOf(")");
            int openParenthesisIndex;
            while (closeParenthesisIndex != -1) {
                openParenthesisIndex = item.subList(0, closeParenthesisIndex).lastIndexOf("(");
                List<String> changeItem = calculate(item, openParenthesisIndex, closeParenthesisIndex, false);
                parseInputList.set(i, changeItem);
                item = changeItem;
                closeParenthesisIndex = item.indexOf(")");
            }

            List<String> changeItem = calculate(item, -1, item.size(), true);
            parseInputList.set(i, changeItem);
        }

        System.out.println(parseInputList.stream().mapToLong(value -> Long.parseLong(value.get(0))).sum());

    }

    private static List<String> calculate(List<String> item, int openParenthesisIndex, int closeParenthesisIndex, boolean isLast) {

        long startVal = Long.parseLong(item.get(openParenthesisIndex + 1));
        for (int i = openParenthesisIndex + 3; i < closeParenthesisIndex; i = i + 2) {
            if (item.get(i - 1).equals("+")) {
                startVal += Long.parseLong(item.get(i));
            } else if (item.get(i - 1).equals("*")) {
                startVal *= Long.parseLong(item.get(i));
            }
        }

        List<String> changedList = new ArrayList<>();
        if (isLast) {
            changedList.add(String.valueOf(startVal));
        } else {
            changedList.addAll(item.subList(0, openParenthesisIndex));
            changedList.add(String.valueOf(startVal));
            changedList.addAll(item.subList((closeParenthesisIndex + 1), item.size()));
        }

        return changedList;
    }

    protected static List<List<String>> readInput() {
        String fileName = "data/data_day18.txt";
        List<String> input;
        try {
            input = Files.lines(Paths.get(fileName)).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        List<List<String>> parseInputList = new ArrayList<>();
        input.stream().forEach(
                item -> parseInputList.add(Arrays.stream(item.split(""))
                        .filter(x -> !" ".equals(x)).collect(Collectors.toList()))
        );
        return parseInputList;
    }

}
