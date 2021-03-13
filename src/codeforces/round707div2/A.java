//package codeforces.round707div2;

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
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] arrive = new int[n + 1];
        int[] depart = new int[n + 1];
        int[] tm = new int[n + 1];
        int[] realA = new int[n + 1];
        int[] realB = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            arrive[i] = Integer.parseInt(st.nextToken());
            depart[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            tm[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < n + 1; i++) {
            realA[i] = realB[i - 1] + tm[i] + arrive[i] - depart[i - 1];
            int stayTime = (int) Math.ceil((double) (depart[i] - arrive[i]) / 2);
            if (realA[i] + stayTime >= depart[i]) {
                realB[i] = realA[i] + stayTime;
            } else {
                realB[i] = depart[i];
            }
        }
        bw.write(Integer.toString(realA[n]));
        bw.newLine();
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        A p = new A();
        p.solution();
    }
}
