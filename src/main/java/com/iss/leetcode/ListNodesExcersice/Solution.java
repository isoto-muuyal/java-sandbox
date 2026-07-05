package com.iss.leetcode.ListNodesExcersice;

import com.iss.exceptions.WrongOffsetException;
import com.iss.pojos.MyObj;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {

        // create list nodes
        ListNode a = initListNodes(3);
        ListNode b = initListNodes(3);

        ListNode res = addTwoNumbers(a, b);
        System.out.println(res);
    }

    private static ListNode initListNodes(int quantity) {
        if (quantity == 0) {
            throw new WrongOffsetException("size cannot be < 1");
        }
        Random randomizer = new Random();
        //ListNode res = new ListNode();
        List<ListNode> nodes = new ArrayList<>();

        for (int i = 0 ; i < quantity ; i++) {
            ListNode node = new ListNode();
            node.val = randomizer.nextInt(0,9);;
            nodes.add(node);
        }

        //res.next = nodes.getFirst();
        for (int i = 0 ; i < nodes.size() - 1 ; i++) {
           nodes.get(i).next = nodes.get(i + 1);
        }
        System.out.println("Quantity: " + quantity + ", Nodes:" + nodes.getFirst());
        return nodes.getFirst();
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        //ListNode res = new ListNode();
        List<ListNode> nodes = new ArrayList<>();
        boolean exit = false;
        int carry = 0;

        Set<ListNode> filteredNodes =  nodes
                .stream()
                .takeWhile( n -> n.val < 5)
                .collect(Collectors.toSet());

        //loop while at least one is not null
        while (!exit) {
            //sums values
            ListNode node = sumVals(l1, l2, carry);
            carry = 0;

            if (node.val >= 10) {
                carry += 1;
                node.val -= 10;
            }

            nodes.add(node);

            //move to the next one
            l1 = (l1 != null && l1.next != null) ? l1.next : null;
            l2 = (l2 != null && l2.next != null) ? l2.next : null;

            exit = (l1 == null && l2 == null);
        }
        if (carry > 0) {
            nodes.add(new ListNode(carry));
        }
        //res = nodes.get(0);
        for (int i = 0 ; i < nodes.size() - 1 ; i++) {
            nodes.get(i).next = nodes.get(i + 1);
        }

        return nodes.getFirst();
    }

    public static ListNode sumVals(ListNode l1, ListNode l2, int carry) {
        ListNode res = new ListNode();
        if (l1 != null && l2 != null)
             res.val = l1.val + l2.val + carry;
        else if (l1 == null && l2 != null)
            res.val = l2.val + carry;
        else if (l1 != null)
            res.val = l1.val + carry;
        else
            res.val = carry;
        return res;
    }
}