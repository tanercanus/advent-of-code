package com.tanerus.adventofcode.advent2020.day3;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
/*
* --- Part Two ---
Time to check the rest of the slopes - you need to minimize the probability of a sudden arboreal stop, after all.

Determine the number of trees you would encounter if, for each of the following slopes, you start at the top-left corner and traverse the map all the way to the bottom:

Right 1, down 1.
Right 3, down 1. (This is the slope you already checked.)
Right 5, down 1.
Right 7, down 1.
Right 1, down 2.
In the above example, these slopes would find 2, 7, 3, 4, and 2 tree(s) respectively; multiplied together, these produce the answer 336.

What do you get if you multiply together the number of trees encountered on each of the listed slopes?
* */
public class Part2 {
    public static void main(String[] args) {

        String[] inputStrings = Input.initializeString();
        List<List<String>> list = new ArrayList<>();
        Util.convertInput(inputStrings, list);

        List<Move> moves = new ArrayList<>(){{
            add(new Move(1,1));
            add(new Move(3,1));
            add(new Move(5,1));
            add(new Move(7,1));
            add(new Move(1,2));

        }};

        List<BigInteger> countTrees = new ArrayList<>();

        for (Move move : moves) {
            countTrees.add(goWithPath(move.right, move.left, list.get(0).size(), list ));
        }

        System.out.println(countTrees.stream().reduce(BigInteger.ONE, BigInteger::multiply));
        
    }

    public static BigInteger goWithPath(int right, int down, int columnSize, List<List<String>> list) {
        BigInteger countTrees = BigInteger.ZERO;

        boolean isEnd = false;
        int indexI = 0;
        int indexJ = 0;
        while (!isEnd) {
            indexI = (indexI + down);
            indexJ = (indexJ + right) % columnSize;

            if (list.get(indexI).get(indexJ).equals("#"))
                countTrees = countTrees.add(BigInteger.ONE);

            if (indexI == list.size() - 1)
                isEnd = true;
        }

        return countTrees;
    }

    static class Move {
        private int right;
        private int left;

        public Move(int right, int left) {
            this.right = right;
            this.left = left;
        }
    }

}
