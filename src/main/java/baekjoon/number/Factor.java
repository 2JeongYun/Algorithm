package baekjoon.number;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Factor {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private void solution() throws IOException {
        final int N = Integer.valueOf(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.valueOf(st.nextToken());
        }

        Arrays.sort(arr);
        bw.write(String.valueOf(arr[0] * arr[arr.length - 1]));
    }

    public static void main(String[] args) throws IOException {
        Factor sol = new Factor();
        sol.solution();

        bw.flush();
        bw.close();
        br.close();
    }
}
