package myutil;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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

    public static void getCombinations(int n, int r, int depth, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> cur) {
        if (cur.size() == r) {
            ArrayList<Integer> arr = (ArrayList<Integer>) cur.clone();
            result.add(arr);
            return;
        }

        for (int val = depth; val < n; val++) {
            cur.add(val);
            getCombinations(n, r, val + 1, result, cur);
            cur.remove((Integer) val);
        }
        return;
    }

    public static void mergeSort(int[] arr, int left, int right) {
        int mid = (right + left) / 2;

        if (left >= right) {
            return;
        }

        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);

        return;
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int leftIdx = left;
        int rightIdx = mid + 1;
        int tempIdx = 0;

        while (leftIdx <= mid && rightIdx <= right) {
            if (arr[leftIdx] <= arr[rightIdx]) {
                temp[tempIdx++] = arr[leftIdx++];
            } else {
                temp[tempIdx++] = arr[rightIdx++];
            }
        }

        if (leftIdx == mid + 1) {
            while (rightIdx <= right) {
                temp[tempIdx++] = arr[rightIdx++];
            }
        } else {
            while (leftIdx <= mid) {
                temp[tempIdx++] = arr[leftIdx++];
            }
        }

        for (int i = 0; i < temp.length; i++) {
            arr[left + i] = temp[i];
        }
    }

//    public static void main(String[] args) {
//        int[] arr = {5, 4, 3, 2, 1, -1, 5, 6, 10, 0};
//        mergeSort(arr, 0, arr.length - 1);
//        System.out.println(Arrays.toString(arr));
//    }
}
