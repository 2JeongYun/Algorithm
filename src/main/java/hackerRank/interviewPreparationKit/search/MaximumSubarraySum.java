package hackerRank.interviewPreparationKit.search;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

public class MaximumSubarraySum {

    // Complete the maximumSum function below.
    static long maximumSum(long[] a, long m) {
        TreeSet<Long> prev = new TreeSet<>();

        long max = 0;
        long currentSum = 0;
        for (int i = 0; i < a.length; i++) {
            currentSum = (currentSum + a[i] % m ) % m;
            Long highNum = prev.higher(currentSum);

            if (highNum != null) {
                max = Math.max(max, (currentSum - highNum + m) % m);
            }
            max = Math.max(max, currentSum);

            prev.add(currentSum);
        }

        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0]);

            long m = Long.parseLong(nm[1]);

            long[] a = new long[n];

            String[] aItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                long aItem = Long.parseLong(aItems[i]);
                a[i] = aItem;
            }

            long result = maximumSum(a, m);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
