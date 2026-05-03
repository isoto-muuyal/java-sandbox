package com.iss.learn.hackerranck;

import java.util.*;

public class DequeTest {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque deque = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        int maxUnique = 0;

        if ((n >= 1 && n <= 100000) && (m >= 1 && m <= 100000)) {

            for (int i = 0; i < n; i++) {
                int num = in.nextInt();
                deque.addLast(num);
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            maxUnique = map.size();

            for (int i = m; i < n; i++) {
                // Remove the element from the front of the window
                int oldNum = (int)deque.removeFirst();
                map.put(oldNum, map.get(oldNum) - 1);
                if (map.get(oldNum) == 0) {
                    map.remove(oldNum);
                }
                // Add the new element to the back of the window
                if (in.hasNext()){
                    int newNum = in.nextInt();
                    deque.addLast(newNum);
                    map.put(newNum, map.getOrDefault(newNum, 0) + 1);

                    // Update the maximum unique count
                    maxUnique = Math.max(maxUnique, map.size());
                }
            }
            System.out.println(maxUnique);
            in.close();
        }
    }
}
