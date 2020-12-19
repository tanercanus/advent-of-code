package com.tanerus.adventofcode.advent2020.day18;

import java.util.ArrayList;
import java.util.List;

/*
* --- Part Two ---
You manage to answer the child's questions and they finish part 1 of their homework, but get stuck when they reach the next section: advanced math.

Now, addition and multiplication have different precedence levels, but they're not the ones you're familiar with. Instead, addition is evaluated before multiplication.

For example, the steps to evaluate the expression 1 + 2 * 3 + 4 * 5 + 6 are now as follows:

1 + 2 * 3 + 4 * 5 + 6
  3   * 3 + 4 * 5 + 6
  3   *   7   * 5 + 6
  3   *   7   *  11
     21       *  11
         231
Here are the other examples from above:

1 + (2 * 3) + (4 * (5 + 6)) still becomes 51.
2 * 3 + (4 * 5) becomes 46.
5 + (8 * 3 + 9 + 3 * 4 * 3) becomes 1445.
5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4)) becomes 669060.
((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2 becomes 23340.
What do you get if you add up the results of evaluating the homework problems using these new rules?
* */
public class Part2 {
    public static void main(String[] args) {
        List<List<String>> parseInputList = Part1.readInput();

        for (int i = 0; i < parseInputList.size(); i++) {
            List<String> item = parseInputList.get(i);
            int closeParenthesisIndex = item.indexOf(")");
            int openParenthesisIndex;
            while (closeParenthesisIndex != -1) {
                openParenthesisIndex = item.subList(0, closeParenthesisIndex).lastIndexOf("(");
                List<String> changeItem = calculateExtra(item, openParenthesisIndex, closeParenthesisIndex, false);
                parseInputList.set(i, changeItem);
                item = changeItem;
                closeParenthesisIndex = item.indexOf(")");
            }

            List<String> changeItem = calculateExtra(item, -1, item.size(), true);
            parseInputList.set(i, changeItem);
        }

        System.out.println(parseInputList.stream().mapToLong(value -> Long.parseLong(value.get(0))).sum());
    }

    private static List<String> calculateExtra(List<String> item, int openParenthesisIndex, int closeParenthesisIndex, boolean isLast) {

        List<String> subList = item.subList(openParenthesisIndex + 1, closeParenthesisIndex);
        while (subList.size() != 1) {
            int indexSumSign = subList.indexOf("+");
            if (indexSumSign != -1) {
                long val = Long.parseLong(subList.get(indexSumSign - 1)) + Long.parseLong(subList.get(indexSumSign + 1));
                subList.set((indexSumSign - 1), String.valueOf(val));
                subList.remove(indexSumSign);
                subList.remove(indexSumSign);
            } else {
                int indexMultipleSign = subList.indexOf("*");
                long val = Long.parseLong(subList.get(indexMultipleSign - 1)) * Long.parseLong(subList.get(indexMultipleSign + 1));
                subList.set((indexMultipleSign - 1), String.valueOf(val));
                subList.remove(indexMultipleSign);
                subList.remove(indexMultipleSign);
            }
        }

        List<String> changedList = new ArrayList<>();
        if (isLast) {
            changedList.addAll(subList);
        } else {
            changedList.addAll(item.subList(0, openParenthesisIndex));
            changedList.addAll(subList);
            changedList.addAll(item.subList((openParenthesisIndex + 3), item.size()));
        }

        return changedList;
    }
}
