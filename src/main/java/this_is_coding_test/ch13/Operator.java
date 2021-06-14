package this_is_coding_test.ch13;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Operator {
    final int PLUS = 0;
    final int MINUS = 1;
    final int MULTI = 2;
    final int DIV = 3;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./src/this_is_coding_test/ch13/input.txt"));
        StringTokenizer st;

        int n;
        int[] nums;
        int[] operSize;

        n = Integer.parseInt(br.readLine());
        nums = new int[n];
        operSize = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operSize[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[2];
        result[0] = Integer.MAX_VALUE;
        result[1] = Integer.MIN_VALUE;
        getResult(operSize, 1, nums[0], nums, result);

        System.out.println(result[1]);
        System.out.println(result[0]);
    }

    public int getResult(int[] operSize, int idx, int curVal, int[] nums, int[] result) {
        int res = Integer.MIN_VALUE;
        if (idx == nums.length) {
            return curVal;
        }
        for (int i = 0; i < operSize.length; i++) {
            if (operSize[i] != 0) {
                operSize[i] -= 1;
                res = getResult(operSize, idx + 1, calculator(curVal, nums[idx], i), nums, result);
                if (res != Integer.MIN_VALUE) {
                    if (result[0] > res) {
                        result[0] = res;
                    }
                    if (result[1] < res) {
                        result[1] = res;
                    }
                }
                operSize[i] += 1;
            }
        }
        return res;
    }

    public int calculator(int a, int b, int oper) {
        switch (oper) {
            case PLUS :
                return a + b;
            case MINUS:
                return a - b;
            case MULTI:
                return a * b;
            case DIV:
                return a / b;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        Operator o = new Operator();
        o.solution();
    }
}
