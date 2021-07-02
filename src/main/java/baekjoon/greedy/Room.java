package baekjoon.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Room {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final int START = 0;
    static final int END = 1;

    private void solution() throws IOException {
        final int N = Integer.valueOf(br.readLine());
        int[][] conf = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            conf[i][START] = Integer.valueOf(st.nextToken());
            conf[i][END] = Integer.valueOf(st.nextToken());
        }

        Arrays.sort(conf, (int[] o1, int[] o2) -> {
            if (o1[END] < o2[END]) {
                return -1;
            } else if (o1[END] == o2[END]) {
                if (o1[START] < o2[START]) {
                    return - 1;
                }
                return 0;
            } else {
                return 1;
            }
        });

        int ans = 0;
        int time = 0;
        for (int i = 0; i < conf.length; i++) {
            if (conf[i][START] >= time) {
                ans++;
                time = conf[i][END];
            }
        }

        bw.write(String.valueOf(ans));
    }

    public static void main(String[] args) throws IOException {
        Room sol = new Room();
        sol.solution();

        bw.flush();
        bw.close();
        br.close();
    }
}
