package baekjoon.stack;

import java.io.*;
import java.util.StringTokenizer;

public class MyStack {

    static Integer[] stack = new Integer[10000];
    static int size = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        int N = Integer.valueOf(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("push")) {
                push(Integer.valueOf(st.nextToken()));
            } else if (command.equals("pop")) {
                sb.append(pop()).append("\n");
            } else if (command.equals("size")) {
                sb.append(size()).append("\n");
            } else if (command.equals("empty")) {
                sb.append(empty()).append("\n");
            } else if (command.equals("top")) {
                sb.append(top()).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    public static void push(int i) {
        stack[size++] = i;
    }

    public static int pop() {
        if (size == 0)
            return -1;
        int ret = stack[size - 1];
        stack[size - 1] = null;
        size--;
        return ret;
    }

    public static int empty() {
        if (size == 0)
            return 1;
        return 0;
    }

    public static int size() {
        return size;
    }

    public static int top() {
        if (size == 0)
            return -1;
        return stack[size - 1];
    }
}
