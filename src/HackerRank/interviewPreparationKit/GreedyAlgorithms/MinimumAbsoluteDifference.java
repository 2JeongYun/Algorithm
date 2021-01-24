package hackerRank.interviewPreparationKit.GreedyAlgorithms;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MinimumAbsoluteDifference {

    // Complete the minimumAbsoluteDifference function below.
    static int minimumAbsoluteDifference(int[] arr) {
        PriorityQueue<Integer> minusNums = new PriorityQueue<>();
        PriorityQueue<Integer> plusNums = new PriorityQueue<>();
        for (int num : arr) {
            if (num < 0) {
                num = num * -1;
                minusNums.add(num);
            } else {
                plusNums.add(num);
            }
        }
        
        int minDiffSign = Integer.MAX_VALUE;
        int minMinusDiff = Integer.MAX_VALUE;
        int minPlusDiff = Integer.MAX_VALUE;
        
        if (minusNums.isEmpty() == false && plusNums.isEmpty() == false) {
            minDiffSign = minusNums.peek() + plusNums.peek();
        }
        
        if (minusNums.size() >= 2) {
            int prev = minusNums.poll();
            while (minusNums.isEmpty() == false) {
                int cur = minusNums.poll();
                minMinusDiff = Integer.min(minMinusDiff, cur - prev);
                prev = cur;
            }
        }
        
        if (plusNums.size() >= 2) {
            int prev = plusNums.poll();
            while (plusNums.isEmpty() == false) {
                int cur = plusNums.poll();
                minPlusDiff = Integer.min(minPlusDiff, cur - prev);
                prev = cur;
            }
        }
        
        int ret = Integer.min(minPlusDiff, minMinusDiff);
        ret = Integer.min(ret, minDiffSign);
        
        return ret;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = minimumAbsoluteDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
