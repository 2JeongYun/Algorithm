package hackerRank.interviewPreparationKit.arrays;

import java.util.Scanner;

public class NewYearChaos {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        int answer = 0;

        for (int idx = 0; idx < q.length; idx++) {
            if (idx <= q[idx] - 4) {
                System.out.println("Too chaotic");
                return;
            } else {
                int sortIdx = idx;
                while (sortIdx + 1 < q.length && sortIdx >= 0 && q[sortIdx] > q[sortIdx + 1]) {
                    int temp = q[sortIdx];
                    q[sortIdx] = q[sortIdx + 1];
                    q[sortIdx + 1] = temp;
                    sortIdx--;
                    answer++;
                }
            }
        }
        System.out.println(answer);
        return;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}

