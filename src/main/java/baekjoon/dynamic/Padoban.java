package baekjoon.dynamic;

import java.io.*;

public class Padoban {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();

    private void solution() throws IOException {
        final int TC = Integer.valueOf(br.readLine());
        long[] dp = new long[101];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;
        for (int t = 0; t < TC; t++) {
            int n = Integer.valueOf(br.readLine());
            if (dp[n] == 0) {
                for (int i = 6; i <= n; i++) {
                    dp[i] = dp[i - 1] + dp[i - 5];
                }
            }
            sb.append(dp[n]).append("\n");
        }
        bw.write(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        Padoban sol = new Padoban();
        sol.solution();

        bw.flush();
        bw.close();
        br.close();
    }
}
