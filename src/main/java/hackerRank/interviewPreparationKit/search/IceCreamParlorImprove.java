package hackerRank.interviewPreparationKit.search;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Scanner;

public class IceCreamParlorImprove {

    // Complete the whatFlavors function below.
    static void whatFlavors(int[] cost, int money) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashMap<Integer, Integer> costMap = new HashMap<>();
        for (int i = 0; i < cost.length; i++) {
            costMap.put(cost[i], i);
        }

        for (int i = 0; i < cost.length; i++) {
            int remainMoney = money - cost[i];
            if (costMap.containsKey(remainMoney) && costMap.get(remainMoney) != i) {
                bw.write(String.format("%d %d\n", i + 1, costMap.get(remainMoney) + 1));
                break;
            }
        }

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
