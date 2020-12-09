package com.tanerus.adventofcode.advent2020.day4;

import java.util.regex.Pattern;

public class Util {

    public static void addToPassport(String[] parseValues, Passport passport, boolean addExtraVal) {
        switch (parseValues[0]) {
            case "byr":
                if (addExtraVal) {
                    int val = convertStrToInt(parseValues[1]);
                    if (val >= 1920 && val <= 2002)
                        passport.setByr(parseValues[1]);
                } else {
                    passport.setByr(parseValues[1]);
                }

                break;
            case "iyr":
                if (addExtraVal) {
                    int val = convertStrToInt(parseValues[1]);
                    if (val >= 2010 && val <= 2020)
                        passport.setIyr(parseValues[1]);
                } else {
                    passport.setIyr(parseValues[1]);
                }
                break;
            case "eyr":
                if (addExtraVal) {
                    int val = convertStrToInt(parseValues[1]);
                    if (val >= 2020 && val <= 2030)
                        passport.setEyr(parseValues[1]);
                } else {
                    passport.setEyr(parseValues[1]);
                }
                break;
            case "hgt":
                if (addExtraVal) {
                    if (parseValues[1].indexOf("cm") != -1) {
                        int val = convertStrToInt(parseValues[1].substring(0, parseValues[1].length() - 2));
                        if (val >= 150 && val <= 193) {
                            passport.setHgt(parseValues[1]);
                        }
                    } else {
                        int val = convertStrToInt(parseValues[1].substring(0, parseValues[1].length() - 2));
                        if (val >= 59 && val <= 76) {
                            passport.setHgt(parseValues[1]);
                        }
                    }
                } else {
                    passport.setHgt(parseValues[1]);
                }
                break;
            case "hcl":
                if (addExtraVal) {
                    if (Pattern.matches("^[#][0-9a-f]{6}$", parseValues[1]))
                        passport.setHcl(parseValues[1]);
                } else {
                    passport.setHcl(parseValues[1]);
                }
                break;
            case "ecl":
                if (addExtraVal) {
                    switch (parseValues[1]) {
                        case "amb":
                        case "blu":
                        case "brn":
                        case "gry":
                        case "grn":
                        case "hzl":
                        case "oth":
                            passport.setEcl(parseValues[1]);
                            break;
                    }
                } else {
                    passport.setEcl(parseValues[1]);
                }
                break;
            case "pid":
                if (addExtraVal) {
                    if (Pattern.matches("^[0-9]{9}$", parseValues[1]))
                        passport.setPid(parseValues[1]);
                } else {
                    passport.setPid(parseValues[1]);
                }
                break;
            case "cid":
                passport.setCid(parseValues[1]);
                break;
        }
    }

    public static int convertStrToInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            return -1;
        }
    }

}
