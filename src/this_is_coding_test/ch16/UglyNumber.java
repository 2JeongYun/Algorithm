package this_is_coding_test.ch16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class UglyNumber {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int target = Integer.parseInt(br.readLine());
        int pollCnt = 0;
        int number = 0;
        PriorityQueue<Integer> pQue = new PriorityQueue<>();
        pQue.add(1);

        while (pollCnt < target) {
            number = pQue.poll();
            pollCnt++;

            if (!pQue.contains(number * 2)) {
                pQue.add(number * 2);
            }
            if (!pQue.contains(number * 3)) {
                pQue.add(number * 3);
            }
            if (!pQue.contains(number * 5)) {
                pQue.add(number * 5);
            }
        }

        System.out.println(number);
    }

    public static void main(String[] args) throws IOException {
        UglyNumber u = new UglyNumber();
        u.solution();
    }
}
