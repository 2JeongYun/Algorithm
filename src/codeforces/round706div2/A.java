package codeforces.round706div2;

import java.io.*;
import java.util.StringTokenizer;

public class A {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int TC = Integer.parseInt(br.readLine());
        for (int i = 0; i < TC; i++) {
            solve(br, bw);
        }

        br.close();
        bw.close();
    }

    public void solve(BufferedReader br, BufferedWriter bw) throws IOException {
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
        char[] s = br.readLine().toCharArray();

        if (k == 0) {
            System.out.println("YES");
            return;
        }
        if (n == 2 * k) {
            System.out.println("NO");
            return;
        }

        for (int i = 0; i < k; i++) {
            int rIdx = s.length - 1 - i;
            if (s[i] != s[rIdx] || i == rIdx) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }

    public static void main(String[] args) throws IOException {
        A p = new A();
        p.solution();
    }
}
