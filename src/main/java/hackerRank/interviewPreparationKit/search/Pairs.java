package hackerRank.interviewPreparationKit.search;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class Pairs {

    // Complete the pairs function below.
    static int pairs(int k, int[] arr) {
        HashSet<Integer> numSet = new HashSet<>();
        HashSet<Integer> answerSet = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            numSet.add(arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            int a = arr[i];
            int b = a - k;
            if (numSet.contains(b)) {
                answerSet.add(a);
            }
        }

        return answerSet.size();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = pairs(k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}