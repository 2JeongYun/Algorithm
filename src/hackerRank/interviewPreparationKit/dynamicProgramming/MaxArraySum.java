package hackerRank.interviewPreparationKit.dynamicProgramming;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MaxArraySum {

    // Complete the maxSubsetSum function below.
    static int maxSubsetSum(int[] arr) {
        int[] cache = new int[arr.length + 2];

        int idx = arr.length - 1;
        while (idx >= 0) {
            int max = Integer.max(cache[idx + 1], cache[idx + 2] + arr[idx]);
            max = (max < 0) ? 0 : max;

            cache[idx] = max;
            idx--;
        }

        return cache[0];
    }

    // Using recursive : fail
    // Maybe stack overflow
    static int getMaxSubset(int[] arr, int[] cache, int idx) {
        if (idx >= arr.length) {
            return 0;
        }

        if (cache[idx] != -1) {
            return cache[idx];
        }

        int positiveIdx = findPositive(arr, idx);
        if (positiveIdx == -1) {
            return 0;
        }

        int cand1 = arr[positiveIdx] + getMaxSubset(arr, cache, positiveIdx + 2);
        int cand2 = getMaxSubset(arr, cache, positiveIdx + 1);

        int ret = Integer.max(cand1, cand2);
        ret = (ret < 0) ? 0 : ret;

        cache[idx] = ret;
        return ret;
    }

    static int findPositive(int[] arr, int idx) {
        while (idx < arr.length && arr[idx] <= 0) {
            idx++;
        }

        return (idx == arr.length) ? -1 : idx;
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

        int res = maxSubsetSum(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
