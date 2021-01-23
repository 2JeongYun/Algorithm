package hackerRank.interviewPreparationKit.warmUp;

import java.io.*;
import java.util.*;

public class JumpingClouds {

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
        int jumpCnt = 0;
        int idx = 0;
        while (idx < c.length) {
            if (idx + 2 < c.length && c[idx + 2] == 0) {
                idx += 2;
            } else {
                idx++;
            }
            jumpCnt++;
        }
        return jumpCnt - 1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new FileReader("./src/HackerRank/input.txt"));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] c = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c.length; i++) {
            c[i] = Integer.parseInt(st.nextToken());
        }

        int result = jumpingOnClouds(c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

