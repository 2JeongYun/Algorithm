package baekjoon.queue;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Spin {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private void solution() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(st.nextToken());
        int M = Integer.valueOf(st.nextToken());
        int ans = 0;

        Deque<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int pick = Integer.valueOf(st.nextToken());

            int left = getLeftCnt(deque, pick);
            int right = getRightCnt(deque, pick);

            if (right <= left) {
                ans += right;
                goRight(deque, pick);
            } else {
                ans += left;
                goLeft(deque, pick);
            }

            deque.pollFirst();
        }

        bw.write(String.valueOf(ans));
    }

    private int getLeftCnt(Deque<Integer> deque, int pick) {
        int left = goLeft(deque, pick);

        for (int i = 0; i < left; i++) {
            int first = deque.pollFirst();
            deque.addLast(first);
        }

        return left;
    }

    private int goLeft(Deque<Integer> deque, int pick) {
        int left = 0;
        while (deque.peek() != pick) {
            int last = deque.pollLast();
            deque.addFirst(last);
            left++;
        }

        return left;
    }

    private int getRightCnt(Deque<Integer> deque, int pick) {
        int right = goRight(deque, pick);

        for (int i = 0; i < right; i++) {
            int last = deque.pollLast();
            deque.addFirst(last);
        }

        return right;
    }

    private int goRight(Deque<Integer> deque, int pick) {
        int right = 0;
        while (deque.peek() != pick) {
            int first = deque.pollFirst();
            deque.addLast(first);
            right++;
        }

        return right;
    }

    public static void main(String[] args) throws IOException {
        Spin sol = new Spin();
        sol.solution();

        bw.flush();
        bw.close();
        br.close();
    }
}
