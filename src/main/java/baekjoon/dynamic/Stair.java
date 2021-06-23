package baekjoon.dynamic;

import java.io.*;

public class Stair {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private void solution() throws IOException {
        int n = Integer.valueOf(br.readLine());
        int[] score = new int[n + 1];
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            score[i] = Integer.valueOf(br.readLine());
        }

        dp[1] = score[1];
        if (n >= 2)
            dp[2] = score[1] + score[2];
        if (n >= 3)
            dp[3] = Integer.max(score[1] + score[3], score[2] + score[3]);
        for (int i = 4; i <= n; i++) {
            dp[i] = Integer.max(dp[i - 2] + score[i], dp[i - 3] + score[i - 1] + score[i]);
        }

        bw.write(String.valueOf(dp[n]));
    }

    public static void main(String[] args) throws IOException {
        Stair sol = new Stair();
        sol.solution();

        bw.flush();
        bw.close();
        br.close();
    }
}
