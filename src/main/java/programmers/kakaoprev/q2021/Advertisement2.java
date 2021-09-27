package programmers.kakaoprev.q2021;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Advertisement2 {

    public String solution(String play_time, String adv_time, String[] logs) {
        int playTime = toSecond(play_time);
        int adTime = toSecond(adv_time);
        int[] timeTable = new int[playTime + 1];

        for (String logString : logs) {
            Log log = makeLogObj(logString);
            timeTable[log.start]++;
            timeTable[log.end]--;
        }

        for (int i = 1; i < timeTable.length; i++) {
            timeTable[i] = timeTable[i] + timeTable[i - 1];
        }

        long runTime = 0;
        for (int i = 0; i < adTime; i++) {
            runTime += timeTable[i];
        }

        System.out.println("timeTable = " + Arrays.toString(timeTable));

        long maxRunTime = runTime;
        int maxStart = 0;
        for (int start = 1; start <= playTime - adTime; start++) {
            int adEndTime = start + adTime;
            runTime -= timeTable[start - 1];
            runTime += timeTable[adEndTime - 1];

            if (runTime > maxRunTime) {
                maxStart = start;
                maxRunTime = runTime;
            }
        }

        return toTime(maxStart);
    }

    public Log makeLogObj(String log) {
        StringTokenizer st = new StringTokenizer(log, "-");
        return new Log(toSecond(st.nextToken()), toSecond(st.nextToken()));
    }

    public String toTime(int sec) {
        if (sec < 0)
            sec = 0;

        int hour = sec / 3600;
        sec %= 3600;
        int min = sec / 60;
        sec %= 60;

        return String.format("%02d:%02d:%02d", hour, min, sec);
    }

    public int toSecond(String time) {
        int sec = 0;
        StringTokenizer st = new StringTokenizer(time, ":");

        sec += Integer.valueOf(st.nextToken()) * 3600;
        sec += Integer.valueOf(st.nextToken()) * 60;
        sec += Integer.valueOf(st.nextToken());

        return sec;
    }

    static class Log {
        int start;
        int end;
        int runTime;

        public Log(int start, int end) {
            this.start = start;
            this.end = end;
            runTime = end - start;
        }

        @Override
        public String toString() {
            return "Log{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    public static void main(String[] args) {
        Advertisement2 a = new Advertisement2();
        System.out.println(a.solution("00:00:30", "00:00:05", new String[] {
                "00:00:05-00:00:10",
                "00:00:01-00:00:05",
                "00:00:00-00:00:05"
        }));
    }
}
