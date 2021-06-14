package programmers.dynamic;

import myutil.Util;

import static myutil.Util.getTwoDimensionalIntArray;
import static myutil.Util.print;

public class TriangleDP {

    public int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length][];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = new int[triangle[i].length];
        }

        dp[0][0] = triangle[0][0];
        for (int i = 0; i < triangle.length - 1; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                dp[i + 1][j] = Integer.max(dp[i][j] + triangle[i + 1][j], dp[i + 1][j]);
                dp[i + 1][j + 1] = Integer.max(dp[i][j] + triangle[i + 1][j + 1], dp[i + 1][j + 1]);
            }
        }

        int ret = 0;
        for (int i = 0; i < dp[dp.length - 1].length; i++) {
            if (ret < dp[dp.length - 1][i]) {
                ret = dp[dp.length - 1][i];
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        TriangleDP p = new TriangleDP();

        int t = 1;
        //t = getTestCaseCount();

        for (int i = 0; i < t; i++) {
            /*
             * Type var = getTypeArr[]
             * Type ...
             * ...
             * print(p.solution());
             */
            print(p.solution(getTwoDimensionalIntArray()));
        }

        Util.closeUtil();
    }
}
