package programmers.kakaoprev.q2021;

import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Advertisement {

    public String solution(String play_time, String adv_time, String[] logs) {
        int playTime = toSecond(play_time);
        ArrayList<Log> sortedByStart = new ArrayList<>();
        for (String log : logs) {
            Log logObj = convertLogToSec(log);
            sortedByStart.add(logObj);
        }

        Collections.sort(sortedByStart, (o1, o2) -> o1.start - o2.start);

        long maxRunTime = 0;
        int answerTime = 0;
        int adTime = toSecond(adv_time);

        for (int i = 1; i < sortedByStart.size(); i++) {
            Log startLog = sortedByStart.get(i);

            int adEndTime = startLog.start + adTime;
            int lastAdIdx = biSearch(sortedByStart, i, sortedByStart.size() - 1, adEndTime) - 1;
            long runTime = 0;

            boolean isTight = false;
            int surplus = Integer.MAX_VALUE;
            for (int j = i; j <= lastAdIdx; j++) {
                Log log = sortedByStart.get(j);
                if (adEndTime >= log.end) {
                    runTime += log.runTime;
                    surplus = Integer.min(surplus, adEndTime - log.end);
                } else {
                    runTime += log.runTime - (log.end - adEndTime);
                    isTight = true;
                }
            }

            if (runTime > maxRunTime) {
                answerTime = startLog.start;
                maxRunTime = runTime;

                if (!isTight && surplus != Integer.MAX_VALUE) {
                    answerTime -= surplus;
                }
            }

            if (adEndTime >= playTime)
                break;
        }

        System.out.println(toTime((int) maxRunTime));
        return toTime(answerTime);
    }

    public int biSearch(ArrayList<Log> arrList, int s, int e, int target) {
        int ret = arrList.size();
        while (s <= e) {
            int midIdx = (s + e) / 2;
            int midVal = arrList.get(midIdx).start;

            if (midVal >= target) {
                ret = midIdx;
                e = midIdx - 1;
            } else {
                s = midIdx + 1;
            }
        }

        return ret;
    }

    public Log convertLogToSec(String log) {
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
        Advertisement a = new Advertisement();
        System.out.println(a.solution("02:00:00", "00:10:00", new String[] {
                "01:00:00-01:50:00",
                "01:01:00-02:00:00",
                "01:50:00-02:00:00",
                "01:59:00-02:00:00"
        }));
    }
}
