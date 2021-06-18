package baekjoon.sort;

import java.io.*;

public class Sort3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        int[] counter = new int[10001];
        final int N = Integer.valueOf(br.readLine());
        for (int i = 0; i < N; i++)
            counter[Integer.valueOf(br.readLine())]++;

        for (int i = 0; i < 10001; i++) {
            if (counter[i] > 0) {
                for (int j = 0; j < counter[i]; j++)
                    sb.append(i).append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
