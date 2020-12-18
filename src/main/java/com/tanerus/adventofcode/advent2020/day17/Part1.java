package com.tanerus.adventofcode.advent2020.day17;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
* --- Day 17: Conway Cubes ---
As your flight slowly drifts through the sky, the Elves at the Mythical Information Bureau at the North Pole contact you. They'd like some help debugging a malfunctioning experimental energy source aboard one of their super-secret imaging satellites.

The experimental energy source is based on cutting-edge technology: a set of Conway Cubes contained in a pocket dimension! When you hear it's having problems, you can't help but agree to take a look.

The pocket dimension contains an infinite 3-dimensional grid. At every integer 3-dimensional coordinate (x,y,z), there exists a single cube which is either active or inactive.

In the initial state of the pocket dimension, almost all cubes start inactive. The only exception to this is a small flat region of cubes (your puzzle input); the cubes in this region start in the specified active (#) or inactive (.) state.

The energy source then proceeds to boot up by executing six cycles.

Each cube only ever considers its neighbors: any of the 26 other cubes where any of their coordinates differ by at most 1. For example, given the cube at x=1,y=2,z=3, its neighbors include the cube at x=2,y=2,z=2, the cube at x=0,y=2,z=3, and so on.

During a cycle, all cubes simultaneously change their state according to the following rules:

If a cube is active and exactly 2 or 3 of its neighbors are also active, the cube remains active. Otherwise, the cube becomes inactive.
If a cube is inactive but exactly 3 of its neighbors are active, the cube becomes active. Otherwise, the cube remains inactive.
The engineers responsible for this experimental energy source would like you to simulate the pocket dimension and determine what the configuration of cubes should be at the end of the six-cycle boot process.

For example, consider the following initial state:

.#.
..#
###
Even though the pocket dimension is 3-dimensional, this initial state represents a small 2-dimensional slice of it. (In particular, this initial state defines a 3x3x1 region of the 3-dimensional space.)

Simulating a few cycles from this initial state produces the following configurations, where the result of each cycle is shown layer-by-layer at each given z coordinate (and the frame of view follows the active cells in each cycle):

Before any cycles:

z=0
.#.
..#
###


After 1 cycle:

z=-1
#..
..#
.#.

z=0
#.#
.##
.#.

z=1
#..
..#
.#.


After 2 cycles:

z=-2
.....
.....
..#..
.....
.....

z=-1
..#..
.#..#
....#
.#...
.....

z=0
##...
##...
#....
....#
.###.

z=1
..#..
.#..#
....#
.#...
.....

z=2
.....
.....
..#..
.....
.....


After 3 cycles:

z=-2
.......
.......
..##...
..###..
.......
.......
.......

z=-1
..#....
...#...
#......
.....##
.#...#.
..#.#..
...#...

z=0
...#...
.......
#......
.......
.....##
.##.#..
...#...

z=1
..#....
...#...
#......
.....##
.#...#.
..#.#..
...#...

z=2
.......
.......
..##...
..###..
.......
.......
.......
After the full six-cycle boot process completes, 112 cubes are left in the active state.

Starting with your given initial configuration, simulate six cycles. How many cubes are left in the active state after the sixth cycle?
* */
public class Part1 {

    public static void main(String[] args) {

        List<String> inputLines = input();

        solution(inputLines);

    }

    protected static List<String> input() {
        List<String> inputLines = new ArrayList<>();

        inputLines.add("..#..#.#");
        inputLines.add("##.#..#.");
        inputLines.add("#....#..");
        inputLines.add(".#..####");
        inputLines.add(".....#..");
        inputLines.add("...##...");
        inputLines.add(".#.##..#");
        inputLines.add(".#.#.#.#");

        return inputLines;
    }

    public static void solution(List<String> inputStrs) {
        Game initGame = new Game();
        for (int y = 0; y < inputStrs.size(); y++) {
            String s = inputStrs.get(y);
            for (int x = 0; x < s.length(); x++) {
                initGame.addLocation(new Location(x, y, 0, 0, s.charAt(x)));
            }
        }

        Game game = initGame;
        for (int i = 0; i < 6; i++) {
            Game newGame = new Game();
            int[] zRange = game.getZVals();
            int[] yRange = game.getYVals();
            int[] xRange = game.getXVals();
            for (int z = zRange[0] - 1; z <= zRange[1] + 1; z++) {
                for (int y = yRange[0] - 1; y <= yRange[1] + 1; y++) {
                    for (int x = xRange[0] - 1; x <= xRange[1] + 1; x++) {
                        int active = game.getNeighborActiveCount(x, y, z, 0);


                        if (game.isActive(x, y, z, 0)) {
                            if (active == 2 || active == 3) {
                                newGame.addLocation(new Location(x, y, z, 0, '#'));
                            } else {
                                newGame.addLocation(new Location(x, y, z, 0, '.'));
                            }
                        } else {
                            if (active == 3) {
                                newGame.addLocation(new Location(x, y, z, 0, '#'));
                            } else {
                                newGame.addLocation(new Location(x, y, z, 0, '.'));
                            }
                        }

                    }
                }
            }
            game = newGame;
        }

        System.out.println(game.getTotalActive());


    }

    protected static class Game {
        private List<Location> locations = new ArrayList<>();

        public void addLocation(Location loc) {
            locations.add(loc);
        }

        public boolean isActive(int x, int y, int z, int w) {
            for (Location location : locations)
                if (location.x == x && location.y == y && location.z == z && location.w == w)
                    return location.c == '#';
            return false;
        }

        public int getTotalActive() {
            int active = 0;
            for (Location location : locations)
                if (location.c == '#')
                    active++;
            return active;
        }

        public int getNeighborActiveCount(int x, int y, int z, int w) {
            int active = 0;
            for (int wOff = -1; wOff < 2; wOff++) {
                for (int zOff = -1; zOff < 2; zOff++) {
                    for (int yOff = -1; yOff < 2; yOff++) {
                        for (int xOff = -1; xOff < 2; xOff++) {
                            if (zOff == 0 && yOff == 0 && xOff == 0 && wOff == 0)
                                continue;

                            if (isActive(x + xOff, y + yOff, z + zOff, w + wOff)) {
                                active++;
                                if (active > 3)
                                    return active;
                            }
                        }
                    }
                }
            }
            return active;
        }

        public int[] getXVals() {
            int[] toReturn = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};

            for (Location location : locations) {
                if (location.x < toReturn[0]) {
                    toReturn[0] = location.x;
                }

                if (location.x > toReturn[1]) {
                    toReturn[1] = location.x;
                }
            }

            return toReturn;
        }

        public int[] getYVals() {
            int[] toReturn = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};

            for (Location location : locations) {
                if (location.y < toReturn[0]) {
                    toReturn[0] = location.y;
                }

                if (location.y > toReturn[1]) {
                    toReturn[1] = location.y;
                }
            }

            return toReturn;
        }

        public int[] getZVals() {
            int[] toReturn = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};

            for (Location location : locations) {
                if (location.z < toReturn[0]) {
                    toReturn[0] = location.z;
                }

                if (location.z > toReturn[1]) {
                    toReturn[1] = location.z;
                }
            }

            return toReturn;
        }

        public int[] getWVals() {
            int[] toReturn = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};

            for (Location location : locations) {
                if (location.w < toReturn[0]) {
                    toReturn[0] = location.w;
                }

                if (location.w > toReturn[1]) {
                    toReturn[1] = location.w;
                }
            }

            return toReturn;
        }
    }

    protected static class Location {
        public int x;
        public int y;
        public int z;
        public int w;
        public char c;

        public Location(int x, int y, int z, int w, char c) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.w = w;
            this.c = c;
        }
    }
    /**/

    public static void calculateNextValue() {

    }

    public static Set<Integer[]> allNeighbourPermutations(Integer[] values) {
        Set<Integer[]> permutations = new HashSet<>();
        permutations.add(values);
        for (int i = 0; i < values.length; i++) {
            int index = i;
            //loop through our list of current permutations, and replace each X with its two permutations of 0 & 1
            permutations = permutations.stream()
                    .flatMap(a -> {
                        //using flat map to make each array into 2 different ones
                        Integer[] scenario0 = Arrays.stream(a).toArray(Integer[]::new);
                        scenario0[index] = values[index] - 1;
                        Integer[] scenario1 = Arrays.stream(a).toArray(Integer[]::new);
                        scenario1[index] = values[index];
                        Integer[] scenario2 = a;
                        scenario2[index] = values[index] + 1;
                        return Stream.of(scenario0, scenario1, scenario2);
                    })
                    .collect(Collectors.toSet());
        }
        return permutations;
    }


}
