package com.iss.enummaps;

import com.iss.MyEnums.OrderPaymentStatus;
import com.iss.MyEnums.Status;
import com.iss.pojos.Order;

import java.util.*;
import java.util.function.BiConsumer;

public class EnumMapExample {

    static BiConsumer<Integer, Status> printOrders = (o1, o2) -> System.out.println("order: " + o1 + " status " + o2);

    public static void main(String[] args) {

        //Traditional enum
        System.out.println("---------------------------------------");
        System.out.println("Now processing with traditional Enum");
        System.out.println("---------------------------------------");

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

        //now with EnumMap
        System.out.println("---------------------------------------");
        System.out.println("Now processing with EnumMap");
        System.out.println("---------------------------------------");

        List<Order> unpayedOrders = new ArrayList<>(List.of(new Order(1, "box", 3, 10.0, Status.STARTED),
                new Order(2, "chocolate", 3, 20.0, Status.STARTED),
                new Order(3, "candy", 9, 5.0, Status.IN_PROGRESS),
                new Order(4, "peanuts", 6, 15.0, Status.FINISHED)));

        List<Order> payedOrders =  new ArrayList<>(List.of(new Order(5, "book", 1, 100.0, Status.FINISHED),
                new Order(6, "pencil", 3, 15.0, Status.IN_PROGRESS),
                new Order(7, "book 1", 4, 25.0, Status.FINISHED),
                new Order(8, "notebook", 1, 35.0, Status.STARTED)));

        EnumMap<OrderPaymentStatus, List<Order>> ordersMap = new EnumMap<>(OrderPaymentStatus.class);
        ordersMap.put(OrderPaymentStatus.PENDING_PAYMENT, unpayedOrders);
        ordersMap.put(OrderPaymentStatus.PAYED, payedOrders);
        System.out.println("--------------------------- Before status change -----------------------");
        System.out.println(ordersMap);

        System.out.println("--------------------------- After status change -----------------------");
        processOrders(ordersMap);
        System.out.println(ordersMap);

    }

    public static void processOrders(Map<Integer, Status> orders) {
        System.out.println("Moving all orders to next status");
        orders.forEach( (k,v) -> {
            orders.replace(k, Status.IN_PROGRESS, Status.FINISHED);
            orders.replace(k, Status.STARTED, Status.IN_PROGRESS);
        });
    }

    public static void processOrders(EnumMap<OrderPaymentStatus, List<Order>> orders) throws NullPointerException {
        System.out.println("Moving some orders to payed and others to payment failed");

        //simulate we call an api to get list of latest payment status
        List<Order> payedOrders = getLatestPaymentStatus(orders.get(OrderPaymentStatus.PENDING_PAYMENT));

        //update existing lists with new lists
        orders.get(OrderPaymentStatus.PROCESSING_PAYMENT).removeAll(payedOrders);
        orders.get(OrderPaymentStatus.PAYED).addAll(payedOrders);

    }


    public static List<Order> getLatestPaymentStatus(List<Order> orders) throws NullPointerException {
        // this is a dummy method to simulate an api call
        // to process payments and to get get process status
        Objects.requireNonNull(orders, "List is empty, nothing to process");
        System.out.println("Calling external API to check payment status for orders " + orders);
        orders.remove(0);
        List<Order> results = new ArrayList<>();
        orders.parallelStream().forEach( order -> {
            if (Math.random() > 0.5) { //here it would be a if status is the expected status then add it to results
                results.add(new Order(order.id(), order.productName(), order.quantity(), order.price(), order.status().next()));
            }
        });

        return results;
    }
}
