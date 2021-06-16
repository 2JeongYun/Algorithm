package baekjoon.math;

import java.io.*;

public class Factorization {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.valueOf(br.readLine());

        int rootN = (int) Math.ceil(Math.sqrt(n));
        while (n > 1) {
            int base = n;
            for (int i = 2; i <= rootN; i++) {
                if (n % i == 0) {
                    n = n / i;
                    bw.write(String.format("%d\n", i));
                    break;
                }
            }
            if (base == n) {
                bw.write(String.format("%d\n", base));
                break;
            }
        }
        bw.flush();
    }
}
