package programmers.stackque;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import static myutil.Util.*;

public class Printer {

    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pQue = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Request> que = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            pQue.add(priorities[i]);
            que.add(new Request(i, priorities[i]));
        }

        int complete = 0;
        while (que.isEmpty() == false) {
            Request poll = que.poll();
            if (poll.priority == pQue.peek()) {
                complete++;
                if (poll.index == location) {
                    break;
                }
                pQue.poll();
            } else {
                que.add(poll);
            }
        }
        return complete;
    }

    class Request implements Comparable<Request> {
        int index;
        int priority;

        Request(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }

        @Override
        public int compareTo(Request o) {
            return o.priority - priority;
        }
    }


    public static void main(String[] args) throws IOException {
        Printer p = new Printer();

        int t = 1;
        t = getTestCaseCount();

        for (int i = 0; i < t; i++) {
            /*
             * Type var = getTypeArr[]
             * Type ...
             * ...
             * print(p.solution());
             */
            print(p.solution(getIntArray(), getInt()));
        }
    }
}
