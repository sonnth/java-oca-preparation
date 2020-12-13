package com.sonnth.chapter4.lambda;

@FunctionalInterface
interface Sayable {
    String say(String a);

    default String bark() {
        String a = "Ádsadsadasd";
        a = a.substring(1, 3);
        System.out.println(a);
        return a;
    }
}

class Say implements Sayable {
    @Override
    public String say(String a) {
        return a + "say1";
    }

    @Override
    public String bark() {
        return "GÂU";
    }
}

class Say2 implements Sayable {
    @Override
    public String say(String a) {
        return a + "say2";
    }
}

public class LambdaExpression_1 {

    public static void main(String[] args) {
        Sayable sargs = (s -> s + "55");
        System.out.println(sargs.say("#"));
    }

}
