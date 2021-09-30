package baekjoon.divideconquer;

import java.io.*;

public class QuadTree {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private void solution() throws IOException {
        int N = Integer.valueOf(br.readLine());
        int[][] map = new int[N][N];
        for (int i = 0; i < map.length; i++) {
            String line = br.readLine();
            for (int j = 0; j < map.length; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        StringBuffer sb = zip(map, 0, 0, map.length - 1, map.length - 1, new StringBuffer());
        System.out.println(sb.toString());
    }

    private StringBuffer zip(int[][] map, int sx, int sy, int ex, int ey, StringBuffer sb) {
        if (ex < sx || ey < sy) {
            return sb;
        }

        int color;
        if ((color = canZip(map, sx, sy, ex, ey)) < 0) {
            sb.append("(");
            int rightX = (sx + ex + 1) / 2;
            int rightY = (sy + ey + 1) / 2;
            zip(map, sx, sy, rightX - 1, rightY - 1, sb);
            zip(map, rightX, sy, ex, rightY - 1, sb);
            zip(map, sx, rightY, rightX - 1, ey, sb);
            zip(map, rightX, rightY, ex, ey, sb);
            sb.append(")");
        } else {
            sb.append(color);
        }

        return sb;
    }

    private int canZip(int[][] map, int sx, int sy, int ex, int ey) {
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
        QuadTree sol = new QuadTree();
        sol.solution();

        bw.flush();
        bw.close();
        br.close();
    }
}
