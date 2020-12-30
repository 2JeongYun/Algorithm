package this_is_coding_test.ch10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Curriculum {
    int lectureSize;
    int[] input;
    int[] totalTime;
    int[] runningTime;
    ArrayList<Integer>[] lectures;
    Queue<Integer> que;

    public void doit() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(".\\src\\this_is_coding_test\\ch10\\input.txt"));
        StringTokenizer st;
        String line;
        que = new LinkedList<>();

        lectureSize = Integer.parseInt(br.readLine());

        lectures = new ArrayList[lectureSize + 1];
        input = new int[lectureSize + 1];
        totalTime = new int[lectureSize + 1];
        runningTime = new int[lectureSize + 1];

        for (int i = 1; i < lectureSize + 1; i++) {
            lectures[i] = new ArrayList<>();
        }

        for (int i = 1; i < lectureSize + 1; i++) {
            line = br.readLine();
            st = new StringTokenizer(line);
            int token;
            while ((token = Integer.parseInt(st.nextToken() )) != -1) {
                if (runningTime[i] == 0) {
                    runningTime[i] = token;
                } else {
                    lectures[token].add(i);
                    input[i] += 1;
                }
            }
        }

        for (int i = 1; i < lectureSize + 1; i++) {
            if (input[i] == 0) {
                totalTime[i] = runningTime[i];
                que.add(i);
            }
        }

        setTime(lectures);
        for (int i = 1; i < lectureSize + 1; i++) {
            System.out.println(totalTime[i]);
        }
    }

    private void setTime(ArrayList<Integer>[] lectures) {
        if (que.isEmpty()) {
            return;
        }
        int curLecture = que.poll();

        for (int next : lectures[curLecture]) {
            input[next] -= 1;
            if (input[next] == 0) {
                que.add(next);
                totalTime[next] = Integer.max(totalTime[curLecture] + runningTime[next], totalTime[next]);
            }
        }
        setTime(lectures);
    }

    public static void main(String[] args) throws IOException {
        Curriculum cur = new Curriculum();
        cur.doit();
    }


}
