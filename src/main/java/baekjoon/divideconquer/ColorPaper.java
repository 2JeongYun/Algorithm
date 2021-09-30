package baekjoon.divideconquer;

import java.io.*;
import java.util.StringTokenizer;

public class ColorPaper {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private void solution() throws IOException {
        int N = Integer.valueOf(br.readLine());
        int[][] map = new int[N][N];
        for (int i = 0; i < map.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < map.length; j++) {
                map[i][j] = Integer.valueOf(st.nextToken());
            }
        }

        int[] ans = getWhiteAndBlue(map, 0, 0, map.length - 1, map.length - 1, new int[2]);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }

    private int[] getWhiteAndBlue(int[][] map, int sx, int sy, int ex, int ey, int[] ans) {
        if (ex < sx || ey < sy) {
            return ans;
        }
        int color;
        if ((color = isColorPaper(map, sx, sy, ex, ey)) < 0) {
            int rightX = (sx + ex + 1) / 2;
            int rightY = (sy + ey + 1) / 2;
            getWhiteAndBlue(map, sx, sy, rightX - 1, rightY - 1, ans);
            getWhiteAndBlue(map, rightX, rightY, ex, ey, ans);
            getWhiteAndBlue(map, sx, rightY, rightX - 1, ey, ans);
            getWhiteAndBlue(map, rightX, sy, ex, rightY - 1, ans);
        } else {
            ans[color]++;
            //System.out.println(Arrays.toString(ans));
        }

        return ans;
    }

    private int isColorPaper(int[][] map, int sx, int sy, int ex, int ey) {
        int color = map[sy][sx];
        for (int y = sy; y <= ey; y++) {
            for (int x = sx; x <= ex; x++) {
                if (map[y][x] != color) {
                    return -1;
                }
            }
        }

        return color;
    }

    public static void main(String[] args) throws IOException {
        ColorPaper sol = new ColorPaper();
        sol.solution();

        bw.flush();
        bw.close();
        br.close();
    }
}
