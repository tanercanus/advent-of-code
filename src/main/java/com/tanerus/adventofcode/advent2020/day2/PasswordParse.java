package com.tanerus.adventofcode.advent2020.day2;

public class PasswordParse {
    private int min;
    private int max;
    private Character policyChar;
    private String password;

    public PasswordParse(){

    }

    public PasswordParse(int min, int max, Character policyChar, String password) {
        this.min = min;
        this.max = max;
        this.policyChar = policyChar;
        this.password = password;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public Character getPolicyChar() {
        return policyChar;
    }

    public void setPolicyChar(Character policyChar) {
        this.policyChar = policyChar;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
