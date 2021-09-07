package baekjoon.number;

import java.io.*;
import java.util.StringTokenizer;

public class Bridge {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private void solution() throws IOException {
        final int TC = Integer.valueOf(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[][] dp = new int[31][31];

        for (int n = 1; n < dp.length; n++) {
            for (int k = 0; k <= n; k++) {
                if (n == k) {
                    dp[n][k] = 1;
                } else if (k == 0) {
                    dp[n][k] = 1;
                } else {
                    dp[n][k] = dp[n - 1][k - 1] + dp[n - 1][k];
                }
            }
        }

        for (int i = 0; i < TC; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.valueOf(st.nextToken());
            int n = Integer.valueOf(st.nextToken());
            sb.append(dp[n][k]).append("\n");
        }

        bw.write(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        Bridge sol = new Bridge();
        sol.solution();

        bw.flush();
        bw.close();
        br.close();
    }
}
