package myutil;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MyUtil {
    private static final int INT = 0;
    private static final int STRING = 1;

    public static int binarySearch(int value, int[] array, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (value == array[mid]) {
            return mid;
        } else if (array[mid] < value) {
            return binarySearch(value, array, mid + 1, end);
        } else {
            return binarySearch(value, array, start, mid - 1);
        }
    }

    public static int[] lineToIntArray(String line) {
        StringTokenizer st = new StringTokenizer(line);
        int size = st.countTokens();
        int[] ret = new int[size];

        for (int i = 0; i < size; i++) {
            ret[i] = Integer.parseInt(st.nextToken());
        }

        return ret;
    }

    public static int[] lineToIntArray(String line, boolean isDelim) {
        if (isDelim) {
            return lineToIntArray(line);
        }

        int[] ret = new int[line.length()];

        for (int i = 0; i < line.length(); i++) {
            int num = line.charAt(i) - 48;
            ret[i] = num;
        }

        return ret;
    }

    public static int[][] make2by2IntArray(BufferedReader br, int xSize, int ySize) throws IOException {
        int[][] ret = new int[ySize][xSize];
        String line;

        for (int indexY = 0; indexY < ySize; indexY++) {
            line = br.readLine();
            ret[indexY] = lineToIntArray(line);
        }

        return ret;
    }

    public static int[][] make2by2IntArray(BufferedReader br, int xSize, int ySize, boolean isDelim) throws IOException {
        if (isDelim) {
            return make2by2IntArray(br, xSize, ySize);
        }

        int[][] ret = new int[ySize][xSize];
        String line;

        for (int indexY = 0; indexY < ySize; indexY++) {
            line = br.readLine();
            ret[indexY] = lineToIntArray(line, false);
        }

        return ret;
    }

    public static void getPermutations(int n, int r, int depth, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> cur, boolean visit[]) {
        if (depth == r) {
            ArrayList<Integer> arr = (ArrayList<Integer>) cur.clone();
            result.add(arr);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                cur.add(i);
                getPermutations(n, r, depth + 1, result, cur, visit);
                cur.remove((Integer) i);
                visit[i] = false;
            }
        }
    }

    public static void getCombinations(int n, int r, int curNum, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> cur) {
        if (cur.size() == r) {
            ArrayList<Integer> arr = (ArrayList<Integer>) cur.clone();
            result.add(arr);
            return;
        } else if (curNum >= n) {
            return;
        }

        cur.add(curNum);
        getCombinations(n, r, curNum + 1, result, cur);
        cur.remove((Integer) curNum);
        getCombinations(n, r, curNum + 1, result, cur);
        return;
    }

//    public static void main(String[] args) {
//        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
//        getCombination(5, 3, 0, arr, new ArrayList<>());
//        for (ArrayList<Integer> nums : arr) {
//            for (int i : nums) {
//                System.out.printf("%d ", i);
//            }
//            System.out.println();
//        }
//    }
}
