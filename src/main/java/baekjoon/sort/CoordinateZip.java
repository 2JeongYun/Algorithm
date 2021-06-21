package baekjoon.sort;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class CoordinateZip {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        final int N = Integer.valueOf(br.readLine());

        int[] arr = new int[N];
        Map<Integer, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.valueOf(st.nextToken());
        }
        int[] origin = Arrays.copyOf(arr, N);

        Arrays.sort(arr);
        int count = 0;
        map.put(arr[0], count);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] != arr[i]) {
                count++;
                map.put(arr[i], count);
            }
        }

        for (int i = 0; i < origin.length; i++) {
            sb.append(map.get(origin[i])).append(" ");
        }
        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
