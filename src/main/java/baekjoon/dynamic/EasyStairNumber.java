package baekjoon.dynamic;

import java.io.*;

public class EasyStairNumber {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private void solution() throws IOException {
        final int N = Integer.valueOf(br.readLine());
        final int MOD = 1000000000;
        int[][] dp = new int[N + 1][10];

        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int n = 2; n <= N; n++) {
            for (int k = 0; k < 10; k++) {
                long prev = 0;
                if (k - 1 >= 0)
                    prev += dp[n - 1][k - 1];
                if (k + 1 < 10)
                    prev += dp[n - 1][k + 1];
                dp[n][k] = (int) prev % MOD;
            }
        }

        long ans = 0;
        for (int i = 0; i < 10; i++) {
            ans += dp[N][i];
        }
        ans %= MOD;
        bw.write(String.valueOf(ans));
    }

    public static void main(String[] args) throws IOException {
        EasyStairNumber sol = new EasyStairNumber();
        sol.solution();

        bw.flush();
        bw.close();
        br.close();
    }
}
