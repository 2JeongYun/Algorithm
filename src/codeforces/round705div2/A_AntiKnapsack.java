package codeforces.round705div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class A_AntiKnapsack {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        for (int test = 0; test < TC; test++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            ArrayList<Integer> arr = new ArrayList<>();

            for (int num = k + 1; num <= n; num++) {
                arr.add(num);
            }
            int mid = (int) Math.ceil((double) k / 2);
            if (mid > 0) {
                for (int num = mid; num < k; num++) {
                    arr.add(num);
                }
            }

            StringBuffer sb = new StringBuffer();
            for (int num : arr) {
                sb.append(num).append(" ");
            }

            System.out.println(arr.size());
            System.out.println(sb);
        }
    }

    public static void main(String[] args) throws IOException {
        A_AntiKnapsack a = new A_AntiKnapsack();
        a.solution();
    }
}
