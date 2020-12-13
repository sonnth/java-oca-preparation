package com.sonnth;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*
 * Main method is the gateway between the startup of a Java process
 * Managed by JVM
 */
public class Main {
    public static void main(String... $n) {
        List<Integer> ages = new ArrayList<>();
        ages.add(Integer.parseInt("5"));
        ages.add(Integer.valueOf("6"));
        ages.add(7);
        for (int age : ages) System.out.print(age);
        LocalDate localDate = LocalDate.of(2019, 2, 2);
        localDate.plusDays(1);

    }

}
