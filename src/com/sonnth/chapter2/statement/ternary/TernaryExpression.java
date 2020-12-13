package com.sonnth.statement.ternary;

public class TernaryExpression {
    public static void main(String[] args) {
        int y = 1;
        int z = 1;

        final int x;
        x = y >= 10 ? y++ : z++;
        System.out.println(y + "," + z); // Outputs 1,2
        System.out.println(x);
    }
}
