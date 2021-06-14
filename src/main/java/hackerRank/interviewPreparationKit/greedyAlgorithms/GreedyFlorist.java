package hackerRank.interviewPreparationKit.greedyAlgorithms;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GreedyFlorist {

    // Complete the getMinimumCost function below.
    static int getMinimumCost(int k, int[] c) {
        int ret = 0;

        Queue<Integer>[] buyLists = new Queue[k];
        for (int i = 0; i < buyLists.length; i++) {
            buyLists[i] = new LinkedList<>();
        }

        Arrays.sort(c);

        for (int i = c.length - 1; i >= 0; i--) {
            buyLists[i % k].add(c[i]);
        }

        for (int i = 0; i < buyLists.length; i++) {
            ret += getTotalPrice(buyLists[i]);
        }

        return ret;
    }

    static int getTotalPrice(Queue buyQueue) {
        int ret = 0;
        int purchaseCnt = 0;
        while (buyQueue.isEmpty() == false) {
            int price = (int) buyQueue.poll();
            ret += (++purchaseCnt) * price;
        }
        return ret;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int minimumCost = getMinimumCost(k, c);

        bufferedWriter.write(String.valueOf(minimumCost));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
