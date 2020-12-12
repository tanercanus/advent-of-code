package com.tanerus.adventofcode.advent2020.day12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
/*
* --- Day 12: Rain Risk ---
Your ferry made decent progress toward the island, but the storm came in faster than anyone expected. The ferry needs to take evasive actions!

Unfortunately, the ship's navigation computer seems to be malfunctioning; rather than giving a route directly to safety, it produced extremely circuitous instructions. When the captain uses the PA system to ask if anyone can help, you quickly volunteer.

The navigation instructions (your puzzle input) consists of a sequence of single-character actions paired with integer input values. After staring at them for a few minutes, you work out what they probably mean:

Action N means to move north by the given value.
Action S means to move south by the given value.
Action E means to move east by the given value.
Action W means to move west by the given value.
Action L means to turn left the given number of degrees.
Action R means to turn right the given number of degrees.
Action F means to move forward by the given value in the direction the ship is currently facing.
The ship starts by facing east. Only the L and R actions change the direction the ship is facing. (That is, if the ship is facing east and the next instruction is N10, the ship would move north 10 units, but would still move east if the following action were F.)

For example:

F10
N3
F7
R90
F11
These instructions would be handled as follows:

F10 would move the ship 10 units east (because the ship starts by facing east) to east 10, north 0.
N3 would move the ship 3 units north to east 10, north 3.
F7 would move the ship another 7 units east (because the ship is still facing east) to east 17, north 3.
R90 would cause the ship to turn right by 90 degrees and face south; it remains at east 17, north 3.
F11 would move the ship 11 units south to east 17, south 8.
At the end of these instructions, the ship's Manhattan distance (sum of the absolute values of its east/west position and its north/south position) from its starting position is 17 + 8 = 25.

Figure out where the navigation instructions lead. What is the Manhattan distance between that location and the ship's starting position?

Your puzzle answer was 1441.

The first half of this puzzle is complete! It provides one gold star: *
* */
public class Part1 {
    public static void main(String[] args) {
        String fileName = "data/data_day12.txt";
        List<String> inputList = readInput(fileName);

        System.out.println(followDirections(inputList));

    }

    private static int followDirections(List<String> inputList) {

        int north = 0;
        int east = 0;

        //north=0, east=1, south=2, west=3
        int shipFacing = 1;

        for (int i = 0; i < inputList.size(); i++) {
            String selected = inputList.get(i);
            char directiveRoute = selected.charAt(0);
            int directiveValue = Integer.parseInt(selected.substring(1));
            switch (directiveRoute) {
                case 'N':
                    north += directiveValue;
                    break;
                case 'S':
                    north -= directiveValue;
                    break;
                case 'E':
                    east += directiveValue;
                    break;
                case 'W':
                    east -= directiveValue;
                    break;
                case 'L':
                    shipFacing = calculateShipFacing(shipFacing, 'L', directiveValue);
                    break;
                case 'R':
                    shipFacing = calculateShipFacing(shipFacing, 'R', directiveValue);
                    break;
                case 'F':
                    switch (shipFacing) {
                        case 0:
                            north += directiveValue;
                            break;
                        case 1:
                            east += directiveValue;
                            break;
                        case 2:
                            north -= directiveValue;
                            break;
                        case 3:
                            east -= directiveValue;
                            break;
                    }
                    break;
            }
        }

        return Math.abs(north) + Math.abs(east);

    }

    public static int calculateShipFacing(int shipFacing, char route, int degree) {
        int degreeRoute = degree / 90;
        switch (route){
            case 'L':

                shipFacing = (shipFacing - degreeRoute) % 4;
                if ( shipFacing < 0) {
                    shipFacing +=4;
                }

                return shipFacing;
            case 'R':

                shipFacing = (shipFacing + degreeRoute) % 4;
                return shipFacing;

        }
        return 0;
    }

    public static List<String> readInput(String fileName) {
        try {
            return Files.lines(Paths.get(fileName)).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
