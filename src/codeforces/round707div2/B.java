//package codeforces.round707div2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            solve(br, bw);
        }

        br.close();
        bw.close();
    }

    public void solve(BufferedReader br, BufferedWriter bw) throws IOException {
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] p = new int[n];
        int[] creams = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }

        boolean firstCake = false;
        if (p[0] != 0) {
            firstCake = true;
        }
        for (int i = 0; i < n; i++) {
            if (p[i] != 0) {
                int mark = i - p[i] + 1;
                if (mark < 0) {
                    mark = 0;
                }
                creams[mark] = i;
            }
        }

        int creamSpot = -1;
        for (int i = 0; i < n; i++) {
            if (creams[i] >= creamSpot) {
                creamSpot = creams[i];
            }

            if (i <= creamSpot) {
                if (i == 0 && creams[0] == 0 && firstCake == false) {
                    bw.write("0 ");
                } else {
                    bw.write("1 ");
                }
            } else {
                bw.write("0 ");
            }
        }
        bw.newLine();
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        B p = new B();
        p.solution();
    }
}
