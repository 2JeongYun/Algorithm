package baekjoon.dynamic;

import java.io.*;
import java.util.StringTokenizer;

public class LIS {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private void solution() throws IOException {
        final int N = Integer.valueOf(br.readLine());
        int[] dp = new int[N + 1];
        int[] a = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int n = 1; n <= N; n++) {
            a[n] = Integer.valueOf(st.nextToken());
        }

        int ans = 0;
        for (int n = 1; n <= N; n++) {
            for (int k = n - 1; k >= 0; k--) {
                if (a[n] > a[k]) {
                    dp[n] = Integer.max(dp[n], dp[k] + 1);
                    ans = Integer.max(ans, dp[n]);
                }
            }
        }

        bw.write(String.valueOf(ans));
    }

    public static void main(String[] args) throws IOException {
        LIS sol = new LIS();
        sol.solution();

        bw.flush();
        bw.close();
        br.close();
    }
}
