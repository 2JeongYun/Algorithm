package hackerRank.interviewPreparationKit.stringManipulation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class CommonChild {
    static int[][] cache;

    // Complete the commonChild function below.
    static int commonChild(String s1, String s2) {
        cache = new int[s1.length()][s2.length()];
        for (int i = 0; i < cache.length; i++) {
            Arrays.fill(cache[i], -1);
        }

        return getChildCount(s1, s2, 0, 0);
    }

    static int getChildCount(String a, String b, int aIdx, int bIdx) {
        if (aIdx >= a.length() || bIdx >= b.length()) {
            return 0;
        }
        if (cache[aIdx][bIdx] != -1) {
            return cache[aIdx][bIdx];
        }

        int ret = 0;
        int cur = a.charAt(aIdx);
        int passRes = getChildCount(a, b, aIdx + 1, bIdx);
        int inRes = -1;
        int nextBIdx = -1;

        for (int i = bIdx; i < b.length(); i++) {
            if (b.charAt(i) == cur) {
                nextBIdx = i + 1;
                break;
            }
        }

        if (nextBIdx != -1) {
            inRes = getChildCount(a, b, aIdx + 1, nextBIdx) + 1;
        }
        ret = Integer.max(passRes, inRes);
        cache[aIdx][bIdx] = ret;

        return ret;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = commonChild(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

