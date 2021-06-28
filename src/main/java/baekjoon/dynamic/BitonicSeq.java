package baekjoon.dynamic;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BitonicSeq {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private void solution() throws IOException {
        final int N = Integer.valueOf(br.readLine());
        int[] seq = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            seq[i] = Integer.valueOf(st.nextToken());
        }

        int[] up = new int[N + 1];
        int[] down = new int[N + 1];
        Arrays.fill(up, 1);
        Arrays.fill(down, 1);

        for (int n = 1; n <= N; n++) {
            for (int k = 1; k <= n; k++) {
                if (seq[k] < seq[n]) {
                    up[n] = Integer.max(up[n], up[k] + 1);
                } else if (seq[k] == seq[n]) {
                    up[n] = Integer.max(up[n], up[k]);
                }
            }
        }

        for (int n = N; n >= 1; n--) {
            for (int k = N; k >= n; k--) {
                if (seq[k] < seq[n]) {
                    down[n] = Integer.max(down[n], down[k] + 1);
                } else if (seq[k] == seq[n]) {
                    down[n] = Integer.max(down[n], down[k]);
                }
            }
        }

        int ans = 0;
        for (int n = 1; n <= N; n++) {
            int val = up[n] + down[n] - 1;
            if (ans < val)
                ans = val;
        }

        bw.write(String.valueOf(ans));
    }

    public static void main(String[] args) throws IOException {
        BitonicSeq sol = new BitonicSeq();
        sol.solution();

        bw.flush();
        bw.close();
        br.close();
    }
}
