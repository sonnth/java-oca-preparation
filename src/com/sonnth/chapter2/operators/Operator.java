package com.sonnth.chapter2.operators;

public class Operator {
    public static int operate(int a, int b, OperatorEnum operator) {
        switch (operator) {
            case OR:
                return a | b;
            case AND:
                return a & b;
            case XOR:
                return a ^ b;
            case NOT:
                return ~a;
            case BITWISE_RIGHT_SHIFT:
                return a >> b;
            case BITWISE_LEFT_SHIFT:
                return a << b;
            case UNSIGNED_RIGHT_SHIFT:
                return a >>> b;
            default:
                return 0;
        }
    }
}
