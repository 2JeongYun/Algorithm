package baekjoon.queue;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class AC {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    final int RIGHT = -1;
    final int LEFT = 1;

    private void solution() throws IOException {

        int T = Integer.valueOf(br.readLine());
        for (int i = 0; i < T; i++) {
            String command = br.readLine();
            int n = Integer.valueOf(br.readLine());
            Deque<Integer> deque = makeDeque(n);

            int picker = LEFT;
            boolean isCorrect = true;
            for (int j = 0; j < command.length(); j++) {
                char c = command.charAt(j);
                if (c == 'R') {
                    picker *= -1;
                } else {
                    if (!delete(deque, picker)) {
                        isCorrect = false;
                        break;
                    }
                }
            }

            StringBuffer result = new StringBuffer();
            if (!isCorrect) {
                result.append("error\n");
            } else {
                result.append("[");
                while (!deque.isEmpty()) {
                    int poll;
                    if (picker == RIGHT) {
                        poll = deque.pollLast();
                    } else {
                        poll = deque.pollFirst();
                    }

                    result.append(poll);
                    result.append(",");
                }
                if (result.charAt(result.length() - 1) == ',') {
                    result.deleteCharAt(result.length() - 1);
                }
                result.append("]");
                result.append("\n");
            }

            bw.write(result.toString());
        }
    }

    private boolean delete(Deque<Integer> deque, int picker) {
        if (deque.isEmpty()) {
            return false;
        }

        if (picker == LEFT) {
            deque.pollFirst();
        } else {
            deque.pollLast();
        }

        return true;
    }

    private Deque<Integer> makeDeque(int n) throws IOException {
        String arrStr = br.readLine();
        arrStr = arrStr.substring(1, arrStr.length() - 1);
        StringTokenizer st = new StringTokenizer(arrStr, ",");

        Deque<Integer> deque = new LinkedList<>();
        for (int j = 0; j < n; j++) {
            deque.addLast(Integer.valueOf(st.nextToken()));
        }

        return deque;
    }

    public static void main(String[] args) throws IOException {
        AC sol = new AC();
        sol.solution();

        bw.flush();
        bw.close();
        br.close();
    }
}
