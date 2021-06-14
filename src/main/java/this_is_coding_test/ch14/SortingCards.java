package this_is_coding_test.ch14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class SortingCards {
    public static void main(String[] args) throws IOException {
        SortingCards s = new SortingCards();
        s.solution();
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pQue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pQue.add(Integer.parseInt(br.readLine()));
        }
        if (N == 1) {
            System.out.println(0);
            return;
        }

        int ans = 0;
        while (pQue.size() > 1) {
            int a = pQue.poll();
            int b = pQue.poll();
            ans += a + b;
            pQue.add(a + b);
        }
        System.out.println(ans);
    }
}
