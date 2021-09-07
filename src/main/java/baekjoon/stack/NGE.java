package baekjoon.stack;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class NGE {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private void solution() throws IOException {
        StringBuffer sb = new StringBuffer();

        final int N = Integer.valueOf(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Number> stack = new Stack<>();
        int[] ans = new int[N];

        for (int i = 0; i < N; i++) {
            int cur = Integer.valueOf(st.nextToken());
            while (!stack.isEmpty() && stack.peek().num < cur) {
                Number numObj = stack.pop();
                ans[numObj.idx] = cur;
            }

            stack.push(new Number(cur, i));
        }

        while (!stack.isEmpty()) {
            ans[stack.pop().idx] = -1;
        }

        for (int i = 0; i < ans.length; i++) {
            sb.append(ans[i] + " ");
        }
        bw.write(sb.toString());
    }

    static class Number {
        int num;
        int idx;

        Number(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws IOException {
        NGE sol = new NGE();
        sol.solution();

        bw.flush();
        bw.close();
        br.close();
    }
}
