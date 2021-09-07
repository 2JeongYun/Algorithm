package baekjoon.stack;

import java.io.*;
import java.util.Stack;

public class Balance {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private void solution() throws IOException {
        StringBuffer sb = new StringBuffer();
        String input;

        while (!(input = br.readLine()).equals(".")) {
            if (isValid(input))
                sb.append("yes\n");
            else
                sb.append("no\n");
        }
        bw.write(sb.toString());
    }

    private boolean isValid(String input) {
        Stack<Character> stack = new Stack<>();
        for (char ch : input.toCharArray()) {
            if (ch == '(' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']') {
                if (stack.isEmpty())
                    return false;

                char popCh = stack.pop();
                if (ch == ')' && popCh == '[') {
                    return false;
                }

                if (ch == ']' && popCh == '(') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) throws IOException {
        Balance sol = new Balance();
        sol.solution();

        bw.flush();
        bw.close();
        br.close();
    }
}
