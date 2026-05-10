package com.iss.enummaps;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class EnumMapExample {

    private enum Status {
        STARTED,
        IN_PROGRESS,
        FINISHED;

        public Status next() {
            switch (this) {
                case STARTED: return IN_PROGRESS;
                case IN_PROGRESS: return FINISHED;
                default: return FINISHED;
            }
        }
    }

    static BiConsumer<Integer, Status> printOrders = (o1, o2) -> System.out.println("order: " + o1 + " status " + o2);

    public static void main(String[] args) {

        //Traditional enum
        Map<Integer, Status> internalOrdersMap = new HashMap<>();
        internalOrdersMap.put(123123, Status.STARTED);
        internalOrdersMap.put(123124, Status.IN_PROGRESS);
        internalOrdersMap.put(123125, Status.FINISHED);

        System.out.println("--------------------------- Initial status -----------------------");
        internalOrdersMap.forEach(printOrders);

        //do something with order
        processOrders(internalOrdersMap);

        System.out.println("--------------------------- After status change -----------------------");
        internalOrdersMap.forEach(printOrders);


    }

    public static void processOrders(Map<Integer, Status> orders) {
        System.out.println("Moving all orders to next status");
        orders.forEach( (k,v) -> {
            orders.replace(k, Status.IN_PROGRESS, Status.FINISHED);
            orders.replace(k, Status.STARTED, Status.IN_PROGRESS);
        });
    }

}
