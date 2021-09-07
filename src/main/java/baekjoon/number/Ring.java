package baekjoon.number;

import java.io.*;
import java.util.StringTokenizer;

public class Ring {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private void solution() throws IOException {
        final int N = Integer.valueOf(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int base = Integer.valueOf(st.nextToken());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N - 1; i++) {
            int cur = Integer.valueOf(st.nextToken());
            int gcd = gcd(base, cur);
            sb.append(base / gcd).append("/").append(cur / gcd).append("\n");
        }

        bw.write(sb.toString());
    }

    private int gcd(int a, int b) {
        int big = Integer.max(a, b);
        int small = Integer.min(a, b);

        int r;
        while ((r = big % small) != 0) {
            big = small;
            small = r;
        }
        return small;
    }

    public static void main(String[] args) throws IOException {
        Ring sol = new Ring();
        sol.solution();

        bw.flush();
        bw.close();
        br.close();
    }
}