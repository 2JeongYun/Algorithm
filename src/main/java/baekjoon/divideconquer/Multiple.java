package baekjoon.divideconquer;

import java.io.*;
import java.util.StringTokenizer;

public class Multiple {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private void solution() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.valueOf(st.nextToken());
        int b = Integer.valueOf(st.nextToken());
        int c = Integer.valueOf(st.nextToken());

        a %= c;
        System.out.println(multiple(a, b, c));
    }

    public long multiple(int a, int b, int c) {
        if (b == 0) {
            return 1;
        }

        if ((b & 1) == 1) {
            b--;
            long m = multiple(a, b / 2, c) % c;
            return (((m * m) % c) * a )% c;
        } else {
            long m = multiple(a, b / 2, c) % c;
            return (m * m) % c;
        }
    }

    public static void main(String[] args) throws IOException {
        Multiple sol = new Multiple();
        sol.solution();

        bw.flush();
        bw.close();
        br.close();
    }
}
