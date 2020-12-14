package com.tanerus.adventofcode.advent2020.day14;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Part1 {
    public static void main(String[] args) {
        List<Input.InputWithMaskValue> inputWithMaskValues = Input.input();
        System.out.println(calculateTheValues(inputWithMaskValues));
    }

    public static long calculateTheValues(List<Input.InputWithMaskValue> inputWithMaskValues) {

        Map<Integer, Long> maps = new HashMap<>();

        for (int i = 0; i < inputWithMaskValues.size(); i++) {
            List<String> values = inputWithMaskValues.get(i).getValues();
            String[] maskArray = inputWithMaskValues.get(i).getMask().split("");
            for (int j = 0; j < values.size(); j++) {
                String str = values.get(j).split("=")[1].trim();
                String binaryStr = Integer.toBinaryString(Integer.parseInt(str));

                int indexOfStartDec =  values.get(j).split("=")[0].indexOf("[");
                int indexOfEndDec =  values.get(j).split("=")[0].indexOf("]");
                int memAddress = Integer.parseInt(values.get(j).split("=")[0].substring(indexOfStartDec+1, indexOfEndDec));

                binaryStr = useMask(maskArray, binaryStr);

                long decimal = Long.parseLong(binaryStr, 2);

                maps.put(memAddress, decimal);
            }
        }

        return maps.entrySet().stream().mapToLong(e-> e.getValue()).sum();
    }

    public static String useMask(String[] maskArray, String binaryStr) {

        int binaryStrOldLength = binaryStr.length();

        StringBuilder sbDummy = new StringBuilder();
        if ( maskArray.length > binaryStrOldLength) {
            for ( int i = 0; i <maskArray.length-binaryStrOldLength; i++) {
                sbDummy.append("0");
            }
        }
        sbDummy.append(binaryStr);
        String[] binaryStrArray = sbDummy.toString().split("");
        for ( int i=0; i<maskArray.length; i++) {
            if ( maskArray[i].equals("1")) {
                binaryStrArray[i] = "1";
            } else if( maskArray[i].equals("0")) {
                binaryStrArray[i] = "0";
            }
        }

        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < binaryStrArray.length; i++) {
            sb.append(binaryStrArray[i]);
        }
        String str = sb.toString();

        return str;
    }

}
