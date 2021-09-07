package baekjoon.stack;

import java.io.*;
import java.util.Stack;

public class Bracket {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private void solution() throws IOException {
        StringBuffer sb = new StringBuffer();
        final int TC = Integer.valueOf(br.readLine());

        for (int i = 0; i < TC; i++) {
            String input = br.readLine();
            if (isValid(input)) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        bw.write(sb.toString());
    }

    private boolean isValid(String input) {
        Stack<Boolean> stack = new Stack<>();
        for (char ch : input.toCharArray()) {
            if (ch == '(')
                stack.push(true);
            else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }

        if (stack.isEmpty())
            return true;
        return false;
    }

    public static void main(String[] args) throws IOException {
        Bracket sol = new Bracket();
        sol.solution();

        bw.flush();
        bw.close();
        br.close();
    }
}
