package codeforces.eduRound106;

import java.io.*;

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
        String line = br.readLine();

        boolean dupOne = false;

        char prev = '-';
        for (int i = 0; i < line.length(); i++) {
            char cur = line.charAt(i);

            if (prev == '1' && cur == '1') {
                dupOne = true;
            }

            if (prev == '0' && cur == '0' && dupOne) {
                System.out.println("NO");
                return;
            }

            prev = cur;
        }
        System.out.println("YES");
    }

    public static void main(String[] args) throws IOException {
        B p = new B();
        p.solution();
    }
}
