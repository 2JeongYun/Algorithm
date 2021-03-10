package codeforces.round705div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_PlanetLapituletti {
    final static HashMap<Character, String> VAILD_NUM = new HashMap<>() {
        {
            put('0', "0");
            put('1', "1");
            put('2', "5");
            put('5', "2");
            put('8', "8");
        }
    };

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        for (int test = 0; test < TC; test++) {
            st = new StringTokenizer(br.readLine());
            int maxHour = Integer.parseInt(st.nextToken());
            int maxMinute = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), ":");
            int hour = Integer.parseInt(st.nextToken());
            int minute = Integer.parseInt(st.nextToken());

            while (!(isValid(makeString(hour), maxMinute) && isValid(makeString(minute), maxHour))) {
                minute++;
                if (minute == maxMinute) {
                    hour++;
                    minute = 0;
                }
                if (hour == maxHour) {
                    hour = 0;
                }
            }

            System.out.println(String.format("%s:%s", makeString(hour), makeString(minute)));
        }
    }

    public String makeString(int num) {
        return (num < 10) ? String.format("0%d", num) : Integer.toString(num);
    }

    public boolean isValid(String time, int maxReverse) {
        if (!isValidNum(time)) {
            return false;
        }
        StringBuffer reverseTime = new StringBuffer(time).reverse();
        for (int i = 0; i < 2; i++) {
            reverseTime.replace(i, i + 1, VAILD_NUM.get(reverseTime.charAt(i)));
        }
        if (Integer.parseInt(reverseTime.toString()) < maxReverse) {
            return true;
        }
        return false;
    }

    public boolean isValidNum(String time) {
        for (int i = 0; i < 2; i++) {
            if (!VAILD_NUM.containsKey(time.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        B_PlanetLapituletti b = new B_PlanetLapituletti();
        b.solution();
    }
}
