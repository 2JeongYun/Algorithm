package baekjoon.dynamic;

import java.io.*;
import java.util.StringTokenizer;

public class FunRecursive {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private void solution() throws IOException {
        int[][][] dp = new int[21][21][21];
        StringBuilder sb = new StringBuilder();

        String line;
        while (!(line = br.readLine()).equals("-1 -1 -1")) {
            StringTokenizer st = new StringTokenizer(line);
            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());
            int c = Integer.valueOf(st.nextToken());
            int ans = w(dp, a, b, c);
            sb.append(String.format("w(%d, %d, %d) = %d\n", a, b, c, ans));
        }

        bw.write(sb.toString());
    }

    private int w(int[][][] dp, int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        } else if (a > 20 || b > 20 || c > 20) {
            return w(dp, 20, 20, 20);
        }

        int ret;
        if (dp[a][b][c] != 0)
            return dp[a][b][c];

        if (a < b && b < c) {
            ret = w(dp, a, b, c - 1) + w(dp, a, b - 1, c - 1) - w(dp, a, b - 1, c);
        } else {
            ret = w(dp, a - 1, b, c)
                    + w(dp, a - 1, b - 1, c)
                    + w(dp, a - 1, b, c - 1)
                    - w(dp, a - 1, b - 1, c - 1);
        }

        dp[a][b][c] = ret;
        return ret;
    }

    public static void main(String[] args) throws IOException {
        FunRecursive sol = new FunRecursive();
        sol.solution();

        bw.flush();
        bw.close();
        br.close();
    }
}
