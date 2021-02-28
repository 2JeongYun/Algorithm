package this_is_coding_test.ch16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ResignBottomUp {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] T;
        int[] P;
        int[] dp;

        int N = Integer.parseInt(br.readLine());
        T = new int[N];
        P = new int[N];
        dp = new int[N + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            if (i + T[i] <= T.length) {
                dp[i + T[i]] = Integer.max(dp[i + T[i]], dp[i] + P[i]);
            }
            if (i >= 1) {
                dp[i + 1] = Integer.max(dp[i], dp[i + 1]);
            }
        }

        System.out.println(dp[N]);
    }

    public static void main(String[] args) throws IOException {
        ResignBottomUp r = new ResignBottomUp();
        r.solution();
    }
}
