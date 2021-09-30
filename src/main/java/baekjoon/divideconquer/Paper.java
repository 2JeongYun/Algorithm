package baekjoon.divideconquer;

import java.io.*;
import java.util.StringTokenizer;

public class Paper {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private void solution() throws IOException {
        int n = Integer.valueOf(br.readLine());
        int[][] map = new int[n][n];
        for (int i = 0; i < map.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < map.length; j++) {
                map[i][j] = Integer.valueOf(st.nextToken());
            }
        }

        int[] ans = getCount(map, 0, 0, n, n, new int[3]);
        for (int i : ans) {
            System.out.println(i);
        }
    }

    private int[] getCount(int[][] map, int sx, int sy, int ex, int ey, int[] ret) {
        if (ex - 1 <= sx || ey - 1 <= sy) {
            int value = map[sy][sx];
            ret[value + 1]++;
            return ret;
        }

        int result;
        if ((result = check(map, sx, sy, ex, ey)) == -2) {
            for (int y = sy; y < ey; y += (ey - sy) / 3) {
                for (int x = sx; x < ex; x += (ex - sx) / 3) {
                    getCount(map, x, y, x + (ex - sx) / 3, y + (ey - sy) / 3, ret);
                }
            }
        } else {
            ret[result + 1]++;
        }
        return ret;
    }

    private int check(int[][] map, int sx, int sy, int ex, int ey) {
        int value = map[sy][sx];
        for (int i = sx; i < ex; i++) {
            for (int j = sy; j < ey; j++) {
                if (value != map[j][i])
                    return -2;
            }
        }
        return value;
    }

    public static void main(String[] args) throws IOException {
        Paper sol = new Paper();
        sol.solution();

        bw.flush();
        bw.close();
        br.close();
    }
}
