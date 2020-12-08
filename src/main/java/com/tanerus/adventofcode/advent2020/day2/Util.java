package com.tanerus.adventofcode.advent2020.day2;

public class Util {
    public static PasswordParse parsePassword(String selected) {
        PasswordParse passwordParse = new PasswordParse();

        int dashIndex = selected.indexOf("-");
        int firstEmptyIndex = selected.indexOf(" ");
        int columnIndex = selected.indexOf(":");
        int lastEmptyIndex = selected.lastIndexOf(" ");

        int min = Integer.parseInt(selected.substring(0, dashIndex));
        int max = Integer.parseInt(selected.substring(dashIndex + 1, firstEmptyIndex));
        Character selectedChar = selected.substring(firstEmptyIndex + 1, columnIndex).charAt(0);
        String password = selected.substring(lastEmptyIndex + 1);

        passwordParse.setMin(min);
        passwordParse.setMax(max);
        passwordParse.setPolicyChar(selectedChar);
        passwordParse.setPassword(password);

        return passwordParse;
    }
}
