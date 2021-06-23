package baekjoon.dynamic;

import java.io.*;
import java.util.StringTokenizer;

public class RgbDistance {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private void solution() throws IOException {
        final int R = 0, G = 1, B = 2;
        final int RGB_SIZE = 3;
        int n = Integer.valueOf(br.readLine());
        int[][] cost = new int[n + 1][RGB_SIZE];
        int[][] dp = new int[n + 1][RGB_SIZE];

        for (int house = 1; house <= n; house++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int color = 0; color < RGB_SIZE; color++) {
                cost[house][color] = Integer.valueOf(st.nextToken());
            }
        }

        for (int color = 0; color < RGB_SIZE; color++) {
            dp[1][color] = cost[1][color];
        }

        for (int house = 2; house <= n; house++) {
            for (int color = 0; color < RGB_SIZE; color++) {
                int prevMin;
                switch (color) {
                    case R:
                        prevMin = Integer.min(dp[house - 1][G], dp[house - 1][B]);
                        dp[house][color] = prevMin + cost[house][R];
                        break;
                    case G:
                        prevMin = Integer.min(dp[house - 1][R], dp[house - 1][B]);
                        dp[house][color] = prevMin + cost[house][G];
                        break;
                    case B:
                        prevMin = Integer.min(dp[house - 1][R], dp[house - 1][G]);
                        dp[house][color] = prevMin + cost[house][B];
                        break;
                }
            }
        }

        int ans = Integer.min(dp[n][R], dp[n][G]);
        ans = Integer.min(ans, dp[n][B]);
        bw.write(String.valueOf(ans));
    }

    public static void main(String[] args) throws IOException {
        RgbDistance sol = new RgbDistance();
        sol.solution();

        bw.flush();
        bw.close();
        br.close();
    }
}
