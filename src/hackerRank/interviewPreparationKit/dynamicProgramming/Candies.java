package hackerRank.interviewPreparationKit.dynamicProgramming;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Candies {

    // Complete the candies function below.
    static long candies(int n, int[] arr) {
        int[] candyCnt = new int[n];
        long ret = 0;


        candyCnt[0] = 1;
        //왼쪽에서 오른쪽
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] >= arr[i]) {
                candyCnt[i] = 1;
            } else {
                candyCnt[i] = candyCnt[i - 1] + 1;
            }
        }

        int prev = 1;
        //오른쪽에서 왼쪽
        for (int i = n - 2; i >= 0; i--) {
            int cnt = 0;
            if (arr[i + 1] >= arr[i]) {
                cnt = 1;
            } else {
                cnt = prev + 1;
            }
            candyCnt[i] = Integer.max(candyCnt[i], cnt);
            prev = cnt;
        }

        for (int i = 0; i < n; i++) {
            ret += candyCnt[i];
        }

        return ret;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int arrItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            arr[i] = arrItem;
        }

        long result = candies(n, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

