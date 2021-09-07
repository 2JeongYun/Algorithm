package baekjoon.number;

import java.io.*;
import java.util.StringTokenizer;

public class BinomialCoefficient {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private void solution() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.valueOf(st.nextToken()), b = Integer.valueOf(st.nextToken());
        int ans = factorial(a) / (factorial(b) * factorial(a - b));
        bw.write(String.valueOf(ans));
    }

    private int factorial(int n) {
        int ret = 1;
        while (n > 0) {
            ret *= n--;
        }
        return ret;
    }

    public static void main(String[] args) throws IOException {
        BinomialCoefficient sol = new BinomialCoefficient();
        sol.solution();

        bw.flush();
        bw.close();
        br.close();
    }
}
