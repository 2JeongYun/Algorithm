package hackerRank.interviewPreparationKit.stringManipulation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AlternatingCharacters {

    // Complete the alternatingCharacters function below.
    static int alternatingCharacters(String s) {
        int ret = 0;
        boolean isPrevA = false;
        if (s.charAt(0) == 'A') {
            isPrevA = true;
        }

        for (int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'A') {
                if (isPrevA) {
                    ret++;
                } else {
                    isPrevA = true;
                }
            } else {
                if (isPrevA == false) {
                    ret++;
                } else {
                    isPrevA = false;
                }
            }
        }
        return ret;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = alternatingCharacters(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

