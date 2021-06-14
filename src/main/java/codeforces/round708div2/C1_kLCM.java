package codeforces.round708div2;

import java.io.*;
import java.util.StringTokenizer;

public class C1_kLCM {
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        if (n % 2 == 0) {
            int half = n / 2;
            if (half % 2 == 1) {
                n -= 2;
                half = n / 2;
                bw.write(String.format("%d %d %d", 2, half, half));
            } else {
                bw.write(String.format("%d %d %d", half, half / 2, half / 2));
            }
        } else {
            int half = n / 2;
            bw.write(String.format("%d %d %d", half, half, 1));
        }
        bw.newLine();
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        C1_kLCM p = new C1_kLCM();
        p.solution();
    }
}
