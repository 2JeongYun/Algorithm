package hackerRank.interviewPreparationKit.dynamicProgramming;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Abbreviation {

    // Complete the abbreviation function below.
    // A = 65, a = 97, z = 122
    static String abbreviation(String a, String b) {
        int[][] cache = new int[a.length()][b.length()];
        return (isMatch(a, b, 0, 0, cache) == true) ? "YES" : "NO";
    }

    static boolean isMatch(String a, String b, int aIdx, int bIdx, int[][] cache) {
        if (aIdx == a.length() && bIdx == b.length()) {
            return true;
        } else if (aIdx == a.length()) {
            return false;
        } else if (bIdx == b.length()) {
            return hasUpperCase(a, aIdx);
        }

        if (cache[aIdx][bIdx] != 0) {
            return (cache[aIdx][bIdx] == 1) ? true : false;
        }

        int chA = a.charAt(aIdx);
        int chB = b.charAt(bIdx);

        boolean ret = false;
        if (chA >= 97) {
            if (isEqual(chA, chB)) {
                ret = isMatch(a, b, aIdx + 1, bIdx + 1, cache);
            }
            ret = ret || isMatch(a, b, aIdx + 1, bIdx, cache);
        } else if (chA == chB) {
            ret = isMatch(a, b, aIdx + 1, bIdx + 1, cache);
        } else {
            ret = false;
        }

        cache[aIdx][bIdx] = (ret == true) ? 1 : -1;
        return ret;
    }

    static boolean hasUpperCase(String str, int idx) {
        while (idx < str.length()) {
            if (str.charAt(idx++) < 97) {
                return false;
            }
        }
        return true;
    }

    static boolean isEqual(int a, int b) {
        a = (a >= 97) ? a - 32 : a;
        return a == b;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String a = scanner.nextLine();

            String b = scanner.nextLine();

            String result = abbreviation(a, b);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
