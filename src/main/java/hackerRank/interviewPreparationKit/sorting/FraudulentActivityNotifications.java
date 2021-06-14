package hackerRank.interviewPreparationKit.sorting;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class FraudulentActivityNotifications {

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
        int[] expends = Arrays.copyOfRange(expenditure, 0, d);
        Arrays.sort(expends);
        int noticeCnt = 0;

        for (int i = d; i < expenditure.length; i++) {
            double mid;
            int midIdx = expends.length / 2;
            int cur = expenditure[i];
            if (d % 2 == 0) {
                mid = (double) (expends[midIdx - 1] + expends[midIdx]) / 2;
            } else {
                mid = (double) expends[midIdx];
            }

            if (cur >= mid * 2) {
                noticeCnt++;
            }

            mySort(expends, expenditure[i - d], cur);
        }

        return noticeCnt;
    }

    static void mySort(int[] arr, int outData, int inData) {
        int removeIdx = Arrays.binarySearch(arr, outData);
        int addIdx = findAddIdx(arr, 0, arr.length - 1, inData);

        if (removeIdx < addIdx) {
            for (int i = removeIdx; i < addIdx; i++) {
                arr[i] = arr[i + 1];
            }
        } else if (removeIdx > addIdx) {
            for (int i = removeIdx; i > addIdx; i--) {
                arr[i] = arr[i - 1];
            }
        }
        arr[addIdx] = inData;
    }

    static int findAddIdx(int[] arr, int s, int e, int inData) {
        if (s == e) {
            return s;
        }
        int midIdx = (s + e) / 2;
        int ret = -1;
        if (arr[midIdx] > inData) {
            ret = findAddIdx(arr, s, midIdx, inData);
        } else if (arr[midIdx] < inData) {
            ret = findAddIdx(arr, midIdx + 1, e, inData);
        } else {
            return midIdx;
        }
        return ret;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
