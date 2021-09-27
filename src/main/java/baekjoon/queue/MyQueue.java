package baekjoon.queue;

import java.io.*;
import java.util.StringTokenizer;

public class MyQueue {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private void solution() throws IOException {
        final int N = Integer.valueOf(br.readLine());
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        CustomQueue queue = new CustomQueue();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("push")) {
                queue.push(Integer.valueOf(st.nextToken()));
            } else if (command.equals("pop")) {
                sb.append(queue.pop() + "\n");
            } else if (command.equals("size")) {
                sb.append(queue.size() + "\n");
            } else if (command.equals("empty")) {
                sb.append(queue.empty() + "\n");
            } else if (command.equals("front")) {
                sb.append(queue.front() + "\n");
            } else if (command.equals("back")) {
                sb.append(queue.back() + "\n");
            }
        }

        bw.write(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        MyQueue sol = new MyQueue();
        sol.solution();

        bw.flush();
        bw.close();
        br.close();
    }

    static class CustomQueue {

        Node head, tail;
        int size;

        CustomQueue() {
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        public void push(int data) {
            Node node = new Node();
            node.data = data;
            node.next = tail;
            node.prev = tail.prev;
            tail.prev.next = node;
            tail.prev = node;
            size++;
        }

        public int pop() {
            Node node = head.next;
            if (node == tail)
                return -1;
            head.next = node.next;
            node.next.prev = head;
            size--;
            return node.data;
        }

        public int size() {
            return size;
        }

        public int empty() {
            return size == 0 ? 1 : 0;
        }

        public int front() {
            Node node = head.next;
            if (node == tail)
                return -1;
            return node.data;
        }

        public int back() {
            Node node = tail.prev;
            if (node == head)
                return -1;
            return node.data;
        }
    }

    static class Node {

        Node next, prev;
        Integer data;
    }
}
