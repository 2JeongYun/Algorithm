package baekjoon.backtracking;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Sudoku {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    final int MAP_SIZE = 9;

    class Target {
        int y;
        int x;

        public Target(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public int getSector() {
            return Sudoku.getSector(this.y, this.x);
        }
    }

    private void solution() throws IOException {
        int[][] map = new int[MAP_SIZE][MAP_SIZE];
        boolean[][] sectorMap = new boolean[MAP_SIZE][MAP_SIZE + 1];
        ArrayList<Target> targetList = new ArrayList<>();

        for (int i = 0; i < MAP_SIZE; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < MAP_SIZE; j++) {
                int num = Integer.valueOf(st.nextToken());
                map[i][j] = num;

                if (num == 0)
                    targetList.add(new Target(i, j));

                int sector = getSector(i, j);
                sectorMap[sector][num] = true;
            }
        }

        dfs(map, sectorMap, 0, targetList);

        bw.flush();
        bw.close();
        br.close();
    }

    private boolean dfs(int[][] map, boolean[][] sectorMap, int idx, ArrayList<Target> targetList) {
        if (idx == targetList.size()) {
            printMap(map);
            return true;
        }

        for (int n = 1; n <= 9; n++) {
            Target t = targetList.get(idx);
            if (!canPlace(map, sectorMap, t, n))
                continue;

            map[t.y][t.x] = n;
            sectorMap[t.getSector()][n] = true;

            boolean success = dfs(map, sectorMap, idx + 1, targetList);
            if (success)
                return true;

            map[t.y][t.x] = 0;
            sectorMap[t.getSector()][n] = false;
        }

        return false;
    }

    private boolean canPlace(int[][] map, boolean[][] sectorMap, Target t, int n) {
        int sector = t.getSector();

        if (sectorMap[sector][n])
            return false;
        for (int i = 0; i < MAP_SIZE; i++) {
            if (map[i][t.x] == n || map[t.y][i] == n)
                return false;
        }
        return true;
    }

    private void printMap(int[][] map) {
        for (int y = 0; y < MAP_SIZE; y++) {
            for (int x = 0; x < MAP_SIZE; x++) {
                sb.append(map[y][x]).append(" ");
            }
            sb.append("\n");
        }

        try {
            bw.write(sb.toString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static int getSector(int y, int x) {
        return (y / 3) * 3 + (x / 3);
    }

    public static void main(String[] args) throws IOException {
        Sudoku sol = new Sudoku();
        sol.solution();
    }
}
