package hackerRank.interviewPreparationKit.graphs;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ConnectedCell {
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};

    // Complete the maxRegion function below.
    static int maxRegion(int[][] grid) {
        int max = Integer.MIN_VALUE;

        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                if (grid[y][x] == 1) {
                    max = Integer.max(max, getRegionCount(grid, y, x));
                }
            }
        }
        return max;
    }

    static int getRegionCount(int[][] grid, int y, int x) {
        Queue<Integer> xQue = new LinkedList<>();
        Queue<Integer> yQue = new LinkedList<>();
        xQue.add(x);
        yQue.add(y);
        grid[y][x] = 0;

        int ret = 0;
        while (xQue.isEmpty() == false) {
            int curX = xQue.poll();
            int curY = yQue.poll();
            ret++;

            for (int d = 0; d < dx.length; d++) {
                int nextX = curX + dx[d];
                int nextY = curY + dy[d];
                if (grid[nextY][nextX] == 1) {
                    xQue.add(nextX);
                    yQue.add(nextY);
                    grid[nextY][nextX] = 0;
                }
            }
        }

        return ret;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] grid = new int[n + 2][m + 2];

        for (int i = 0; i < n; i++) {
            String[] gridRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < m; j++) {
                int gridItem = Integer.parseInt(gridRowItems[j]);
                grid[i + 1][j + 1] = gridItem;
            }
        }

        int res = maxRegion(grid);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
