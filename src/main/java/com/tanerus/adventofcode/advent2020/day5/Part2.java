package com.tanerus.adventofcode.advent2020.day5;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
* --- Part Two ---
Ding! The "fasten seat belt" signs have turned on. Time to find your seat.

It's a completely full flight, so your seat should be the only missing boarding pass in your list. However, there's a catch: some of the seats at the very front and back of the plane don't exist on this aircraft, so they'll be missing from your list as well.

Your seat wasn't at the very front or back, though; the seats with IDs +1 and -1 from yours will be in your list.

What is the ID of your seat?
* */
public class Part2 {
    public static void main(String[] args) {
        String fileName = "data/data_day5.txt";
        List<String> list = Part1.readInput(fileName);
        List<Integer> orderedSeatIds = calculateAllSeatsInAlist(list);
        System.out.println(missingSeatId(orderedSeatIds));
    }

    public static List<Integer> calculateAllSeatsInAlist(List<String> list) {
        List<Integer> seatIds = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            String[] seatValues = list.get(i).trim().split("");

            int rowFirst = 0;
            int rowEnd = 127;
            for (int j = 0; j < 7; j++) {
                if (seatValues[j].equals("F")) {
                    rowEnd = rowFirst + (rowEnd + 1 - rowFirst) / 2 - 1;
                } else {
                    rowFirst = rowFirst + (rowEnd + 1 - rowFirst) / 2;
                }
            }

            int columnFirst = 0;
            int columnEnd = 7;
            for (int j = 7; j < 10; j++) {
                if (seatValues[j].equals("L")) {
                    columnEnd = columnFirst + (columnEnd + 1 - columnFirst) / 2 - 1;
                } else {
                    columnFirst = columnFirst + (columnEnd + 1 - columnFirst) / 2;
                }
            }

            int seatId = (rowFirst * 8 + columnFirst);
            seatIds.add(seatId);

        }

        return seatIds.stream().sorted().collect(Collectors.toList());

    }

    public static int missingSeatId(List<Integer> orderedList) {
        int missindSeat = 0;

        for (int i = 1; i < orderedList.size(); i++) {
            if (orderedList.get(i) - orderedList.get(i - 1) > 1) {
                missindSeat = orderedList.get(i - 1) + 1;
            }
        }

        return missindSeat;
    }
}
