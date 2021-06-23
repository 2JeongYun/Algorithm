package baekjoon.dynamic;

import java.io.*;

public class Tile {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private void solution() throws IOException {
        int n = Integer.valueOf(br.readLine());
        int[] dp = new int[n + 1];
        dp[1] = 1;
        if (n >= 2)
            dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 15746;
        }
        bw.write(String.valueOf(dp[n]));
    }

    public static void main(String[] args) throws IOException {
        Tile sol = new Tile();
        sol.solution();

        bw.flush();
        bw.close();
        br.close();
    }
}
