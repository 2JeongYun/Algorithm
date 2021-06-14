package programmers.stackque;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import static myutil.Util.*;

public class Development {

    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> que = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            que.add(computeDay(progresses[i], speeds[i]));
        }

        while (que.isEmpty() == false) {
            int poll = que.poll();
            int complete = 1;

            while (que.isEmpty() == false) {
                int peek = que.peek();
                if (peek <= poll) {
                    complete++;
                    que.poll();
                } else {
                    break;
                }
            }
            res.add(complete);
        }

        int[] ans = new int[res.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    public int computeDay(int progress, int speed) {
        int remain = 100 - progress;
        return (remain % speed == 0) ? (remain) / speed : (remain) / speed + 1;
    }

    public static void main(String[] args) {
        Development p = new Development();

        int t = 1;
        t = getTestCaseCount();

        for (int i = 0; i < t; i++) {
            /*
             * Type var = getTypeArr[]
             * Type ...
             * ...
             * sout(p.solution());
             */
            print(p.solution(getIntArray(), getIntArray()));
        }
    }
}