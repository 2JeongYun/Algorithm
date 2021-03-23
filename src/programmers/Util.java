package programmers;

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

    static {
        try {
            br = new BufferedReader(new FileReader("./src/programmers/input.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static int getTestCaseCount() {
        try {
            return Integer.parseInt(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static String cutBracket(String s) {
        if (s.charAt(0) == '[') {
            s = s.substring(1, s.length() - 1);
        }
        return s;
    }

    public static ArrayList<String> makeArrayList() {
        ArrayList<String> ret = new ArrayList<>();

        try {
            String line = cutBracket(br.readLine());

            if (line.contains(",")) {
                st = new StringTokenizer(line, ",");
            } else {
                st = new StringTokenizer(line);
            }

            while (st.hasMoreTokens()) {
                ret.add(st.nextToken());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ret;
    }

    public static int[] getIntArray() {
        ArrayList<String> stringArrayList = makeArrayList();
        int[] ret = new int[stringArrayList.size()];

        for (int i = 0; i < ret.length; i++) {
            ret[i] = Integer.parseInt(stringArrayList.get(i));
        }

        return ret;
    }

    public static long[] getLongArray() {
        ArrayList<String> stringArrayList = makeArrayList();
        long[] ret = new long[stringArrayList.size()];

        for (int i = 0; i < ret.length; i++) {
            ret[i] = Long.parseLong(stringArrayList.get(i));
        }

        return ret;
    }

    public static String[] getStringArray() {
        return (String[]) makeArrayList().toArray();
    }

    public static char[] getCharArray() {
        ArrayList<String> stringArrayList = makeArrayList();
        char[] ret = new char[stringArrayList.size()];

        for (int i = 0; i < ret.length; i++) {
            ret[i] = stringArrayList.get(i).charAt(0);
        }

        return ret;
    }

    public static double[] getDoubleArray() {
        ArrayList<String> stringArrayList = makeArrayList();
        double[] ret = new double[stringArrayList.size()];

        for (int i = 0; i < ret.length; i++) {
            ret[i] = Double.parseDouble(stringArrayList.get(i));
        }

        return ret;
    }

    public static int getInt() throws IOException {
        return Integer.parseInt(br.readLine());
    }

    public static long getLong() throws IOException {
        return Long.parseLong(br.readLine());
    }

    public static String getString() throws IOException {
        return br.readLine();
    }

    public static char getChar() throws IOException {
        return br.readLine().charAt(0);
    }

    public static double getDouble() throws IOException {
        return Double.parseDouble(br.readLine());
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
        print(getLongArray());
    }
}
