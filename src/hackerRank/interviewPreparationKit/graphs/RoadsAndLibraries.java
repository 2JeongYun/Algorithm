package hackerRank.interviewPreparationKit.graphs;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class RoadsAndLibraries {

    // Complete the roadsAndLibraries function below.
    static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {
        int[] roots = new int[n + 1];
        for (int i  = 1; i < n + 1; i++) {
            roots[i] = i;
        }

        if (c_lib <= c_road) {
            return (long) n * c_lib;
        }

        setRootTable(roots, cities);
        long ret = 0;

        for (int i = 1; i < roots.length; i++) {
            roots[i] = findRoot(roots, i);
            if (roots[i] == i) {
                ret += c_lib;
            } else {
                ret += c_road;
            }
        }
        return ret;
    }

    static void setRootTable(int[] roots, int[][] cities) {
        for (int i = 0; i < cities.length; i++) {
            int a = cities[i][0];
            int b = cities[i][1];

            if (roots[a] < roots[b]) {
                int topRoot = findRoot(roots, a);
                setRoot(roots, b, topRoot);
            } else {
                int topRoot = findRoot(roots, b);
                setRoot(roots, a, topRoot);
            }

            if (roots[a] < roots[b]) {
                roots[b] = findRoot(roots, a);
            } else {
                roots[a] = findRoot(roots, b);
            }
        }
    }

    static int findRoot(int[] roots, int city) {
        if (roots[city] == city) {
            return city;
        }
        return (roots[city] = findRoot(roots, roots[city]));
    }

    static int setRoot(int[] roots, int city, int replace) {
        if (roots[city] == city) {
            roots[city] = replace;
            return replace;
        }
        return roots[city] = setRoot(roots, roots[city], replace);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nmC_libC_road = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nmC_libC_road[0]);

            int m = Integer.parseInt(nmC_libC_road[1]);

            int c_lib = Integer.parseInt(nmC_libC_road[2]);

            int c_road = Integer.parseInt(nmC_libC_road[3]);

            int[][] cities = new int[m][2];

            for (int i = 0; i < m; i++) {
                String[] citiesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2; j++) {
                    int citiesItem = Integer.parseInt(citiesRowItems[j]);
                    cities[i][j] = citiesItem;
                }
            }

            long result = roadsAndLibraries(n, c_lib, c_road, cities);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
