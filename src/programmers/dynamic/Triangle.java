package programmers.dynamic;

import static myutil.Util.*;
import java.util.*;

import myutil.Util;

public class Triangle {

    public int solution(int[][] triangle) {
        int[][] cache = new int[triangle.length][];
        for (int i = 0; i < cache.length; i++) {
            cache[i] = new int[triangle[i].length];
        }

        return computeMax(triangle, 0, 0, cache);
    }

    public int computeMax(int[][] triangle, int curX, int curY, int[][] cache) {
        if (curY == triangle.length - 1) {
            return triangle[curY][curX];
        } else if (curY >= triangle.length || curX >= triangle[curY].length) {
            return 0;
        }

        if (cache[curY][curX] != 0) {
            return cache[curY][curX];
        }

        int ret = 0;
        ret = triangle[curY][curX] +
                Integer.max(computeMax(triangle, curX, curY + 1, cache),
                        computeMax(triangle, curX + 1, curY + 1, cache));
        cache[curY][curX] = ret;
        return ret;
    }

    public static void main(String[] args) {
        Triangle p = new Triangle();

        int t = 1;
        t = getTestCaseCount();

        for (int i = 0; i < t; i++) {
            /*
             * Type var = getTypeArr[]
             * Type ...
             * ...
             * print(p.solution());
             */
            print(p.solution(getTwoDimensionalIntArray()));
        }

        Util.closeUtil();
    }
}
