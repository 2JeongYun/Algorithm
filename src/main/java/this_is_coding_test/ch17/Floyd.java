package this_is_coding_test.ch17;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Floyd {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int maxCity = Integer.parseInt(br.readLine());
        int maxBus = Integer.parseInt(br.readLine());
        int[][] cost = new int[maxCity][maxCity];
        for (int i = 0; i < maxCity; i++) {
            Arrays.fill(cost[i], Integer.MAX_VALUE);
            cost[i][i] = 0;
        }

        for (int i = 0; i < maxBus; i++) {
            st = new StringTokenizer(br.readLine());
            int departure = Integer.parseInt(st.nextToken()) - 1;
            int arrival = Integer.parseInt(st.nextToken()) - 1;
            int distance = Integer.parseInt(st.nextToken());
            if (distance < cost[departure][arrival]) {
                cost[departure][arrival] = distance;
            }
        }

        for (int k = 0; k < maxCity; k++) {
            for (int i = 0; i < maxCity; i++) {
                for (int j = 0; j < maxCity; j++) {
                    cost[i][j] = Integer.min(cost[i][j], (cost[i][k] + cost[k][j] < 0) ? Integer.MAX_VALUE : cost[i][k] + cost[k][j]);
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < maxCity; i++) {
            for (int j = 0; j < maxCity; j++) {
                if (cost[i][j] == Integer.MAX_VALUE) {
                    sb.append(0).append(" ");
                } else {
                    sb.append(cost[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();

        br.close();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        Floyd f = new Floyd();
        f.solution();
    }
}
