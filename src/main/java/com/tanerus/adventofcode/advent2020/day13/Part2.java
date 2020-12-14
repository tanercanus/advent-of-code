package com.tanerus.adventofcode.advent2020.day13;

import java.util.ArrayList;
import java.util.List;

public class Part2 {
    public static void main(String[] args) {
        String[] inputArray = Input.input();
        List<BusAndTimestamp> busAndTimestamps = findAllAvailableBus(inputArray[1]);
        System.out.println(solution(busAndTimestamps));
    }

    //Chinese remainder theorem
    private static long solution(List<BusAndTimestamp> busAndTimestamps) {

        // Compute product of all numbers
        long prod = 1;
        int listSize = busAndTimestamps.size();
        for (int i = 0; i < listSize; i++)
            prod *= busAndTimestamps.get(i).getBusNo();

        // Initialize result
        long result = 0;

        // Apply above formula
        for (int i = 0; i < listSize; i++) {
            long pp = prod / busAndTimestamps.get(i).getBusNo();
            long rem = i == 0 ? 0 : busAndTimestamps.get(i).getBusNo() - busAndTimestamps.get(i).getTimestamp();
            result += rem * inv(pp, busAndTimestamps.get(i).getBusNo()) * pp;
        }

        return result % prod;

    }

    static long inv(long a, long m) {
        long m0 = m, t, q;
        long x0 = 0, x1 = 1;

        if (m == 1)
            return 0;

        // Apply extended Euclid Algorithm
        while (a > 1) {
            // q is quotient
            q = a / m;

            t = m;

            // m is remainder now, process
            // same as euclid's algo
            m = a % m;
            a = t;

            t = x0;

            x0 = x1 - q * x0;

            x1 = t;
        }

        // Make x1 positive
        if (x1 < 0)
            x1 += m0;

        return x1;
    }

    private static List<BusAndTimestamp> findAllAvailableBus(String s) {

        List<BusAndTimestamp> busAndTimestamps = new ArrayList<>();

        String[] splitValues = s.split(",");
        for (int i = 0; i < splitValues.length; i++) {
            String item = splitValues[i];
            if (!item.equals("x")) {
                busAndTimestamps.add(new BusAndTimestamp(i, Integer.parseInt(item)));
            }
        }

        return busAndTimestamps;
    }

    static class BusAndTimestamp {
        long timestamp;
        int busNo;

        public BusAndTimestamp(long timestamp, int busNo) {
            this.timestamp = timestamp;
            this.busNo = busNo;
        }

        public long getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(long timestamp) {
            this.timestamp = timestamp;
        }

        public int getBusNo() {
            return busNo;
        }

        public void setBusNo(int busNo) {
            this.busNo = busNo;
        }
    }
}
