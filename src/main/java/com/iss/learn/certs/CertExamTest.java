package com.iss.learn.certs;

public class CertExamTest {

    interface Operation {
        int operate(int a, int b);
        void display();
    }

    public static void main(String[] args) {
//
//        Operation calc = ((a,b) -> ((a++ > ++b) ? b-- : a++));
//        System.out.println(calc.operate(4, 5));

        final String numer;
        numer = "number";
        final String var1 = "var1";
        String var2 = "var2", var3 = "var3";

        switch (var2) {
            case "var3":
                System.out.println("var3");
                break;
            case "number":
                System.out.println("var2");
                break;
            case var1:
                System.out.println("var1");
                break;
            default:
                System.out.println("default");
                break;
        }

        var strB = new StringBuilder("Ronaldo");
        String str = "Cristiano";
        String res = strB.substring(str.indexOf('r'), str.lastIndexOf("ano")) + str.stripLeading().length()
                + strB.charAt(5);
        System.out.println("--- " + strB.charAt(0));
        System.out.println(res);


        for(int i=0,j=0; i<=10 & j<=10; i+=2) {
            if((i!=6) && j!=6)
                System.out.println(i);
        }
    }

}
