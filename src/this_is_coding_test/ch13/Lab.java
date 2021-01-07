package this_is_coding_test.ch13;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Lab {
    final int VIRUS = 2;
    final int SAFE = 0;
    final int WALL = 1;
    final int[] dx = {0, 1, 0, -1};
    final int[] dy = {1, 0, -1, 0};

    int map[][];
    int maxSafeSize;
    int n, m;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./src/this_is_coding_test/ch13/input.txt"));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        ArrayList<Pair> viruses = new ArrayList<>();

        for (int y = 0; y < n; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < m; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
                if (map[y][x] == VIRUS) {
                    viruses.add(new Pair(x, y));
                }
            }
        }

        maxSafeSize = Integer.MIN_VALUE;
        ArrayList<ArrayList<Integer>> combinations = new ArrayList<>();
        getCombination(n * m, 3, 0, new ArrayList<Integer>(), combinations);
        int[][] cloneMap = new int[n][m];
        arrCopy(map, cloneMap);
        for (ArrayList<Integer> combination : combinations) {
            boolean check = true;
            arrCopy(map, cloneMap);

            for (int i = 0; i < 3; i++) {
                int x = combination.get(i) % m;
                int y = combination.get(i) / m;
                if (cloneMap[y][x] != SAFE) {
                    check = false;
                }
                cloneMap[y][x] = WALL;
            }
            if (check) {
                for (Pair virus : viruses) {
                    fillVirus(cloneMap, virus.x, virus.y);
                }
                int safeSize = getSafeSize(cloneMap);

                maxSafeSize = (maxSafeSize < safeSize) ? safeSize : maxSafeSize;
            }
        }

        System.out.println(maxSafeSize);
    }

    public void arrCopy(int[][] origin, int[][] copy) {
        for (int i = 0; i < origin.length; i++) {
            for (int j = 0; j < origin[0].length; j++) {
                copy[i][j] = origin[i][j];
            }
        }
    }

    public class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void getCombination(int max, int target, int curNum,
                               ArrayList<Integer> curArr, ArrayList<ArrayList<Integer>> result) {
        if (curArr.size() == target) {
            result.add(curArr);
            return;
        } else if (curNum >= max) {
            return;
        }

        ArrayList<Integer> cloneArr = (ArrayList<Integer>) curArr.clone();
        cloneArr.add(curNum);
        getCombination(max, target, curNum + 1, cloneArr, result);
        getCombination(max, target, curNum + 1, curArr, result);
    }

    public int getSafeSize(int[][] map) {
        int ret = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == SAFE) {
                    ret++;
                }
            }
        }
        return ret;
    }

    public void fillVirus(int[][] map, int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX < 0 || nextY < 0 || nextX >= map[0].length || nextY >= map.length) {
                continue;
            }
            if (map[nextY][nextX] == SAFE) {
                map[nextY][nextX] = VIRUS;
                fillVirus(map, nextX, nextY);
            }
        }
        return;
    }

    public static void main(String[] args) throws IOException {
        Lab l = new Lab();
        l.solution();
    }
}
