package baekjoon.backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class NAndM1 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.valueOf(st.nextToken()), m = Integer.valueOf(st.nextToken());
        printSeq(new int[m], 0, n, new boolean[n + 1]);
        bw.flush();
        bw.close();
        br.close();
    }

    public static void printSeq(int[] arr, int idx, int max, boolean[] visit) throws IOException {
        if (idx == arr.length) {
            for (int i : arr) {
                bw.write(Integer.toString(i) + " ");
            }
            bw.write("\n");
            return;
        }
        for (int i = 1; i <= max; i++) {
            if (visit[i] == true)
                continue;
            arr[idx] = i;
            visit[i] = true;
            printSeq(arr, idx + 1, max, visit);
            visit[i] = false;
        }
    }
}
