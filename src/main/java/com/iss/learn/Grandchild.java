package com.iss.learn;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import com.iss.learn.records.Policy;

public class Grandchild extends Child {

    static {
        System.out.println("5");
    }

    Grandchild() {
        System.out.println("6");
    }

    public static void main(String[] args) {
        Grandchild grandchild = new Grandchild();

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        System.out.println(list.containsAll(set));
        System.out.println(set.containsAll(list));

        List<String> list1 = new ArrayList<>();
        list1.add("One");
        List<String> newList1 = Collections.unmodifiableList(list1);
        list1.add("Two");
        System.out.println(newList1);

        List<String> list2 = new ArrayList<>();
        list2.add("One");
        List<String> newList2 = List.copyOf(list2);
        list2.add("Two");
        System.out.println(newList2);

        String code = "String message = \"Hello, World!\";" + "System.out.println(message);";
        System.out.println(code);

        String code2 = "String message = \"Hello, World!\";" + "System.out.println(message);";
        System.out.println(code2);

        String code3 = """
                String message = "Hello, World!";
                System.out.println(message);
                """;
        System.out.println(code3);

        Policy policy1 = new Policy(100, "DummyPolicy", 60, 7.2f);
        Policy policy2 = new Policy(100, "DummyPolicy", 60, 7.2);
        System.out.println(policy1.equals(policy2) + " " + (policy1 == policy2) + " "
                + (policy1.hashCode() == policy2.hashCode()));

        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();

        String txt = """
                <body>
                <h1>header1</h1>
                <h2>header2</h2>
                </body>
                """;

        String patter = "^\\s*<h(\\d)>([^<]+)</h\\d>$";
        System.out.println("extracting headers");
        txt.lines().filter(line -> line.matches(patter))
                .forEach(ln -> System.out.println(ln.replace(patter, "Level $1: $2")));

        enum Color {RED, GREEN}
        Object obj = 10;

        switch (obj) {
            case Long s -> System.out.println("string");
            case Double c -> System.out.println("color");
            default -> System.out.println("def");
        }

        Locale.setDefault(Locale.JAPAN);
        System.out.println(Locale.getDefault());
        System.out.println(Locale.getDefault().getCountry());

        Thread vrt = Thread.ofVirtual().start(() -> {
        });

        var mia = 2 / 5;
        System.out.println(mia);
        var data = Color.GREEN;
        data = Color.RED;
        System.out.println(data);

        int a = 12;
        int b = 9;
        int c = 4;
        System.out.println(b^c);
        System.out.println((a|b^c));
        System.out.println((a|b^c) < 10 & c<5);

        byte x = 127;
        System.out.println(x);
        System.out.println(~x);

        String s1 = new String("hola");
        String s2;
        s2 = grandchild.returnsS();
        System.out.println("------------");
        System.out.println(s1 == s2);

        externalLabel : for (int i = 0 ; i < 3 ; i++ ){
            internal : for (int n = 0 ; n < 4 ; n++) {
                System.out.println("inside internal " + n);
                if ( i == 2)
                    break externalLabel;
                if( n == 2)
                    break internal;
            }
            System.out.println("inside external " + i);

        }

    }

    String returnsS() {
        return "ho" + "la";
    }

    final class Test extends Parent {
    }

    //non-sealed class Test2 extends com.iss.learn.Parent{}
    protected class Test3 extends Parent {
    }

    public class Test4 extends Parent {
    }
}
