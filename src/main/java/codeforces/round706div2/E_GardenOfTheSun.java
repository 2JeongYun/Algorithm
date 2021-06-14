package codeforces.round706div2;

import java.io.*;
import java.util.StringTokenizer;

public class E_GardenOfTheSun {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            solve(br, bw);
        }

        br.close();
        bw.close();
    }

    public void solve(BufferedReader br, BufferedWriter bw) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        boolean[][] map = new boolean[n][m];

        for (int y = 0; y < n; y++) {
            String line = br.readLine();
            for (int x = 0; x < m; x++) {
                boolean cur = (line.charAt(x) == 'X') ? true : false;
                map[y][x] = (x % 3 == 1) ? true : cur;
            }
        }

        if (m == 1) {
            for (int y = 0; y < n; y++) {
                map[y][0] = true;
            }
        }

        for (int x = 3; x < m; x += 3) {
            boolean isConnected = false;
            boolean isLast = false;
            if (x + 1 == m) {
                isLast = true;
            }

            for (int y = 0; y < n; y++) {
                if (isLast) {
                    if (map[y][x]) {
                        map[y][x - 1] = true;
                    }
                } else {
                    if (map[y][x] || map[y][x - 1]) {
                        map[y][x] = true;
                        map[y][x - 1] = true;
                        isConnected = true;
                        break;
                    }
                }
            }

            if (!isLast && !isConnected) {
                map[0][x] = true;
                map[0][x - 1] = true;
            }
        }

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (map[y][x]) {
                    bw.write('X');
                } else {
                    bw.write('.');
                }
            }
            bw.newLine();
        }
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        E_GardenOfTheSun p = new E_GardenOfTheSun();
        p.solution();
    }
}
