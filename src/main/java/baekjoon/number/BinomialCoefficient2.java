package baekjoon.number;

import java.io.*;
import java.util.StringTokenizer;

public class BinomialCoefficient2 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private void solution() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.valueOf(st.nextToken()), b = Integer.valueOf(st.nextToken());
        int[][] dp = new int[a + 1][b + 1];

        if (b == 0) {
            bw.write("1");
            return;
        }

        for (int n = 1; n <= a; n++) {
            dp[n][1] = n;
        }

        for (int r = 2; r <= b; r++) {
            for (int n = 1; n <= a; n++) {
                if (n == r)
                    dp[n][r] = 1;
                else
                    dp[n][r] = (dp[n - 1][r - 1] + dp[n - 1][r]) % 10007;
            }
        }

        bw.write(String.valueOf(dp[a][b]));
    }

    public static void main(String[] args) throws IOException {
        BinomialCoefficient2 sol = new BinomialCoefficient2();
        sol.solution();

        bw.flush();
        bw.close();
        br.close();
    }
}
