package baekjoon.stack;

import java.io.*;
import java.util.Stack;

public class Zero {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private void solution() throws IOException {
        Stack<Integer> stack = new Stack<>();
        final int N = Integer.valueOf(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.valueOf(br.readLine());

            if (num == 0) {
                stack.pop();
            } else {
                stack.push(num);
            }
        }

        int ret = 0;
        while (!stack.isEmpty()) {
            ret += stack.pop();
        }

        System.out.println(ret);
    }

    public static void main(String[] args) throws IOException {
        Zero sol = new Zero();
        sol.solution();

        bw.flush();
        bw.close();
        br.close();
    }
}
