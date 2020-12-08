package com.tanerus.adventofcode.advent2020.day7;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Util {
    public static void initializeTheMap(String[] strings, Map<String, List<Bag>> bagsMap) {
        for (int i = 0; i < strings.length; i++) {
            //System.out.println(strings[i]);
            int firstBagsIndex = strings[i].indexOf("bags");
            String mapKey = strings[i].substring(0, firstBagsIndex - 1);

            String rest = strings[i].substring(firstBagsIndex + 13);

            rest = rest
                    .replaceAll("bags", "")
                    .replaceAll("bag", "")
                    .replace(".", "").trim();
            //System.out.println("*"+rest+"*");

            List<Bag> bagList = new ArrayList<>();

            int indexOfComma = rest.indexOf(",");
            if (indexOfComma == -1) {
                if (rest.contains("no other")) {
                    bagList.add(new Bag(0, "no other"));
                } else {
                    int indexOfEmpty = rest.indexOf(" ");
                    int count = Integer.parseInt(rest.substring(0, indexOfEmpty));
                    String name = rest.substring(indexOfEmpty + 1).trim();
                    bagList.add(new Bag(count, name));
                    //System.out.println("--"+count+name+"--");
                }
            } else {
                String[] baggageCont = rest.split(",");
                for (int j = 0; j < baggageCont.length; j++) {
                    baggageCont[j] = baggageCont[j].trim();
                    int indexOfEmpty = baggageCont[j].indexOf(" ");
                    int count = Integer.parseInt(baggageCont[j].substring(0, indexOfEmpty));
                    String name = baggageCont[j].substring(indexOfEmpty + 1).trim();

                    bagList.add(new Bag(count, name));

                    //System.out.println("-"+count+name+"-");

                }
            }

            bagsMap.put(mapKey, bagList);

        }
    }
}
