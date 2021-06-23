package baekjoon.dynamic;

import java.io.*;
import java.util.Arrays;

public class Fibonacci {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();

    private void solution() throws IOException {
        int n = Integer.valueOf(br.readLine());

        for (int tc = 0; tc < n; tc++) {
            int[][] dp = new int[2][41];
            for (int i = 0; i < dp.length; i++) {
                Arrays.fill(dp[i], -1);
            }
            dp[0][0] = 1;
            dp[0][1] = 0;
            dp[1][0] = 0;
            dp[1][1] = 1;
            int[] ans = fibo(Integer.valueOf(br.readLine()), dp);
            sb.append(ans[0]).append(" ").append(ans[1]).append("\n");
        }
        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    private int[] fibo(int n, int[][] dp) {
        int[] ret = new int[2];
        if (dp[0][n] != -1) {
            ret[0] = dp[0][n];
            ret[1] = dp[1][n];
            return ret;
        } else {
            ret[0] = fibo(n - 2, dp)[0] + fibo(n - 1, dp)[0];
            ret[1] = fibo(n - 2, dp)[1] + fibo(n - 1, dp)[1];

            dp[0][n] = ret[0];
            dp[1][n] = ret[1];
        }
        return ret;
    }

    public static void main(String[] args) throws IOException {
        Fibonacci sol = new Fibonacci();
        sol.solution();
    }
}
