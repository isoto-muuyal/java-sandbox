package com.iss.learn.hackerrange;

import java.io.*;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import static com.iss.learn.hackerrange.Result.minimumSwaps;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class SwapingSolution {

    private static final Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) throws IOException {

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("./resultsSwap.txt"));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

}
