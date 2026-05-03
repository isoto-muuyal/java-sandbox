package com.iss.learn.certs;

public class Lion {

    static class NewException extends Exception { }
    static class NewException2 extends Exception { }

    static void method() throws NewException {
        System.out.println("Inside method");
        throw new NewException();
    }

    static void method2() throws NewException2 {
        System.out.println("Inside method2");
        throw new NewException2();
    }

    public static void main(String[] args) throws NewException, NewException2 {
        try {
            method();
        } finally {
            method2();
        }

        int a = 22;
        while((a++)==22) {
            for(;;)
                System.out.println("infinite looping");
        }

        collection();
        for (Lion lion : collection()) {
            System.out.println(lion);
        }
        System.out.println("End of code"); // Line 1

        String[] str = {"hello"};  // Line 1
        StringBuilder sb = new StringBuilder(27);
        String s = new String(sb);
        Object[] obj = str;   // Line 2
        obj[0] = sb;    // Line 3
        String[] new_str = (String[]) obj;    // Line 4

    }

    static public Lion[] collection() {  // Line 2
        Lion[] arr = new Lion[3];
        arr[0] = new Lion();
        arr[1] = new Lion();
        arr[2] = arr[0];
        arr[0] = arr[1] = null;
        return arr;
    }

}
