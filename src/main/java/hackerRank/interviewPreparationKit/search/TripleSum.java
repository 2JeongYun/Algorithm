package hackerRank.interviewPreparationKit.search;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class TripleSum {

    // Complete the triplets function below.
    static long triplets(int[] a, int[] b, int[] c) {
        ArrayList<Integer> aArr = makeArrList(a);
        ArrayList<Integer> bArr = makeArrList(b);
        ArrayList<Integer> cArr = makeArrList(c);

        long ret = 0;
        for (Integer numOfB : bArr) {
            long aLowerCnt = getLowerCount(aArr, 0, aArr.size() - 1, numOfB);
            long cLowerCnt = getLowerCount(cArr, 0, cArr.size() - 1, numOfB);
            ret += aLowerCnt * cLowerCnt;
        }

        return ret;
    }

    static ArrayList<Integer> makeArrList(int[] arr) {
        HashSet<Integer> numSet = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            numSet.add(arr[i]);
        }
        ArrayList<Integer> arrList = new ArrayList<>(numSet);
        Collections.sort(arrList);

        return arrList;
    }

    static long getLowerCount(ArrayList<Integer> arr, int lIdx, int rIdx, int value) {
        if (lIdx == rIdx) {
            if (arr.get(rIdx) <= value) {
                return rIdx + 1;
            } else {
                return rIdx;
            }
        }

        long ret = -1;
        int mid = (lIdx + rIdx) / 2;

        if (arr.get(mid) < value) {
            ret = getLowerCount(arr, mid + 1, rIdx, value);
        } else if (arr.get(mid) == value) {
            ret = mid + 1;
        } else {
            ret = getLowerCount(arr, lIdx, mid, value);
        }

        return ret;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] lenaLenbLenc = scanner.nextLine().split(" ");

        int lena = Integer.parseInt(lenaLenbLenc[0]);

        int lenb = Integer.parseInt(lenaLenbLenc[1]);

        int lenc = Integer.parseInt(lenaLenbLenc[2]);

        int[] arra = new int[lena];

        String[] arraItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lena; i++) {
            int arraItem = Integer.parseInt(arraItems[i]);
            arra[i] = arraItem;
        }

        int[] arrb = new int[lenb];

        String[] arrbItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenb; i++) {
            int arrbItem = Integer.parseInt(arrbItems[i]);
            arrb[i] = arrbItem;
        }

        int[] arrc = new int[lenc];

        String[] arrcItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenc; i++) {
            int arrcItem = Integer.parseInt(arrcItems[i]);
            arrc[i] = arrcItem;
        }

        long ans = triplets(arra, arrb, arrc);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
