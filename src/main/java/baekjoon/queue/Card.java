package baekjoon.queue;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Card {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private void solution() throws IOException {
        Queue<Integer> queue = new LinkedList<>();
        final int N = Integer.valueOf(br.readLine());

        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        boolean isTrash = true;
        while (queue.size() > 1) {
            if (isTrash) {
                queue.poll();
            } else {
                queue.add(queue.poll());
            }
            isTrash = !isTrash;
        }

        System.out.println(queue.poll());
    }

    public static void main(String[] args) throws IOException {
        Card sol = new Card();
        sol.solution();

        bw.flush();
        bw.close();
        br.close();
    }
}
