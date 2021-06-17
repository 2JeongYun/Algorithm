package baekjoon.bruteforce;

import java.io.*;

public class MovieDirector {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final int N = Integer.valueOf(br.readLine());

        int number = 0;
        int title = 0;
        while (number < N) {
            title++;
            if (Integer.toString(title).contains("666")) {
                number++;
            }
        }

        bw.write(Integer.toString(title));
        bw.flush();

        br.close();
        bw.close();
    }
}
