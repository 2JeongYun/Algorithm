package programmers.dynamic;

import myutil.Util;

import static myutil.Util.*;

public class School {

    public int solution(int m, int n, int[][] puddles) {
        final int LIMIT = 1000000007;
        int[][] dp = new int[m + 2][n + 2];

        for (int i = 0; i < puddles.length; i++) {
            dp[puddles[i][0]][puddles[i][1]] = -1;
        }

        dp[1][1] = 1;
        for (int y = 1; y < dp.length - 1; y++) {
            for (int x = 1; x < dp[y].length - 1; x++) {
                if (dp[y][x] == -1 || (y == 1 && x == 1)) {
                    continue;
                }

                int left = (dp[y][x - 1] == -1) ? 0 : dp[y][x - 1];
                int up = (dp[y - 1][x] == -1) ? 0 : dp[y - 1][x];
                dp[y][x] = (left + up) % LIMIT;
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        School p = new School();

        int t = 1;
        //t = getTestCaseCount();

        for (int i = 0; i < t; i++) {
            /*
             * Type var = getTypeArr[]
             * Type ...
             * ...
             * print(p.solution());
             */
            print(p.solution(getInt(), getInt(), getTwoDimensionalIntArray()));
        }

        Util.closeUtil();
    }
}
