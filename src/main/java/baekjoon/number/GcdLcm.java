package baekjoon.number;

import java.io.*;
import java.util.StringTokenizer;

public class GcdLcm {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private void solution() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.valueOf(st.nextToken());
        int b = Integer.valueOf(st.nextToken());

        int gcd = 1;
        int min = Integer.min(a, b);
        for (int i = 2; i <= min; i++) {
            if (a % i == 0 && b % i == 0) {
                gcd = i;
            }
        }

        int lcd = a * b / gcd;
        bw.write(gcd + "\n" + lcd);
    }

    public static void main(String[] args) throws IOException {
        GcdLcm sol = new GcdLcm();
        sol.solution();

        bw.flush();
        bw.close();
        br.close();
    }
}
