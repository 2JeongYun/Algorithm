package baekjoon.dynamic;

import java.io.*;

public class MakeOne {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private void solution() throws IOException {
        int n = Integer.valueOf(br.readLine());
        if (n == 1) {
            bw.write("0");
            return;
        }
        int[] dp = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            int minVal = dp[i - 1];
            if (i % 2 == 0)
                minVal = Integer.min(minVal, dp[i / 2]);
            if (i % 3 == 0)
                minVal = Integer.min(minVal, dp[i / 3]);
            dp[i] = minVal + 1;
        }
        bw.write(String.valueOf(dp[n]));
    }

    public static void main(String[] args) throws IOException {
        MakeOne sol = new MakeOne();
        sol.solution();

        bw.flush();
        bw.close();
        br.close();
    }
}
