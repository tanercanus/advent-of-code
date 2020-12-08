package com.tanerus.adventofcode.advent2020.day7;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.tanerus.adventofcode.advent2020.day7.Input.initializeString;

/*
* --- Part Two ---
It's getting pretty expensive to fly these days - not because of ticket prices, but because of the ridiculous number of bags you need to buy!

Consider again your shiny gold bag and the rules from the above example:

faded blue bags contain 0 other bags.
dotted black bags contain 0 other bags.
vibrant plum bags contain 11 other bags: 5 faded blue bags and 6 dotted black bags.
dark olive bags contain 7 other bags: 3 faded blue bags and 4 dotted black bags.
So, a single shiny gold bag must contain 1 dark olive bag (and the 7 bags within it) plus 2 vibrant plum bags (and the 11 bags within each of those): 1 + 1*7 + 2 + 2*11 = 32 bags!

Of course, the actual rules have a small chance of going several levels deeper than this example; be sure to count all of the bags, even if the nesting becomes topologically impractical!

Here's another example:

shiny gold bags contain 2 dark red bags.
dark red bags contain 2 dark orange bags.
dark orange bags contain 2 dark yellow bags.
dark yellow bags contain 2 dark green bags.
dark green bags contain 2 dark blue bags.
dark blue bags contain 2 dark violet bags.
dark violet bags contain no other bags.
In this example, a single shiny gold bag must contain 126 other bags.

How many individual bags are required inside your single shiny gold bag?
* */
public class Part2 {

    public static Map<String, List<Bag>> bagsMap = new LinkedHashMap<>();

    public static Map<String, BagCount> bagsMapCount = new LinkedHashMap<>();

    public static void main(String[] args) {

        String searchingBag = "shiny gold";

        String[] strings = initializeString();
        Util.initializeTheMap(strings, bagsMap);

        int count = searchBagCount(searchingBag);
        System.out.println(count);

    }

    public static int searchBagCount(String searchingBag) {

        int count = 0;
        List<Bag> bags = bagsMap.get(searchingBag);
        for (int i = 0; i < bags.size(); i++) {
            findNecessaryBagCount(bags.get(i));
            count += (bags.get(i).getCount() * bagsMapCount.get(bags.get(i).getName()).getCount());
        }

        System.out.println(bagsMapCount);

        return count;
    }

    public static void findNecessaryBagCount(Bag selectedBag) {

        String name = selectedBag.getName();
        if (bagsMap.get(name) != null) {
            List<Bag> list = bagsMap.get(name);
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getName().equals("no other")) {
                    bagsMapCount.put(name, new BagCount(1, true));
                } else {

                    if (bagsMapCount.get(name) != null && bagsMapCount.get(name).isFinished()) {
                        continue;
                    }
                    findNecessaryBagCount(list.get(i));

                    BagCount bagCount = new BagCount();
                    if (bagsMapCount.get(name) != null) {

                        int oldCount = bagsMapCount.get(name).getCount() - 1;
                        bagCount.setCount(list.get(i).getCount() * bagsMapCount.get(list.get(i).getName()).getCount() + 1 + oldCount);
                        if (i == list.size() - 1)
                            bagCount.setFinished(true);

                        bagsMapCount.put(name, bagCount);
                    } else {
                        bagCount.setCount((list.get(i).getCount() * bagsMapCount.get(list.get(i).getName()).getCount() + 1));
                        if (i == list.size() - 1)
                            bagCount.setFinished(true);
                        bagsMapCount.put(name, bagCount);
                    }
                }

            }
        }

    }

    static class BagCount {
        int count;
        boolean isFinished = false;

        public BagCount(int count, boolean isFinished) {
            this.count = count;
            this.isFinished = isFinished;
        }

        public BagCount() {
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public boolean isFinished() {
            return isFinished;
        }

        public void setFinished(boolean finished) {
            isFinished = finished;
        }
    }

}
