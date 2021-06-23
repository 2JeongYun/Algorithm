package baekjoon.dynamic;

import java.io.*;
import java.util.StringTokenizer;

public class Triangle {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private void solution() throws IOException {
        int n = Integer.valueOf(br.readLine());
        int[][] triangle = new int[n + 1][n + 1];
        int[][] dp = new int[n + 1][n + 1];
        for (int y = 1; y <= n; y++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int x = 1; x <= y; x++) {
                triangle[y][x] = Integer.valueOf(st.nextToken());
            }
        }

        dp[1][1] = triangle[1][1];
        for (int y = 1; y <= n; y++) {
            for (int x = 1; x <= y; x++) {
                dp[y][x] = Integer.max(dp[y - 1][x - 1], dp[y - 1][x]) + triangle[y][x];
            }
        }
        int ans = 0;
        for (int x = 1; x <= n; x++) {
            ans = dp[n][x] > ans ? dp[n][x] : ans;
        }
        bw.write(String.valueOf(ans));
    }

    public static void main(String[] args) throws IOException {
        Triangle sol = new Triangle();
        sol.solution();

        bw.flush();
        bw.close();
        br.close();
    }
}
