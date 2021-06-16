package baekjoon.bruteforce;

import java.io.*;

public class Sum {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.valueOf(br.readLine());
        for (int i = 0; i <= n; i++) {
            if (getSum(i) == n) {
                bw.write(Integer.toString(i));
                break;
            }
            if (i == n) {
                bw.write("0");
                break;
            }
        }
        bw.flush();
    }

    private static int getSum(int num) {
        int ret = num;
        while (num >= 1) {
            ret += num % 10;
            num /= 10;
        }
        return ret;
    }
}
