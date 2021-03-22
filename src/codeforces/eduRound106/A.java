package codeforces.eduRound106;

import java.io.*;
import java.util.StringTokenizer;

public class A {
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
        int n = Integer.parseInt(st.nextToken());
        int k1 = Integer.parseInt(st.nextToken());
        int k2 = Integer.parseInt(st.nextToken());

        int wCnt = (k1 + k2) / 2;
        int bCnt = ((2 * n) - (k1 + k2)) / 2;

        st = new StringTokenizer(br.readLine());
        int wDomino = Integer.parseInt(st.nextToken());
        int bDomino = Integer.parseInt(st.nextToken());

        if (wCnt >= wDomino && bCnt >= bDomino) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static void main(String[] args) throws IOException {
        A p = new A();
        p.solution();
    }
}
