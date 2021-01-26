package hackerRank.interviewPreparationKit.arrays;

import java.io.*;
import java.util.*;

public class MinimumSwaps {

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        boolean[] visit = new boolean[arr.length];
        int answer = 0;

        for (int i = 0; i < arr.length; i++) {
            if (visit[i] == false && arr[i] != i - 1) {
                visit[i] = true;
                int start = arr[i];
                int curVal = start;
                int cnt = 0;

                do {
                    curVal = arr[curVal - 1];
                    visit[curVal - 1] = true;
                    cnt++;
                } while (curVal != start);

                answer += (cnt - 1);
            }
        }

        return answer;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

