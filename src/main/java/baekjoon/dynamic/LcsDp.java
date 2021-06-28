package baekjoon.dynamic;

import java.io.*;

public class LcsDp {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private void solution() throws IOException {
        String a = br.readLine();
        String b = br.readLine();
        int[][] dp = new int[a.length() + 1][b.length() + 1];
        for (int aIdx = 1; aIdx <= a.length(); aIdx++) {
            for (int bIdx = 1; bIdx <= b.length(); bIdx++) {
                if (a.charAt(aIdx - 1) == b.charAt(bIdx - 1))
                    dp[aIdx][bIdx] = dp[aIdx - 1][bIdx - 1] + 1;
                else
                    dp[aIdx][bIdx] = Integer.max(dp[aIdx - 1][bIdx], dp[aIdx][bIdx - 1]);
            }
        }

        bw.write(String.valueOf(dp[a.length()][b.length()]));
    }

    public static void main(String[] args) throws IOException {
        LcsDp sol = new LcsDp();
        sol.solution();

        bw.flush();
        bw.close();
        br.close();
    }
}
