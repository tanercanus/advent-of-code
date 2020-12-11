package com.tanerus.adventofcode.advent2020.day11;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Util {

    public static List<List<Character>> iterateOverTheList(List<List<Character>> startList, boolean isNewRule) {
        List<List<Character>> lastList = startList;

        List<List<Character>> temporaryList = new ArrayList<>();

        boolean isEnd = false;
        while (!isEnd) {
            isEnd = true;
            for (int i = 0; i < lastList.size(); i++) {
                List<Character> charList = new ArrayList<>();
                for (int j = 0; j < lastList.get(i).size(); j++) {
                    Character character;
                    if (!isNewRule) {
                        character = Part1.checkCondition(i, j, lastList, temporaryList);
                    } else {
                        character = Part2.checkCondition(i, j, lastList, temporaryList);
                    }
                    charList.add(character);

                    if (!lastList.get(i).get(j).equals(character)) {
                        isEnd = false;
                    }

                }
                temporaryList.add(charList);
            }

            lastList = temporaryList.stream().collect(Collectors.toList());

            temporaryList = new ArrayList<>();
            /*System.out.println("--------");
            printTheSeats(lastList);*/

        }

        return lastList;
    }

    public static void printTheSeats(List<List<Character>> list) {
        list.stream().forEach(
                x -> {
                    System.out.println();
                    System.out.print(x);
                });
    }

}
