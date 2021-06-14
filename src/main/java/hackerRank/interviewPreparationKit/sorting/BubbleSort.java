package hackerRank.interviewPreparationKit.sorting;

import java.util.Scanner;

public class BubbleSort {

    // Complete the countSwaps function below.
    static void countSwaps(int[] a) {
        int swapCnt = 0;
        int n = a.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    swapCnt++;
                }
            }
        }

        System.out.printf("Array is sorted in %d swaps.\n", swapCnt);
        System.out.printf("First Element: %d\n", a[0]);
        System.out.printf("Last Element: %d", a[a.length - 1]);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        countSwaps(a);

        scanner.close();
    }
}

