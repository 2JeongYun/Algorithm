package hackerRank.interviewPreparationKit.search;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class IceCreamParlor {

    // Complete the whatFlavors function below.
    static void whatFlavors(int[] cost, int money) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] costOrigin = (int[]) cost.clone();
        Arrays.sort(cost);

        int ice1 = -1;
        int ice2 = -1;
        for (int i = 0; i < cost.length; i++) {
            int remainPrice = money - cost[i];
            ice1 = cost[i];

            int idx = Arrays.binarySearch(cost, i + 1, cost.length, remainPrice);
            if (idx >= 0) {
                ice2 = cost[idx];
                break;
            }
        }

        int findCnt = 0;
        for (int i = 0; i < costOrigin.length; i++) {
            if (costOrigin[i] == ice1 || costOrigin[i] == ice2) {
                bw.write(String.format("%d ", i + 1));
                findCnt++;
            }
            if (findCnt == 2) {
                break;
            }
        }
        bw.write("\n");
        bw.flush();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int money = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] cost = new int[n];

            String[] costItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int costItem = Integer.parseInt(costItems[i]);
                cost[i] = costItem;
            }

            whatFlavors(cost, money);
        }

        scanner.close();
    }
}

