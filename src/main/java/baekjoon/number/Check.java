package baekjoon.number;

import java.io.*;
import java.util.Arrays;

public class Check {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private void solution() throws IOException {
        StringBuilder sb = new StringBuilder();
        final int N = Integer.valueOf(br.readLine());
        int[] nums = new int[N];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.valueOf(br.readLine());
        }

        Arrays.sort(nums);
        int gcd = nums[1] - nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            int diff = nums[i + 1] - nums[i];
            gcd = gcd(Integer.max(gcd, diff), Integer.min(gcd, diff));
        }

        for (int i = 2; i <= gcd; i++) {
            if (gcd % i == 0) {
                sb.append(i).append(" ");
            }
        }

        bw.write(sb.toString());
    }

    private int gcd(int a, int b) {
        int r = a % b;
        if (r == 0)
            return b;
        else
            return gcd(b, r);
    }

    public static void main(String[] args) throws IOException {
        Check sol = new Check();
        sol.solution();

        bw.flush();
        bw.close();
        br.close();
    }
}
