package baekjoon.number;

import java.io.*;
import java.util.StringTokenizer;

public class Lcm {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private void solution() throws IOException {
        final int N = Integer.valueOf(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());
            int gcd = gcd(Integer.max(a, b), Integer.min(a, b));
            bw.write((a * b / gcd) + "\n");
        }
    }

    private int gcd(int a, int b) {
        int r = a % b;
        if (r == 0)
            return b;
        else
            return gcd(b, r);
    }

    public static void main(String[] args) throws IOException {
        Lcm sol = new Lcm();
        sol.solution();

        bw.flush();
        bw.close();
        br.close();
    }
}
