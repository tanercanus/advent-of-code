package com.tanerus.adventofcode.advent2020.day16;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/*
* --- Day 16: Ticket Translation ---
As you're walking to yet another connecting flight, you realize that one of the legs of your re-routed trip coming up is on a high-speed train. However, the train ticket you were given is in a language you don't understand. You should probably figure out what it says before you get to the train station after the next flight.

Unfortunately, you can't actually read the words on the ticket. You can, however, read the numbers, and so you figure out the fields these tickets must have and the valid ranges for values in those fields.

You collect the rules for ticket fields, the numbers on your ticket, and the numbers on other nearby tickets for the same train service (via the airport security cameras) together into a single document you can reference (your puzzle input).

The rules for ticket fields specify a list of fields that exist somewhere on the ticket and the valid ranges of values for each field. For example, a rule like class: 1-3 or 5-7 means that one of the fields in every ticket is named class and can be any value in the ranges 1-3 or 5-7 (inclusive, such that 3 and 5 are both valid in this field, but 4 is not).

Each ticket is represented by a single line of comma-separated values. The values are the numbers on the ticket in the order they appear; every ticket has the same format. For example, consider this ticket:

.--------------------------------------------------------.
| ????: 101    ?????: 102   ??????????: 103     ???: 104 |
|                                                        |
| ??: 301  ??: 302             ???????: 303      ??????? |
| ??: 401  ??: 402           ???? ????: 403    ????????? |
'--------------------------------------------------------'
Here, ? represents text in a language you don't understand. This ticket might be represented as 101,102,103,104,301,302,303,401,402,403; of course, the actual train tickets you're looking at are much more complicated. In any case, you've extracted just the numbers in such a way that the first number is always the same specific field, the second number is always a different specific field, and so on - you just don't know what each position actually means!

Start by determining which tickets are completely invalid; these are tickets that contain values which aren't valid for any field. Ignore your ticket for now.

For example, suppose you have the following notes:

class: 1-3 or 5-7
row: 6-11 or 33-44
seat: 13-40 or 45-50

your ticket:
7,1,14

nearby tickets:
7,3,47
40,4,50
55,2,20
38,6,12
It doesn't matter which position corresponds to which field; you can identify invalid nearby tickets by considering only whether tickets contain values that are not valid for any field. In this example, the values on the first nearby ticket are all valid for at least one field. This is not true of the other three nearby tickets: the values 4, 55, and 12 are are not valid for any field. Adding together all of the invalid values produces your ticket scanning error rate: 4 + 55 + 12 = 71.

Consider the validity of the nearby tickets you scanned. What is your ticket scanning error rate?

Your puzzle answer was 25788.

The first half of this puzzle is complete! It provides one gold star: *
* */
public class Part1 {

    public static long invalidRate = 0;

    public static void main(String[] args) {
        String fileName = "data/data_day16.txt";
        List<String> inputList = readInput(fileName);

        Set<int[]> validCases = new HashSet<>();

        //departure location: 48-885 or 906-949
        int i;
        for (i = 0; i < inputList.size(); i++) {
            String input = inputList.get(i);
            if ("".equals(input)) {
                break;
            } else {
                String[] splitColon = input.split(":");
                String[] splitOr = splitColon[1].split("or");

                String[] intArrayStr1 = splitOr[0].trim().split("-");
                int[] intArray1 = new int[2];
                intArray1[0] = Integer.parseInt(intArrayStr1[0]);
                intArray1[1] = Integer.parseInt(intArrayStr1[1]);
                validCases.add(intArray1);

                String[] intArrayStr2 = splitOr[1].trim().split("-");
                int[] intArray2 = new int[2];
                intArray2[0] = Integer.parseInt(intArrayStr2[0]);
                intArray2[1] = Integer.parseInt(intArrayStr2[1]);
                validCases.add(intArray2);
            }
        }

        i = i + 5;

        List<List<Integer>> nearbyTicketList = new ArrayList<>();

        for (i = i; i < inputList.size(); i++) {
            String input = inputList.get(i);
            List<Integer> intList = Arrays.stream(input.split(",")).mapToInt(Integer::parseInt)
                    .boxed().collect(Collectors.toList());
            nearbyTicketList.add(intList);
        }

        System.out.println(calculateInvalidRate(validCases, nearbyTicketList));

    }


    public static long calculateInvalidRate(Set<int[]> validCases, List<List<Integer>> nearbyTicketList) {

        Predicate<Integer> isInvalid = x -> {

            boolean isInvalid1 = true;
            for (int[] ints : validCases) {

                if (x >= ints[0] && x <= ints[1]) {
                    isInvalid1 = false;
                    break;
                }
            }

            return isInvalid1;
        };

        nearbyTicketList.forEach(x -> {
            invalidRate += x.stream().filter(isInvalid).mapToLong(i -> i).sum();
        });

        return invalidRate;

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
