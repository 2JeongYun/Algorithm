//package codeforces.round706div2;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class C {
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
        PriorityQueue<Integer> miners = new PriorityQueue<>();
        PriorityQueue<Integer> mines = new PriorityQueue<>();
        for (int i = 0; i < n * 2; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            if (x == 0) {
                miners.add(Math.abs(y));
            } else {
                mines.add(Math.abs(x));
            }
        }
        double ans = 0;
        while (mines.isEmpty() == false) {
            ans += energy(mines.poll(), miners.poll());
        }
        bw.write(Double.toString(ans));
        bw.newLine();
        bw.flush();
    }

    public double energy(int x, int y) {
        return Math.sqrt((double)x * x + (double)y * y);
    }

    public static void main(String[] args) throws IOException {
        C p = new C();
        p.solution();
    }
}
