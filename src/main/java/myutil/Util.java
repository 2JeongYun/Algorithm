package myutil;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Util {

    static BufferedReader br;
    static StringTokenizer st;
    static String delim = ",";

    static {
        try {
            br = new BufferedReader(new FileReader("./src/input.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void closeUtil() {
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setDelim(String d) {
        delim = d;
    }

    public static int getTestCaseCount() {
        try {
            return Integer.parseInt(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static ArrayList<String> parser(String line) {
        ArrayList<String> ret = new ArrayList<>();
        int openCnt = 0;

        int prevIdx = 0;
        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);

            if (ch == '[') {
                openCnt++;
            } else if (ch == ']') {
                openCnt--;
            }

            if (openCnt > 0) {
                continue;
            } else if (openCnt == 0) {
                if (ch == ',') {
                    ret.add(line.substring(prevIdx, i));
                    prevIdx = i + 1;
                }
            } else {
                new IllegalArgumentException("Wrong Input : ']' is used too much");
            }
        }
        ret.add(line.substring(prevIdx, line.length()));

        return ret;
    }

    public static ArrayList<String> makeArrayList() {
        ArrayList<String> ret;
        String line = null;
        try {
            line = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        line = deleteSide(line, '[', ']');
        ret = parser(line);

        for (int i = 0; i < ret.size(); i++) {
            if (ret.get(i).contains("[") == false) {
                ret.set(i, deleteSide(ret.get(i), '"', '"'));
            }
        }

        return ret;
    }

    public static ArrayList<String> makeArrayList(String line) {
        ArrayList<String> ret;

        line = deleteSide(line, '[', ']');
        ret = parser(line);

        for (int i = 0; i < ret.size(); i++) {
            if (ret.get(i).contains("[") == false) {
                ret.set(i, deleteSide(ret.get(i), '"', '"'));
            }
        }

        return ret;
    }

    public static String deleteSide(String s, char left, char right) {
        int start = -1, end = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == left) {
                start = i + 1;
                break;
            }
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == right) {
                end = i;
                break;
            }
        }
        if (start == -1 || end == -1) {
            return s;
        }
        return s.substring(start, end);
    }

    public static int[] getIntArray() {
        ArrayList<String> stringArrayList = makeArrayList();
        int[] ret = new int[stringArrayList.size()];

        for (int i = 0; i < ret.length; i++) {
            ret[i] = Integer.parseInt(stringArrayList.get(i).trim());
        }

        return ret;
    }

    public static long[] getLongArray() {
        ArrayList<String> stringArrayList = makeArrayList();
        long[] ret = new long[stringArrayList.size()];

        for (int i = 0; i < ret.length; i++) {
            ret[i] = Long.parseLong(stringArrayList.get(i).trim());
        }

        return ret;
    }

    public static double[] getDoubleArray() {
        ArrayList<String> stringArrayList = makeArrayList();
        double[] ret = new double[stringArrayList.size()];

        for (int i = 0; i < ret.length; i++) {
            ret[i] = Double.parseDouble(stringArrayList.get(i).trim());
        }

        return ret;
    }

    public static String[] getStringArray() {
        return makeArrayList().toArray(new String[]{});
    }

    public static char[] getCharArray() {
        ArrayList<String> stringArrayList = makeArrayList();
        char[] ret = new char[stringArrayList.size()];

        for (int i = 0; i < ret.length; i++) {
            ret[i] = stringArrayList.get(i).charAt(0);
        }

        return ret;
    }

    public static int[][] getTwoDimensionalIntArray() {
        ArrayList<String> stringArrayList = makeArrayList();
        int[][] ret = new int[stringArrayList.size()][];

        for (int i = 0; i < ret.length; i++) {
            ArrayList<String> arrayList = makeArrayList(stringArrayList.get(i));
            int[] arr = new int[arrayList.size()];
            for (int j = 0; j < arrayList.size(); j++) {
                arr[j] = Integer.parseInt(arrayList.get(j).trim());
            }
            ret[i] = arr;
        }

        return ret;
    }

    public static long[][] getTwoDimensionalLongArray() {
        ArrayList<String> stringArrayList = makeArrayList();
        long[][] ret = new long[stringArrayList.size()][];

        for (int i = 0; i < ret.length; i++) {
            ArrayList<String> arrayList = makeArrayList(stringArrayList.get(i));
            long[] arr = new long[arrayList.size()];
            for (int j = 0; j < arrayList.size(); j++) {
                arr[j] = Long.parseLong(arrayList.get(j).trim());
            }
            ret[i] = arr;
        }

        return ret;
    }

    public static double[][] getTwoDimensionalDoubleArray() {
        ArrayList<String> stringArrayList = makeArrayList();
        double[][] ret = new double[stringArrayList.size()][];

        for (int i = 0; i < ret.length; i++) {
            ArrayList<String> arrayList = makeArrayList(stringArrayList.get(i));
            double[] arr = new double[arrayList.size()];
            for (int j = 0; j < arrayList.size(); j++) {
                arr[j] = Double.parseDouble(arrayList.get(j).trim());
            }
            ret[i] = arr;
        }

        return ret;
    }

    public static String[][] getTwoDimensionalStringArray() {
        ArrayList<String> stringArrayList = makeArrayList();
        String[][] ret = new String[stringArrayList.size()][];

        for (int i = 0; i < ret.length; i++) {
            String[] arr = makeArrayList(stringArrayList.get(i)).toArray(new String[]{});
            ret[i] = arr;
        }
        return ret;
    }

    public static char[][] getTwoDimensionalCharArray() {
        ArrayList<String> stringArrayList = makeArrayList();
        char[][] ret = new char[stringArrayList.size()][];

        for (int i = 0; i < ret.length; i++) {
            ArrayList<String> arrayList = makeArrayList(stringArrayList.get(i));
            char[] arr = new char[arrayList.size()];
            for (int j = 0; j < arrayList.size(); j++) {
                System.out.println(arrayList.get(j));
                arr[j] = arrayList.get(j).charAt(0);
            }
            ret[i] = arr;
        }

        return ret;
    }

    public static int getInt() {
        try {
            return Integer.parseInt(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static long getLong() {
        try {
            return Long.parseLong(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static String getString() {
        try {
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static char getChar() {
        try {
            return br.readLine().charAt(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ' ';
    }

    public static double getDouble() {
        try {
            return Double.parseDouble(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static void print(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }

    public static void print(double[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }

    public static void print(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }

    public static void print(char[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }

    public static void print(long[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }

    public static void print(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static void print(double[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static void print(String[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static void print(char[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static void print(long[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static void print(int arg) {
        System.out.println(arg);
    }

    public static void print(long arg) {
        System.out.println(arg);
    }

    public static void print(String arg) {
        System.out.println(arg);
    }

    public static void print(double arg) {
        System.out.println(arg);
    }

    public static void print(char arg) {
        System.out.println(arg);
    }

    //TEST
    public static void main(String[] args) {
//        print(getInt());
//        print(getIntArray());
//        System.out.println("----");
//        print(getTwoDimensionalIntArray());
//        System.out.println("----");
//        print(getString());
//        print(getStringArray());
//        System.out.println("----");
//        print(getTwoDimensionalStringArray());
//        System.out.println("----");
//        print(getChar());
//        print(getCharArray());
//        System.out.println("----");
//        print(getTwoDimensionalCharArray());
//        System.out.println("----");
    }
}
