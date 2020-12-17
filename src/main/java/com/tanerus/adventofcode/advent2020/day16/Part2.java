package com.tanerus.adventofcode.advent2020.day16;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/*
* --- Part Two ---
Now that you've identified which tickets contain invalid values, discard those tickets entirely. Use the remaining valid tickets to determine which field is which.

Using the valid ranges for each field, determine what order the fields appear on the tickets. The order is consistent between all tickets: if seat is the third field, it is the third field on every ticket, including your ticket.

For example, suppose you have the following notes:

class: 0-1 or 4-19
row: 0-5 or 8-19
seat: 0-13 or 16-19

your ticket:
11,12,13

nearby tickets:
3,9,18
15,1,5
5,14,9
Based on the nearby tickets in the above example, the first position must be row, the second position must be class, and the third position must be seat; you can conclude that in your ticket, class is 12, row is 11, and seat is 13.

Once you work out which field is which, look for the six fields on your ticket that start with the word departure. What do you get if you multiply those six values together?
* */
public class Part2 {
    public static void main(String[] args) {
        String fileName = "data/data_day16.txt";
        List<String> inputList = Part1.readInput(fileName);

        Map<String, List<int[]>> validCases = new HashMap<>();

        //departure location: 48-885 or 906-949
        int i;
        for (i = 0; i < inputList.size(); i++) {
            String input = inputList.get(i);
            if ("".equals(input)) {
                break;
            } else {
                String[] splitColon = input.split(":");
                String[] splitOr = splitColon[1].split("or");

                List<int[]> list = new ArrayList<>();
                String[] intArrayStr1 = splitOr[0].trim().split("-");
                int[] intArray1 = new int[2];
                intArray1[0] = Integer.parseInt(intArrayStr1[0]);
                intArray1[1] = Integer.parseInt(intArrayStr1[1]);

                String[] intArrayStr2 = splitOr[1].trim().split("-");
                int[] intArray2 = new int[2];
                intArray2[0] = Integer.parseInt(intArrayStr2[0]);
                intArray2[1] = Integer.parseInt(intArrayStr2[1]);
                list.add(intArray1);
                list.add(intArray2);

                validCases.put(splitColon[0].trim(), list);


            }
        }

        Map<String, List<Integer>> validCasePossiblityOrders = new HashMap<>();
        for (int j = 0; j < i; j++) {
            String input = inputList.get(j);
            String[] splitColon = input.split(":");
            List<Integer> addedList = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19);
            validCasePossiblityOrders.put(splitColon[0].trim(), addedList);
        }

        i = i + 5;

        List<List<Integer>> nearbyTicketList = new ArrayList<>();

        for (i = i; i < inputList.size(); i++) {
            String input = inputList.get(i);
            List<Integer> intList = Arrays.stream(input.split(",")).mapToInt(Integer::parseInt)
                    .boxed().collect(Collectors.toList());
            nearbyTicketList.add(intList);
        }

        List<List<Integer>> filteredNearbyTicketList = removeInvalidDatas(validCases, nearbyTicketList);

        System.out.println(findThePath(validCases, filteredNearbyTicketList, validCasePossiblityOrders));

    }

    private static long findThePath(Map<String, List<int[]>> validCases, List<List<Integer>> filteredNearbyTicketList,
                                    Map<String, List<Integer>> validCasePossiblityOrders) {

        for (int i = 0; i < filteredNearbyTicketList.size(); i++) {
            List<Integer> values = filteredNearbyTicketList.get(i);
            for (int j = 0; j < values.size(); j++) {
                Integer selectedValue = values.get(j);
                for (Map.Entry<String, List<int[]>> set : validCases.entrySet()) {
                    List<Integer> integerPossibilities = validCasePossiblityOrders.get(set.getKey());
                    if (integerPossibilities.contains(j)) {
                        List<int[]> validCasesValues = set.getValue();
                        if ((selectedValue >= validCasesValues.get(0)[0] && selectedValue <= validCasesValues.get(0)[1]) ||
                                (selectedValue >= validCasesValues.get(1)[0] && selectedValue <= validCasesValues.get(1)[1])) {
                            continue;
                        } else {
                            Integer compare = j;
                            List<Integer> newList = integerPossibilities.stream().filter(x -> x.compareTo(compare) != 0)
                                    .collect(Collectors.toList());
                            validCasePossiblityOrders.put(set.getKey(), newList);
                        }
                    } else {
                        continue;
                    }
                }

            }
        }

        for (int i = 0; i < validCasePossiblityOrders.size(); i++)
            cleanValidCasePossiblityOrders(validCasePossiblityOrders);

        return multipleDepartureVals(validCasePossiblityOrders);

    }

    private static long multipleDepartureVals(Map<String, List<Integer>> validCasePossiblityOrders) {

        long mulipleVals = 1;
        List<Integer> yourTicket = Arrays.asList(163, 151, 149, 67, 71, 79, 109, 61, 83, 137, 89, 59, 53, 179, 73, 157, 139, 173, 131, 167);

        for (Map.Entry<String, List<Integer>> map : validCasePossiblityOrders.entrySet()) {
            if (map.getKey().contains("departure")) {
                mulipleVals *= yourTicket.get(map.getValue().get(0));
            }

        }

        return mulipleVals;

    }

    public static void cleanValidCasePossiblityOrders(Map<String, List<Integer>> validCasePossiblityOrders) {
        for (Map.Entry<String, List<Integer>> map : validCasePossiblityOrders.entrySet()) {
            if (map.getValue().size() == 1) {
                String key = map.getKey();
                Integer removeFromOthers = map.getValue().get(0);

                for (Map.Entry<String, List<Integer>> mapLoop : validCasePossiblityOrders.entrySet()) {
                    if (mapLoop.getKey().equals(key)) {
                        continue;
                    }

                    List<Integer> values = mapLoop.getValue();
                    if (values.contains(removeFromOthers)) {
                        Integer compare = removeFromOthers;
                        List<Integer> newList = values.stream().filter(x -> x.compareTo(compare) != 0)
                                .collect(Collectors.toList());
                        validCasePossiblityOrders.put(mapLoop.getKey(), newList);
                    }
                }

            }
        }
    }

    private static List<List<Integer>> removeInvalidDatas(Map<String, List<int[]>> validCases, List<List<Integer>> nearbyTicketList) {

        Predicate<List<Integer>> isValid = x -> {

            for (int i = 0; i < x.size(); i++) {
                boolean isInvalid1 = true;
                for (List<int[]> ints : validCases.values()) {

                    if ((x.get(i) >= ints.get(0)[0] && x.get(i) <= ints.get(0)[1]) ||
                            (x.get(i) >= ints.get(1)[0] && x.get(i) <= ints.get(1)[1])) {
                        isInvalid1 = false;
                        break;
                    }
                }

                if (isInvalid1) {
                    return false;
                }
            }

            return true;
        };

        List<List<Integer>> filteredNearbyTicketList = nearbyTicketList
                .stream()
                .filter(isValid)
                .collect(Collectors.toList());

        return filteredNearbyTicketList;
    }
}
