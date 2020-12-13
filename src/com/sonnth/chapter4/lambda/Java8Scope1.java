package com.sonnth.chapter4.lambda;

@FunctionalInterface
interface Converter<F, T> {
    T convert(F from);
}

public class Java8Scope1 {

    public static void doSomething1() {
        final int num = 1;
        Converter<Integer, String> stringConverter = (from) -> String.valueOf(from + num);

        stringConverter.convert(2); // 3
    }

    public static void doSomething2() {
        int num = 1;
        Converter<Integer, String> stringConverter = (from) -> String.valueOf(from + num);

        stringConverter.convert(2); // 3
    }

    public static void doSomething3() {
        int num = 1;
        Converter<Integer, String> stringConverter = (from) -> String.valueOf(from + num);

        stringConverter.convert(2); // 3

        // Lambda expression will throw error at num varialbe.
        // Local variable num defined in an enclosing scope must be final or effectively
        // num = 3;
    }

    public static void main(String[] args) {
        doSomething1();
    }
}
