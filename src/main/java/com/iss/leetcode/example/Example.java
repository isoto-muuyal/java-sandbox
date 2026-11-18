package com.iss.leetcode.example;

import com.iss.MyEnums.OrderPaymentStatus;
import com.iss.MyEnums.Status;
import com.iss.pojos.MyObj;
import com.iss.pojos.Order;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Example {

    public static void main(String[] args) {

        intStreamsExcersice();

        String hey = "hola mundo";
        String[] hey2 = hey.split(" ");
        System.out.println(hey);
        System.out.println(Arrays.toString(hey2));

        System.out.println("test to identify if the mulfiply of all members of an array is positve negative or zero");
        int[] testValues = {1, 4, 1, 1};
        int val = isSumPositive(testValues);
        System.out.println("array: " + testValues.toString() + ", result: " + val);
        System.out.println("------------------------------");

        Set<Integer> myInts = Arrays.stream(testValues).boxed().collect(Collectors.toSet());
        List<Integer> sortedInts = myInts.stream().sorted(Comparator.comparingInt(Integer::intValue)).toList();

        String hola = "hola";
        StringBuilder hola2 = new StringBuilder("hola");
        IntStream codepoints = hola2.codePoints();
        codepoints.forEach(System.out::println);
        StringBuffer hola3 = new StringBuffer("hola");

        System.out.println(hola + " " +  hola2 + " " + hola3);

        StringBuilder hola4 = new StringBuilder(hola);
        StringBuffer hola5= new StringBuffer(hola4);
        String hola6 = hola;
        hola4.reverse();
        hola = "que onda";
        System.out.println(hola + " " + hola4 + " " + hola5 + " " + hola6);

        Integer a = 1;
        Integer b = a;
        System.out.println(a + " " + b);
        a = 5;
        System.out.println(a + " " + b);


        System.out.println("------------------------------");

        System.out.println("Identify the index of the first character that is not repeated in a string");
        int res = solutionNonRepeatedIndex("H eoolah");
        System.out.println("result: "  + res);
        System.out.println("------------------------------");

        System.out.println(Status.FINISHED);
        String fin = Status.FINISHED.toString();

        MyObj obj1 = new MyObj();
        System.out.println("------------------------------");
        System.out.println(obj1);
        System.out.println("------------------------------");
        testStatus(obj1);
        System.out.println(obj1);
        System.out.println("------------------------------");
    }

    private static class MyTestObj {
        private Integer id;
        private String name;

        static {
            System.out.println("from static myobj");
        }

        public MyTestObj(Integer id, String name) {
            this.id = id;
            this.name = name;
            System.out.println("instantiating myobj");
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString(){
            return "MyObj {" +
                        "id: " + id + "," +
                        "name: " + name +
                    "}";
        }
    }

    private static void intStreamsExcersice() {
        MyTestObj obj1 = new MyTestObj(1, "pepe");
        MyTestObj obj2 = new MyTestObj(2, "pecas");
        MyTestObj obj3 = new MyTestObj(3, "la cuca");
        List<MyTestObj> myObjs = new ArrayList<>(List.of(obj1, obj2, obj3));
        List<Integer> myList = new ArrayList<>(List.of(1, 5, 4));
        Optional<Integer> reduced = myList.stream().reduce((a,b) -> a - b);
        System.out.println(reduced.orElse(0));

        List<MyTestObj> filtered = myObjs.stream().filter( a-> a.name.length() > 3).toList();
        filtered.forEach(System.out::println);
    }

    public static void testStatus(MyObj obj) {
        obj.setStatus("updated");
        System.out.println("just testing");
    }

    private static int isSumPositive(int[] arr) {
        int res = 1;

        //is there any 0?
        for (int j : arr) {
            if (j == 0) {
                return 0;
            }
        }

        //is it negative?
        for (int i : arr){
            if (i < 0) {
                res = res * -1;
            }
        }

        return res;
    }

    private static int solutionNonRepeatedIndex(String S) {
        int[] count = new int[26];

        S = S.toLowerCase();
        S = S.trim().replace(" ", "");
        for (int i = 0; i < S.length(); i++) {
            count[S.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (count[S.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }

    private void testMultithread() {

        //instantiate objects or classes that I will use in parallel
       MyUtils utils = new MyUtils();
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(1,  "productName", 2, 2.0, Status.FINISHED));
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            //make some calls to db or otherwise, maybe sending emails

            //we apply some logic or a loop like
            for (Order order : orders) {
                if (order.status().equals(Status.FINISHED)) {
                    executor.submit(() -> {
                        utils.sendEmail(order.status());
                    });
                    executor.submit(utils::sum);
                }
            }

        } catch (Exception e) {
            System.out.println("something happened: " + e.getMessage());
        }

    }

}
