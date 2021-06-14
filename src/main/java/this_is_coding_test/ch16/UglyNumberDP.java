package this_is_coding_test.ch16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UglyNumberDP {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int target = Integer.parseInt(br.readLine());

        int next2 = 2, next3 = 3, next5 = 5;
        int i2 = 0, i3 = 0, i5 = 0;
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {
            int next = Integer.min(next2, next3);
            next = Integer.min(next, next5);
            dp[i] = next;

            if (dp[i] == next2) {
                next2 = dp[++i2] * 2;
            }
            if (dp[i] == next3) {
                next3 = dp[++i3] * 3;
            }
            if (dp[i] == next5) {
                next5 = dp[++i5] * 5;
            }
        }
        System.out.println(dp[target - 1]);
    }

    public static void main(String[] args) throws IOException {
        UglyNumberDP u = new UglyNumberDP();
        u.solution();
    }
}
