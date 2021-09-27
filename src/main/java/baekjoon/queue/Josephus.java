package baekjoon.queue;

import java.io.*;
import java.util.StringTokenizer;

public class Josephus {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private void solution() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();
        int max = Integer.valueOf(st.nextToken());
        int term = Integer.valueOf(st.nextToken());

        Node firstNode = new Node(1);
        Node prev = firstNode;
        for (int i = 2; i <= max; i++) {
            Node node = new Node(i);
            prev.next = node;
            prev = node;
        }
        prev.next = firstNode;

        Node cur = firstNode;
        sb.append("<");
        while (prev != cur) {
            for (int i = 0; i < term - 1; i++) {
                prev = cur;
                cur = cur.next;
            }
            sb.append(cur.num).append(", ");
            prev.next = cur.next;
            cur = cur.next;
        }
        sb.append(cur.num).append(">");

        bw.write(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        Josephus sol = new Josephus();
        sol.solution();

        bw.flush();
        bw.close();
        br.close();
    }

    static class Node {
        Node next;
        int num;

        Node() {}
        Node(int num) {
            this.num = num;
        }
    }
}
