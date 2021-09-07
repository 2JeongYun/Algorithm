package baekjoon.stack;

import java.io.*;
import java.util.Stack;

public class Seq {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private void solution() throws IOException {
        StringBuffer sb = new StringBuffer();
        Stack<Integer> stack = new Stack<>();

        final int N = Integer.valueOf(br.readLine());
        int top = 0;

        for (int i = 0; i < N; i++) {
            int input = Integer.valueOf(br.readLine());

            while (top < input) {
                stack.push(++top);
                sb.append("+\n");
            }

            Integer pop = stack.pop();
            if (pop == null || pop != input) {
                sb.setLength(0);
                sb.append("NO\n");
                break;
            }
            sb.append("-\n");
        }

        bw.write(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        Seq sol = new Seq();
        sol.solution();

        bw.flush();
        bw.close();
        br.close();
    }
}
