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

    public static int gcd(int a, int b) {
        if (a == b) {
            return a;
        } else if (a == 0 && b == 0) {
            return 1;
        } else if (a == 0 || b == 0) {
            return (a > b) ? a : b;
        }

        int big, small;
        if (a > b) {
            big = a;
            small = b;
        } else {
            big = b;
            small = a;
        }

        int r;
        while ((r = big % small) != 0) {
            big = small;
            small = r;
        }
        return small;
    }

    public static int lcm(int a, int b) {
        int gcd = gcd(a, b);
        return (a * b) / gcd;
    }

    public static ArrayList<Integer> primes(int max) {
        boolean[] number = new boolean[max + 1];
        ArrayList<Integer> ret = new ArrayList<>();

        for (int i = 2; i <= (int) Math.sqrt(max); i++) {
            if (number[i] == false) {
                number[i] = true;
                ret.add(i);

                for (int j = i; j <= max; j += i) {
                    number[j] = true;
                }
            }
        }
        for (int i = (int) Math.sqrt(max) + 1; i <= max; i++) {
            if (number[i] == false) {
                ret.add(i);
            }
        }

        return ret;
    }

    public static boolean isPrime(int num) {
        for (int i = 2; i < Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }



    public static void main(String[] args) {
        System.out.println(gcd(3, 6));
        System.out.println(lcm(10, 5));
        System.out.println(primes(111));
        System.out.println(isPrime(111));
    }
}
