package baekjoon.dynamic;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Integer.max;

public class BackPackDp {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private void solution() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.valueOf(st.nextToken()), K = Integer.valueOf(st.nextToken());
        int[] dp = new int[K + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.valueOf(st.nextToken());
            int value = Integer.valueOf(st.nextToken());
            for (int k = K; k >= weight; k--) {
                dp[k] = max(dp[k], dp[k - weight] + value);
            }
        }
        bw.write(String.valueOf(dp[K]));
    }

    public static void main(String[] args) throws IOException {
        BackPackDp sol = new BackPackDp();
        sol.solution();

        bw.flush();
        bw.close();
        br.close();
    }
}
