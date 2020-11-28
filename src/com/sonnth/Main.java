package com.sonnth;

import com.sonnth.object.Person;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
        ages.add(null);
        for (int age : ages) System.out.print(age);
        LocalDate localDate = LocalDate.of(2019,2,2);
        localDate.plusDays(1);

    }

}
