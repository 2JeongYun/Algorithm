package baekjoon.greedy;

import java.io.*;
import java.util.StringTokenizer;

public class Coin {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private void solution() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] coins = new int[Integer.valueOf(st.nextToken())];
        int remain = Integer.valueOf(st.nextToken());

        for (int i = 0; i < coins.length; i++) {
            coins[i] = Integer.valueOf(br.readLine());
        }

        int ans = 0;
        for (int i = coins.length - 1; i >= 0; i--) {
            if (remain >= coins[i]) {
                ans += remain / coins[i];
                remain %= coins[i];
            }
        }

        bw.write(String.valueOf(ans));
    }

    public static void main(String[] args) throws IOException {
        Coin sol = new Coin();
        sol.solution();

        bw.flush();
        bw.close();
        br.close();
    }
}
