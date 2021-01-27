package hackerRank.interviewPreparationKit.search;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MinimumTimeRequired {
    static final int BIGGERTOTAL = 1;
    static final int SMALLERTOTAL = -1;

    // Complete the minTime function below.
    static long minTime(long[] machines, long goal) {
        Arrays.sort(machines);

        return findDay(machines, 1, machines[machines.length-1] * goal, goal);
    }

    static boolean isBiggerThanGoal(long[] machines, long day, long goal) {
        long total = 0;
        for (int i = 0; i < machines.length; i++) {
            total += Math.floor(day / machines[i]);
        }
        if (total >= goal) {
            return true;
        }
        return false;
    }

    static long findDay(long[] machines, long minDay, long maxDay, long goal) {
        if (minDay == maxDay) {
            return minDay;
        }
        long midDay = (minDay + maxDay) / 2;
        if (isBiggerThanGoal(machines, midDay, goal)) {
            return findDay(machines, minDay, midDay, goal);
        } else {
            return findDay(machines, midDay + 1, maxDay, goal);
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nGoal = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nGoal[0]);

        long goal = Long.parseLong(nGoal[1]);

        long[] machines = new long[n];

        String[] machinesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long machinesItem = Long.parseLong(machinesItems[i]);
            machines[i] = machinesItem;
        }

        long ans = minTime(machines, goal);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

