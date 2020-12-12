package com.tanerus.adventofcode.advent2020.day12;

import java.util.List;

/*
* --- Part Two ---
Before you can give the destination to the captain, you realize that the actual action meanings were printed on the back of the instructions the whole time.

Almost all of the actions indicate how to move a waypoint which is relative to the ship's position:

Action N means to move the waypoint north by the given value.
Action S means to move the waypoint south by the given value.
Action E means to move the waypoint east by the given value.
Action W means to move the waypoint west by the given value.
Action L means to rotate the waypoint around the ship left (counter-clockwise) the given number of degrees.
Action R means to rotate the waypoint around the ship right (clockwise) the given number of degrees.
Action F means to move forward to the waypoint a number of times equal to the given value.
The waypoint starts 10 units east and 1 unit north relative to the ship. The waypoint is relative to the ship; that is, if the ship moves, the waypoint moves with it.

For example, using the same instructions as above:

F10 moves the ship to the waypoint 10 times (a total of 100 units east and 10 units north), leaving the ship at east 100, north 10. The waypoint stays 10 units east and 1 unit north of the ship.
N3 moves the waypoint 3 units north to 10 units east and 4 units north of the ship. The ship remains at east 100, north 10.
F7 moves the ship to the waypoint 7 times (a total of 70 units east and 28 units north), leaving the ship at east 170, north 38. The waypoint stays 10 units east and 4 units north of the ship.
R90 rotates the waypoint around the ship clockwise 90 degrees, moving it to 4 units east and 10 units south of the ship. The ship remains at east 170, north 38.
F11 moves the ship to the waypoint 11 times (a total of 44 units east and 110 units south), leaving the ship at east 214, south 72. The waypoint stays 4 units east and 10 units south of the ship.
After these operations, the ship's Manhattan distance from its starting position is 214 + 72 = 286.

Figure out where the navigation instructions actually lead. What is the Manhattan distance between that location and the ship's starting position?
* */
public class Part2 {
    public static void main(String[] args) {
        String fileName = "data/data_day12.txt";
        List<String> inputList = Part1.readInput(fileName);
        System.out.println(followDirections(inputList));
    }

    private static int followDirections(List<String> inputList) {

        int north = 0;
        int east = 0;

        // north, east positions
        int[] waypoint = {1, 10};

        for (int i = 0; i < inputList.size(); i++) {
            String selected = inputList.get(i);
            char directiveRoute = selected.charAt(0);
            int directiveValue = Integer.parseInt(selected.substring(1));
            switch (directiveRoute) {
                case 'N':
                    waypoint[0] = waypoint[0] + directiveValue;
                    break;
                case 'S':
                    waypoint[0] = waypoint[0] - directiveValue;
                    break;
                case 'E':
                    waypoint[1] = waypoint[1] + directiveValue;
                    break;
                case 'W':
                    waypoint[1] = waypoint[1] - directiveValue;
                    break;
                case 'L':
                    waypoint = calculateNewWayPoint(waypoint, 'L', directiveValue);
                    break;
                case 'R':
                    waypoint = calculateNewWayPoint(waypoint, 'R', directiveValue);
                    break;
                case 'F':
                    north += waypoint[0] * directiveValue;
                    east += waypoint[1] * directiveValue;
                    break;
            }

        }
        return Math.abs(north) + Math.abs(east);
    }

    public static int[] calculateNewWayPoint(int[] waypoint, char route, int degree) {

        int degreeRoute = degree / 90;
        int north = waypoint[0];
        int east = waypoint[1];
        switch (route) {
            case 'L':
                switch (degreeRoute) {
                    case 0:
                        return waypoint;
                    case 1:
                        north = waypoint[1];
                        east = waypoint[0] * -1;
                        break;
                    case 2:
                        north = waypoint[0] * -1;
                        east = waypoint[1] * -1;
                        break;
                    case 3:
                        north = waypoint[1] * -1;
                        east = waypoint[0];
                        break;
                }
                break;
            case 'R':
                switch (degreeRoute) {
                    case 0:
                        return waypoint;
                    case 1:
                        north = waypoint[1] * -1;
                        east = waypoint[0];
                        break;
                    case 2:
                        north = waypoint[0] * -1;
                        east = waypoint[1] * -1;
                        break;
                    case 3:
                        north = waypoint[1];
                        east = waypoint[0] * -1;
                        break;
                }
                break;
        }

        waypoint[0] = north;
        waypoint[1] = east;
        return waypoint;

    }
}
