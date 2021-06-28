package baekjoon.dynamic;

import java.io.*;

public class WineTasting {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private void solution() throws IOException {
        final int N = Integer.valueOf(br.readLine());
        int[] dp = new int[N + 1];
        int[] wine = new int[N + 1];

        for (int n = 1; n <= N; n++) {
            wine[n] = Integer.valueOf(br.readLine());
        }

        dp[1] = wine[1];
        if (N >= 2)
            dp[2] = wine[1] + wine[2];

        for (int n = 3; n <= N; n++) {
            int cur = Integer.max(dp[n - 3] + wine[n - 1], dp[n - 2]);
            cur += wine[n];
            cur = Integer.max(cur, dp[n - 1]);
            dp[n] = cur;
        }

        bw.write(String.valueOf(dp[N]));
    }

    public static void main(String[] args) throws IOException {
        WineTasting sol = new WineTasting();
        sol.solution();

        bw.flush();
        bw.close();
        br.close();
    }
}
