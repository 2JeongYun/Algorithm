package baekjoon.dynamic;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BackPackRecursive {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int[][] cache;

    private void solution() throws IOException {
        final int N, K;
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.valueOf(st.nextToken());
        K = Integer.valueOf(st.nextToken());
        int[] weights = new int[N];
        int[] values = new int[N];
        cache = new int[N][K + 1];
        for (int i = 0; i < N; i++) {
            Arrays.fill(cache[i], -1);
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            weights[i] = Integer.valueOf(st.nextToken());
            values[i] = Integer.valueOf(st.nextToken());
        }

        bw.write(String.valueOf(getMax(weights, values, K, 0)));
    }

    private int getMax(int[] weights, int[] values, int remain, int idx) {
        if (idx == weights.length)
            return 0;

        if (cache[idx][remain] != -1)
            return cache[idx][remain];

        int ret = 0;
        if (weights[idx] <= remain)
            ret = Integer.max(values[idx] + getMax(weights, values, remain - weights[idx], idx + 1),
                    getMax(weights, values, remain, idx + 1));
        else
            ret = getMax(weights, values, remain, idx + 1);

        cache[idx][remain] = ret;
        return ret;
    }

    public static void main(String[] args) throws IOException {
        BackPackRecursive sol = new BackPackRecursive();
        sol.solution();

        bw.flush();
        bw.close();
        br.close();
    }
}
