package baekjoon.greedy;

import java.io.*;
import java.util.Stack;

public class Bracket {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private void solution() throws IOException {
        Stack<Integer> numStack = new Stack<>();

        int ans = 0;
        boolean reverse = false;
        int c;
        while ((c = br.read()) != '\n') {
           if (c == '+' || c == '-') {
               if (reverse)
                   ans -= makeNumber(numStack);
               else
                   ans += makeNumber(numStack);
           } else {
               numStack.push(c - '0');
           }

           if (c == '-')
               reverse = true;
        }

        if (reverse)
            ans -= makeNumber(numStack);
        else
            ans += makeNumber(numStack);

        bw.write(String.valueOf(ans));
    }

    private int makeNumber(Stack<Integer> stack) {
        int num = 0, depth = 0;
        while (!stack.isEmpty()) {
            num += stack.pop() * Math.pow(10, depth++);
        }

        return num;
    }

    public static void main(String[] args) throws IOException {
        Bracket sol = new Bracket();
        sol.solution();

        bw.flush();
        bw.close();
        br.close();
    }
}
