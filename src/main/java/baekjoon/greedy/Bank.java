package baekjoon.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bank {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private void solution() throws IOException {
        final int N = Integer.valueOf(br.readLine());
        int[] p = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < p.length; i++) {
            p[i] = Integer.valueOf(st.nextToken());
        }
        Arrays.sort(p);
        int ans = 0;
        for (int i = 0; i < p.length; i++) {
            ans += p[i] * (p.length - i);
        }
        bw.write(String.valueOf(ans));
    }

    public static void main(String[] args) throws IOException {
        Bank sol = new Bank();
        sol.solution();

        bw.flush();
        bw.close();
        br.close();
    }
}
