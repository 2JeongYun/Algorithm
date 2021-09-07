package baekjoon.number;

import java.io.*;
import java.math.BigInteger;

public class Factorial0 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private void solution() throws IOException {
        int n = Integer.valueOf(br.readLine());
        BigInteger bigInteger = new BigInteger("1");
        if (n == 0) {
            bw.write("0");
            return;
        }
        while (n > 0) {
            bigInteger = bigInteger.multiply(new BigInteger(String.valueOf(n--)));
        }

        String res = bigInteger.toString();
        int idx = res.length() - 1;
        char ch;
        int ans = 0;
        while ((ch = res.charAt(idx--)) == '0') {
            ans++;
        }

        bw.write(String.valueOf(ans));
    }

    public static void main(String[] args) throws IOException {
        Factorial0 sol = new Factorial0();
        sol.solution();

        bw.flush();
        bw.close();
        br.close();
    }
}
