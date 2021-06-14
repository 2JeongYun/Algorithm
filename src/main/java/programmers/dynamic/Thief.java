package programmers.dynamic;

import myutil.Util;

import static myutil.Util.getIntArray;
import static myutil.Util.print;

public class Thief {

    public int solution(int[] money) {
        int temp = money[0];
        money[0] = 0;
        int cand1 = computeMax(money);
        money[0] = temp;
        money[money.length - 1] = 0;
        int cand2 = computeMax(money);

        return Integer.max(cand1, cand2);
    }

    public int computeMax(int[] money) {
        int[] dp = new int[money.length];
        dp[0] = money[0];
        dp[1] = money[1];
        dp[2] = dp[0] + money[2];

        for (int i = 3; i < money.length; i++) {
            dp[i] = Integer.max(dp[i - 2], dp[i - 3]) + money[i];
        }

        return Integer.max(dp[dp.length - 1], dp[dp.length - 2]);
    }

    public static void main(String[] args) {
        Thief p = new Thief();

        int t = 1;
        //t = getTestCaseCount();

        for (int i = 0; i < t; i++) {
            /*
             * Type var = getTypeArr[]
             * Type ...
             * ...
             * print(p.solution());
             */
            print(p.solution(getIntArray()));
        }

        Util.closeUtil();
    }
}
