package baekjoon.queue;

import java.io.*;
import java.util.StringTokenizer;

public class MyDeque {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private void solution() throws IOException {
        int N = Integer.valueOf(br.readLine());
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        CustomDeque deque = new CustomDeque();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("push_back")) {
                deque.pushBack(Integer.valueOf(st.nextToken()));
            } else if (command.equals("push_front")) {
                deque.pushFront(Integer.valueOf(st.nextToken()));
            } else if (command.equals("pop_front")) {
                sb.append(deque.popFront()).append("\n");
            } else if (command.equals("pop_back")) {
                sb.append(deque.popBack()).append("\n");
            } else if (command.equals("size")) {
                sb.append(deque.getSize()).append("\n");
            } else if (command.equals("empty")) {
                sb.append(deque.isEmpty()).append("\n");
            } else if (command.equals("front")) {
                sb.append(deque.getFront()).append("\n");
            } else if (command.equals("back")) {
                sb.append(deque.getBack()).append("\n");
            }
        }

        bw.write(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        MyDeque sol = new MyDeque();
        sol.solution();

        bw.flush();
        bw.close();
        br.close();
    }

    static class CustomDeque {

        Node head, tail;
        int size;

        CustomDeque() {
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        public void pushFront(int data) {
            Node node = new Node(data);
            node.next = head.next;
            node.prev = head;
            head.next = node;
            node.next.prev = node;
            size++;
        }

        public void pushBack(int data) {
            Node node = new Node(data);
            node.next = tail;
            node.prev = tail.prev;
            tail.prev = node;
            node.prev.next = node;
            size++;
        }

        public int popFront() {
            Node node = head.next;
            if (node == tail) {
                return -1;
            } else {
                head.next = node.next;
                node.next.prev = head;
                size--;
                return node.data;
            }
        }

        public int popBack() {
            Node node = tail.prev;
            if (node == head) {
                return -1;
            } else {
                tail.prev = node.prev;
                node.prev.next = tail;
                size--;
                return node.data;
            }
        }

        public int getSize() {
            return size;
        }

        public int isEmpty() {
            return size == 0 ? 1 : 0;
        }

        public int getFront() {
            if (size == 0) {
                return -1;
            } else {
                return head.next.data;
            }
        }

        public int getBack() {
            if (size == 0) {
                return -1;
            } else {
                return tail.prev.data;
            }
        }
    }

    static class Node {
        Node next, prev;
        int data;

        Node() {}
        Node(int data) {
            this.data = data;
        }
    }
}
