package com.tanerus.adventofcode.advent2020.day11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/*
* --- Day 11: Seating System ---
Your plane lands with plenty of time to spare. The final leg of your journey is a ferry that goes directly to the tropical island where you can finally start your vacation. As you reach the waiting area to board the ferry, you realize you're so early, nobody else has even arrived yet!

By modeling the process people use to choose (or abandon) their seat in the waiting area, you're pretty sure you can predict the best place to sit. You make a quick map of the seat layout (your puzzle input).

The seat layout fits neatly on a grid. Each position is either floor (.), an empty seat (L), or an occupied seat (#). For example, the initial seat layout might look like this:

L.LL.LL.LL
LLLLLLL.LL
L.L.L..L..
LLLL.LL.LL
L.LL.LL.LL
L.LLLLL.LL
..L.L.....
LLLLLLLLLL
L.LLLLLL.L
L.LLLLL.LL
Now, you just need to model the people who will be arriving shortly. Fortunately, people are entirely predictable and always follow a simple set of rules. All decisions are based on the number of occupied seats adjacent to a given seat (one of the eight positions immediately up, down, left, right, or diagonal from the seat). The following rules are applied to every seat simultaneously:

If a seat is empty (L) and there are no occupied seats adjacent to it, the seat becomes occupied.
If a seat is occupied (#) and four or more seats adjacent to it are also occupied, the seat becomes empty.
Otherwise, the seat's state does not change.
Floor (.) never changes; seats don't move, and nobody sits on the floor.

After one round of these rules, every seat in the example layout becomes occupied:

#.##.##.##
#######.##
#.#.#..#..
####.##.##
#.##.##.##
#.#####.##
..#.#.....
##########
#.######.#
#.#####.##
After a second round, the seats with four or more occupied adjacent seats become empty again:

#.LL.L#.##
#LLLLLL.L#
L.L.L..L..
#LLL.LL.L#
#.LL.LL.LL
#.LLLL#.##
..L.L.....
#LLLLLLLL#
#.LLLLLL.L
#.#LLLL.##
This process continues for three more rounds:

#.##.L#.##
#L###LL.L#
L.#.#..#..
#L##.##.L#
#.##.LL.LL
#.###L#.##
..#.#.....
#L######L#
#.LL###L.L
#.#L###.##
#.#L.L#.##
#LLL#LL.L#
L.L.L..#..
#LLL.##.L#
#.LL.LL.LL
#.LL#L#.##
..L.L.....
#L#LLLL#L#
#.LLLLLL.L
#.#L#L#.##
#.#L.L#.##
#LLL#LL.L#
L.#.L..#..
#L##.##.L#
#.#L.LL.LL
#.#L#L#.##
..L.L.....
#L#L##L#L#
#.LLLLLL.L
#.#L#L#.##
At this point, something interesting happens: the chaos stabilizes and further applications of these rules cause no seats to change state! Once people stop moving around, you count 37 occupied seats.

Simulate your seating area by applying the seating rules repeatedly until no seats change state. How many seats end up occupied?

Your puzzle answer was 2441.

The first half of this puzzle is complete! It provides one gold star: *
* */
public class Part1 {
    private static int count = 0;

    public static void main(String[] args) {
        String fileName = "data/data_day11.txt";
        List<List<Character>> inputList = readInput(fileName);
        List<List<Character>> lastList = Util.iterateOverTheList(inputList, false);

        lastList.stream().forEach(x -> x.forEach(y -> {
            if (y.equals('#')) {
                count++;
            }
        }));
        System.out.println(count);
    }

    public static List<List<Character>> readInput(String fileName) {
        List<List<Character>> list = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {


            stream.forEach(
                    str -> {
                        List<Character> chars = str
                                .chars()
                                .mapToObj(e -> (char) e)
                                .collect(Collectors.toList());
                        list.add(chars);
                    }
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }



    public static Character checkCondition(int i, int j, List<List<Character>> lastList, List<List<Character>> temporaryList) {
        Character selectedChar = lastList.get(i).get(j);

        // 0 is empty 1 is occupied
        int left = 0;
        if (j > 0) {
            left = (lastList.get(i).get(j - 1)).equals('#') ? 1 : 0;
        }
        int uLeft = 0;
        if (i > 0 && j > 0) {
            uLeft = (lastList.get(i - 1).get(j - 1)).equals('#') ? 1 : 0;
        }

        int dLeft = 0;
        if (i < lastList.size() - 1 && j > 0) {
            dLeft = (lastList.get(i + 1).get(j - 1)).equals('#') ? 1 : 0;
        }

        int upper = 0;
        if (i > 0) {
            upper = (lastList.get(i - 1).get(j)).equals('#') ? 1 : 0;
        }

        int down = 0;
        if (i < lastList.size() - 1) {
            down = (lastList.get(i + 1).get(j)).equals('#') ? 1 : 0;
        }

        int right = 0;
        if (j < lastList.get(i).size() - 1) {
            right = (lastList.get(i).get(j + 1)).equals('#') ? 1 : 0;
        }

        int uRight = 0;
        if (j < lastList.get(i).size() - 1 && i > 0) {
            uRight = (lastList.get(i - 1).get(j + 1)).equals('#') ? 1 : 0;
        }

        int dRight = 0;
        if (j < lastList.get(i).size() - 1 && i < lastList.size() - 1) {
            dRight = (lastList.get(i + 1).get(j + 1)).equals('#') ? 1 : 0;
        }

        int total = left + uLeft + dLeft + upper + down + right + uRight + dRight;
        switch (selectedChar) {
            case 'L':

                if (total == 0) {
                    return '#';
                }
                return 'L';
            case '#':
                if (total >= 4) {
                    return 'L';
                }
                return '#';
            //case '.':
            default:
                return '.';
        }

    }

}
