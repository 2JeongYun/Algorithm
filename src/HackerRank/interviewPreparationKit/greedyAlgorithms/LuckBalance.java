package hackerRank.interviewPreparationKit.greedyAlgorithms;

import java.io.*;
import java.util.*;

public class LuckBalance {

    // Complete the luckBalance function below.
    static int luckBalance(int k, int[][] contests) {
        PriorityQueue<Integer> importantContests = new PriorityQueue<>();
        int ret = 0;

        for (int[] contest : contests) {
            if (contest[1] == 1) {
                importantContests.add(contest[0]);
            } else {
                ret += contest[0];
            }
        }

        int mustWinCnt = importantContests.size() - k;
        for (int i = 0; i < mustWinCnt; i++) {
            ret -= importantContests.poll();
        }

        while (importantContests.isEmpty() == false) {
            ret += importantContests.poll();
        }

        return ret;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[][] contests = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] contestsRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int contestsItem = Integer.parseInt(contestsRowItems[j]);
                contests[i][j] = contestsItem;
            }
        }

        int result = luckBalance(k, contests);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

