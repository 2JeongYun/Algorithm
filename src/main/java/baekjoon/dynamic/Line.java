package baekjoon.dynamic;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Line {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private void solution() throws IOException {
        final int N = Integer.valueOf(br.readLine());
        int[][] location = new int[N + 1][2];
        int[] dp = new int[N + 1];

        for (int n = 1; n <= N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            location[n][0] = Integer.valueOf(st.nextToken());
            location[n][1] = Integer.valueOf(st.nextToken());
        }

        Arrays.sort(location, (o1, o2) -> {
            if (o1[0] < o2[0]) {
                return -1;
            } else if (o1[0] > o2[0]) {
                return 1;
            } else {
                return 0;
            }
        });

        Arrays.fill(dp, 1);
        int maxLineCnt = 0;
        for (int n = 1; n <= N; n++) {
            for (int k = 1; k < n; k++) {
                if (location[k][1] < location[n][1]) {
                    dp[n] = Integer.max(dp[n], dp[k] + 1);
                    if (maxLineCnt < dp[n]) {
                        maxLineCnt = dp[n];
                    }
                }
            }
        }

        bw.write(String.valueOf(N - maxLineCnt));
    }

    public static void main(String[] args) throws IOException {
        Line sol = new Line();
        sol.solution();

        bw.flush();
        bw.close();
        br.close();
    }
}
