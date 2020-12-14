package com.tanerus.adventofcode.advent2020.day14;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Part2 {
    public static void main(String[] args) throws IOException {
        partTwo();
    }

    private static void partTwo() throws IOException {

        String fileName = "data/data_day14.txt";

        List<String> input = Files.lines(Paths.get(fileName)).collect(Collectors.toList());

        //mask = XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X
        //mem[8] = 11
        String[] mask = null;
        Map<BigInteger, Integer> memory = new HashMap<>();
        Pattern p = Pattern.compile("\\d+");

        for (int i = 0; i < input.size(); i++) {
            String lineParts[] = input.get(i).split(" = ");
            if ("mask".equals(lineParts[0])) {
                mask = lineParts[1].split("");
            } else {
                Matcher m = p.matcher(lineParts[0]);
                m.find();
                int address = Integer.parseInt(m.group());
                String[] binaryAddress = String.format("%36s", Integer.toBinaryString(address)).replace(" ", "0").split("");
                Set<String[]> addresses = applyPt2Mask(mask, binaryAddress);
                addresses.stream()
                        .map(sa -> String.join("", sa))
                        .map(binStr -> new BigInteger(binStr, 2))
                        .forEach(adr -> memory.put(adr, Integer.valueOf(lineParts[1])));
            }
        }
        BigInteger sum = memory.values().stream().map(BigInteger::valueOf).reduce(BigInteger.ZERO, BigInteger::add);
        System.out.println(sum);
    }

    private static Set<String[]> applyPt2Mask(String[] mask, String[] binaryAddress) {
        List<Integer> xIndexes = new ArrayList<>();
        for (int i = 0; i < mask.length; i++) {
            switch (mask[i].toUpperCase()) {
                case "X":
                    xIndexes.add(i);
                case "1":
                    binaryAddress[i] = mask[i];
                    break;
                case "0":
                    break;
                default:
                    throw new RuntimeException("something went wrong");
            }
        }
        //now handle x's 1000x0x01x
        Set<String[]> permutations = new HashSet<>();
        permutations.add(binaryAddress);
        for (int index : xIndexes) {
            //loop through our list of current permutations, and replace each X with its two permutations of 0 & 1
            permutations = permutations.stream()
                    .flatMap(a -> {
                        //using flat map to make each array into 2 different ones
                        String[] scenario0 = Arrays.stream(a).toArray(String[]::new);
                        scenario0[index] = "0";
                        String[] scenario1 = a;
                        scenario1[index] = "1";
                        return Stream.of(scenario0, scenario1);
                    })
                    .collect(Collectors.toSet());
        }
        return new HashSet<>(permutations);
    }

}
