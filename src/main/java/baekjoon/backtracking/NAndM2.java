package baekjoon.backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class NAndM2 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringBuilder sb = new StringBuilder();
    static int n, m;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.valueOf(st.nextToken());
        m = Integer.valueOf(st.nextToken());
        dfs(new int[m], -1, 0, new boolean[n + 1]);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int[] arr, int prev, int idx, boolean[] visit) {
        if (idx == m) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (i <= prev || visit[i])
                continue;
            arr[idx] = i;
            visit[i] = true;
            dfs(arr, i, idx + 1, visit);
            visit[i] = false;
        }
    }
}
