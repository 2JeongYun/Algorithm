package baekjoon.bruteforce;

import java.io.*;
import java.util.StringTokenizer;

public class Chess {

    final static int WHITE = -1;
    final static int BLACK = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.valueOf(st.nextToken()), M = Integer.valueOf(st.nextToken());
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                if (line.charAt(j) == 'W')
                    map[i][j] = WHITE;
                else
                    map[i][j] = BLACK;
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                int candidate = Integer.min(getReplaceCount(map, i, j, WHITE),
                        getReplaceCount(map, i, j, BLACK));
                answer = Integer.min(answer, candidate);
            }
        }

        bw.write(Integer.toString(answer));
        bw.flush();

        br.close();
        bw.close();
    }

    public static int getReplaceCount(int[][] map, int y, int x, int firstColor) {
        int nextColor = firstColor;
        int ret = 0;
        for (int i = y; i < y + 8; i++) {
            for (int j = x; j < x + 8; j++) {
                if (map[i][j] != nextColor)
                    ret++;
                nextColor *= -1;
            }
            nextColor *= -1;
        }
        return ret;
    }
}
