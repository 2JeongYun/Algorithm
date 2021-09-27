package baekjoon.queue;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class PrinterQueue {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private void solution() throws IOException {
        int TC = Integer.valueOf(br.readLine());
        for (int i = 0; i < TC; i++) {
            solve();
        }
    }

    private void solve() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int taskSize = Integer.valueOf(st.nextToken());
        int targetIdx = Integer.valueOf(st.nextToken());
        Queue<Task> queue = new LinkedList<>();
        int[] prioritySize = new int[10];
        int maxPriority = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < taskSize; i++) {
            Task task;
            int priority = Integer.valueOf(st.nextToken());
            if (i == targetIdx) {
                task = new Task(priority, true);
            } else {
                task = new Task(priority, false);
            }

            prioritySize[priority]++;
            if (priority > maxPriority)
                maxPriority = priority;

            queue.add(task);
        }

        int cnt = 0;
        while(!queue.isEmpty()) {
            Task poll = queue.poll();
            if (poll.priority == maxPriority) {
                cnt++;
                if (poll.isTarget) {
                    System.out.println(cnt);
                    break;
                }

                maxPriority = refreshMaxPriority(prioritySize, maxPriority);
            } else {
                queue.add(poll);
            }
        }
    }

    private int refreshMaxPriority(int[] prioritySize, int maxPriority) {
        prioritySize[maxPriority]--;
        if (prioritySize[maxPriority] == 0) {
            while (maxPriority >= 0 && prioritySize[--maxPriority] == 0);
        }
        return maxPriority;
    }

    static class Task {
        int priority;
        boolean isTarget;

        public Task(int priority, boolean isTarget) {
            this.priority = priority;
            this.isTarget = isTarget;
        }
    }

    public static void main(String[] args) throws IOException {
        PrinterQueue sol = new PrinterQueue();
        sol.solution();

        bw.flush();
        bw.close();
        br.close();
    }
}
