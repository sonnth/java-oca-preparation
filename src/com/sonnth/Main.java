package com.sonnth;

import com.sonnth.operators.Operator;
import com.sonnth.operators.OperatorEnum;

/*
 * Main method is the gateway between the startup of a Java process
 * Managed by JVM
 */
public class Main {
    public static void main(String... $n) {
        System.out.println(Operator.operate(5,0, OperatorEnum.NOT));
    }
}
