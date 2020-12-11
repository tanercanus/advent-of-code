package com.tanerus.adventofcode.advent2020.day11;

import java.util.List;

/*
--- Part Two ---
As soon as people start to arrive, you realize your mistake. People don't just care about adjacent seats - they care about the first seat they can see in each of those eight directions!

Now, instead of considering just the eight immediately adjacent seats, consider the first seat in each of those eight directions. For example, the empty seat below would see eight occupied seats:

.......#.
...#.....
.#.......
.........
..#L....#
....#....
.........
#........
...#.....
The leftmost empty seat below would only see one empty seat, but cannot see any of the occupied ones:

.............
.L.L.#.#.#.#.
.............
The empty seat below would see no occupied seats:

.##.##.
#.#.#.#
##...##
...L...
##...##
#.#.#.#
.##.##.
Also, people seem to be more tolerant than you expected: it now takes five or more visible occupied seats for an occupied seat to become empty (rather than four or more from the previous rules). The other rules still apply: empty seats that see no occupied seats become occupied, seats matching no rule don't change, and floor never changes.

Given the same starting layout as above, these new rules cause the seating area to shift around as follows:

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
#.LL.LL.L#
#LLLLLL.LL
L.L.L..L..
LLLL.LL.LL
L.LL.LL.LL
L.LLLLL.LL
..L.L.....
LLLLLLLLL#
#.LLLLLL.L
#.LLLLL.L#
#.L#.##.L#
#L#####.LL
L.#.#..#..
##L#.##.##
#.##.#L.##
#.#####.#L
..#.#.....
LLL####LL#
#.L#####.L
#.L####.L#
#.L#.L#.L#
#LLLLLL.LL
L.L.L..#..
##LL.LL.L#
L.LL.LL.L#
#.LLLLL.LL
..L.L.....
LLLLLLLLL#
#.LLLLL#.L
#.L#LL#.L#
#.L#.L#.L#
#LLLLLL.LL
L.L.L..#..
##L#.#L.L#
L.L#.#L.L#
#.L####.LL
..#.#.....
LLL###LLL#
#.LLLLL#.L
#.L#LL#.L#
#.L#.L#.L#
#LLLLLL.LL
L.L.L..#..
##L#.#L.L#
L.L#.LL.L#
#.LLLL#.LL
..#.L.....
LLL###LLL#
#.LLLLL#.L
#.L#LL#.L#
Again, at this point, people stop shifting around and the seating area reaches equilibrium. Once this occurs, you count 26 occupied seats.

Given the new visibility method and the rule change for occupied seats becoming empty, once equilibrium is reached, how many seats end up occupied?
* */
public class Part2 {
    private static int count = 0;

    public static void main(String[] args) {
        String fileName = "data/data_day11.txt";
        List<List<Character>> inputList = Part1.readInput(fileName);
        List<List<Character>> lastList = Util.iterateOverTheList(inputList, true);

        lastList.stream().forEach(x -> x.forEach(y -> {
            if (y.equals('#')) {
                count++;
            }
        }));
        System.out.println(count);
    }

    public static Character checkCondition(int i, int j, List<List<Character>> lastList, List<List<Character>> temporaryList) {
        Character selectedChar = lastList.get(i).get(j);

        // 0 is empty 1 is occupied
        int left = 0;
        if (j > 0) {
            if ((lastList.get(i).get(j - 1)).equals('#')) {
                left = 1;
            } else if ((lastList.get(i).get(j - 1)).equals('.')) {
                for (int dummyJ = j; dummyJ > 0; dummyJ--) {
                    Character sChar = lastList.get(i).get(dummyJ - 1);
                    if (!sChar.equals('.')) {
                        if (sChar.equals('#')) {
                            left = 1;
                        }
                        break;
                    }
                }
            }
        }
        int uLeft = 0;
        if (i > 0 && j > 0) {
            switch ((lastList.get(i - 1).get(j - 1))) {
                case '#':
                    uLeft = 1;
                    break;
                case '.':

                    for (int dummyI = i, dummyJ = j; dummyI > 0 && dummyJ > 0; dummyI--, dummyJ--) {
                        Character sChar = lastList.get(dummyI - 1).get(dummyJ - 1);
                        if (!sChar.equals('.')) {
                            if (sChar.equals('#')) {
                                uLeft = 1;
                            }
                            break;
                        }
                    }
                    break;
            }
        }

        int dLeft = 0;
        if (i < lastList.size() - 1 && j > 0) {

            switch (lastList.get(i + 1).get(j - 1)) {
                case '#':
                    dLeft = 1;
                    break;
                case '.':

                    for (int dummyI = i, dummyJ = j; dummyI < lastList.size() - 1 && dummyJ > 0; dummyI++, dummyJ--) {
                        Character sChar = lastList.get(dummyI + 1).get(dummyJ - 1);
                        if (!sChar.equals('.')) {
                            if (sChar.equals('#')) {
                                dLeft = 1;
                            }
                            break;
                        }
                    }
                    break;
            }

        }

        int upper = 0;
        if (i > 0) {

            switch (lastList.get(i - 1).get(j)) {
                case '#':
                    upper = 1;
                    break;
                case '.':

                    for (int dummyI = i; dummyI > 0; dummyI--) {
                        Character sChar = lastList.get(dummyI - 1).get(j);
                        if (!sChar.equals('.')) {
                            if (sChar.equals('#')) {
                                upper = 1;
                            }
                            break;
                        }
                    }
                    break;
            }

        }

        int down = 0;
        if (i < lastList.size() - 1) {
            down = (lastList.get(i + 1).get(j)).equals('#') ? 1 : 0;

            switch (lastList.get(i + 1).get(j)) {
                case '#':
                    down = 1;
                    break;
                case '.':

                    for (int dummyI = i; dummyI < lastList.size() - 1; dummyI++) {
                        Character sChar = lastList.get(dummyI + 1).get(j);
                        if (!sChar.equals('.')) {
                            if (sChar.equals('#')) {
                                down = 1;
                            }
                            break;
                        }
                    }
                    break;
            }

        }

        int right = 0;
        if (j < lastList.get(i).size() - 1) {

            switch (lastList.get(i).get(j + 1)) {
                case '#':
                    right = 1;
                    break;
                case '.':

                    for (int dummyJ = j; dummyJ < lastList.get(i).size() - 1; dummyJ++) {
                        Character sChar = lastList.get(i).get(dummyJ + 1);
                        if (!sChar.equals('.')) {
                            if (sChar.equals('#')) {
                                right = 1;
                            }
                            break;
                        }
                    }
                    break;
            }
        }

        int uRight = 0;
        if (j < lastList.get(i).size() - 1 && i > 0) {
            uRight = (lastList.get(i - 1).get(j + 1)).equals('#') ? 1 : 0;

            switch (lastList.get(i - 1).get(j + 1)) {
                case '#':
                    uRight = 1;
                    break;
                case '.':

                    for (int dummyI = i, dummyJ = j; dummyI > 0 && dummyJ < lastList.get(i).size() - 1; dummyI--, dummyJ++) {
                        Character sChar = lastList.get(dummyI - 1).get(dummyJ + 1);
                        if (!sChar.equals('.')) {
                            if (sChar.equals('#')) {
                                uRight = 1;
                            }
                            break;
                        }
                    }
                    break;
            }

        }

        int dRight = 0;
        if (j < lastList.get(i).size() - 1 && i < lastList.size() - 1) {

            switch (lastList.get(i + 1).get(j + 1)) {
                case '#':
                    dRight = 1;
                    break;
                case '.':

                    for (int dummyI = i, dummyJ = j; dummyI < lastList.size() - 1 && dummyJ < lastList.get(i).size() - 1; dummyI++, dummyJ++) {
                        Character sChar = lastList.get(dummyI + 1).get(dummyJ + 1);
                        if (!sChar.equals('.')) {
                            if (sChar.equals('#')) {
                                dRight = 1;
                            }
                            break;
                        }
                    }
                    break;
            }

        }

        int total = left + uLeft + dLeft + upper + down + right + uRight + dRight;
        switch (selectedChar) {
            case 'L':

                if (total == 0) {
                    return '#';
                }
                return 'L';
            case '#':
                if (total >= 5) {
                    return 'L';
                }
                return '#';
            //case '.':
            default:
                return '.';
        }


    }

}
