package hackerRank.interviewPreparationKit.sorting;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CountingInversions {

    // Complete the countInversions function below.
    static long countInversions(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);

    }

    static long mergeSort(int[] arr, int s, int e) {
        long ret = 0;
        int midIdx = (s + e) / 2;
        if (s >= e) {
            return 0;
        }

        ret += mergeSort(arr, s, midIdx);
        ret += mergeSort(arr, midIdx + 1, e);
        ret += merge(arr, s, midIdx, e);
        return ret;
    }

    static long merge(int[] arr, int s, int midIdx, int e) {
        int leftIdx = s;
        int rightIdx = midIdx + 1;
        int tempIdx = 0;
        long ret = 0;

        int[] temp = new int[e - s + 1];
        while (leftIdx <= midIdx && rightIdx <= e) {
            if (arr[leftIdx] > arr[rightIdx]) {
                temp[tempIdx++] = arr[rightIdx++];
                ret += (midIdx + 1) - leftIdx;
            } else {
                temp[tempIdx++] = arr[leftIdx++];
            }
        }

        if (leftIdx > midIdx) {
            while (rightIdx <= e) {
                temp[tempIdx++] = arr[rightIdx++];
            }
        } else {
            while (leftIdx <= midIdx) {
                temp[tempIdx++] = arr[leftIdx++];
            }
        }

        for (int i = 0; i < temp.length; i++) {
            arr[i + s] = temp[i];
        }

        return ret;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            long result = countInversions(arr);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
