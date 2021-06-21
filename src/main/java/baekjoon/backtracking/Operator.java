package baekjoon.backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class Operator {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    int n, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

    static final int PLUS = 0, MINUS = 1, MUL = 2, DIV = 3;

    private void solution() throws IOException {
        n = Integer.valueOf(br.readLine());
        int[] nums = new int[n];
        int[] operators = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.valueOf(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.valueOf(st.nextToken());
        }

        dfs(nums, operators, nums[0], 1);
        sb.append(max).append("\n").append(min);
        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    private void dfs(int[] nums, int[] operators, int prev, int depth) {
        if (depth == nums.length) {
            min = prev < min ? prev : min;
            max = prev > max ? prev : max;
            return;
        }

        for (int operator = 0; operator < operators.length; operator++) {
            if (operators[operator] == 0)
                continue;
            int curNum = nums[depth];
            operators[operator]--;
            dfs(nums, operators, compute(prev, curNum, operator), depth + 1);
            operators[operator]++;
        }
    }

    private int compute(int a, int b, int operator) {
        switch (operator) {
            case PLUS:
                return a + b;
            case MINUS:
                return a - b;
            case MUL:
                return a * b;
            case DIV:
                return a / b;
        }
        throw new IllegalArgumentException();
    }

    public static void main(String[] args) throws IOException {
        Operator sol = new Operator();
        sol.solution();
    }
}
