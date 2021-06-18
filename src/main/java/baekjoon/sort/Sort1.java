package baekjoon.sort;

import java.io.*;
import java.util.Arrays;

public class Sort1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final int N = Integer.valueOf(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.valueOf(br.readLine());
        }
        Arrays.sort(arr);

        for (int i : arr)
            bw.write(String.format("%d\n", i));

        bw.flush();
        br.close();
        bw.close();
    }
}
