package com.iss.learn;

public class HandsOn {



    public static void main(String[] args) {

        try {
            System.out.print("Method execution started-");
            throw new Exception();
        } catch (Exception e) {
            System.out.print("Problem occurred-");
            System.exit(0);
        } finally {
            System.out.print("Method stopped-");
        }
        System.out.print("Finished");

        int[] message = {74, 97, 118, 97, 32, 105, 115, 32, 103, 114, 101, 97, 116};
        char[] mychars = new char[message.length];

        for (int i = 0; i < message.length ; i++ ) {
            mychars[i] = (char) message[i];
        }

        String decodedMsg = new String(mychars);
        System.out.println(decodedMsg);
    }

}
