package hackerRank.interviewPreparationKit.stringManipulation;

import java.io.*;
import java.util.*;

public class SpecialStringAgain {

    // Complete the substrCount function below.
    static long substrCount(int n, String s) {
        long ret = 0;
        ret += getAllSameCount(s);
        ret += getSymmetricCount(s);

        return ret;
    }

    static long getAllSameCount(String s) {
        int prev = (int) s.charAt(0);
        long sameCnt = 1;
        long ret = 1;

        for (int i = 1; i < s.length(); i++) {
            int cur = (int) s.charAt(i);
            if (prev == cur) {
                sameCnt++;
            } else {
                sameCnt = 1;
                prev = cur;
            }

            ret += sameCnt;
        }
        return ret;
    }

    static long getSymmetricCount(String s) {
        long ret = 0;
        for (int i = 0; i < s.length(); i++) {
            int prev = -1;
            int d = 1;

            while (i + d < s.length() && i - d >= 0) {
                if (s.charAt(i + d) == s.charAt(i - d)) {
                    if (s.charAt(i + d) == s.charAt(i)) {
                        break;
                    }

                    if (prev == -1) {
                        prev = s.charAt(i + d);
                        ret++;
                    } else if (prev == s.charAt(i + d)) {
                        ret++;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
                d++;
            }
        }
        return ret;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        long result = substrCount(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
