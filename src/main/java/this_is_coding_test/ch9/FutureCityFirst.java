package this_is_coding_test.ch9;

import myutil.MyUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FutureCityFirst {
    int vSize, eSize, checkPoint, destination;
    int[][] weight;
    int[] distance;
    boolean[] visit;

    public void doit() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringTokenizer st;
        int input[] = MyUtil.lineToIntArray(br.readLine());
        vSize = input[0];
        eSize = input[1];
        distance = new int[vSize + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[1] = 0;
        visit = new boolean[vSize + 1];
        Arrays.fill(visit, false);

        weight = new int[vSize + 1][vSize + 1];
        for (int i = 0; i < vSize + 1; i++) {
            Arrays.fill(weight[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < eSize; i++) {
            line = br.readLine();
            st = new StringTokenizer(line);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            weight[a][b] = 1;
            weight[b][a] = 1;
        }

        input = MyUtil.lineToIntArray(br.readLine());
        destination = input[0];
        checkPoint = input[1];
        routing(1);
        int total = 0;
        if (visit[checkPoint]) {
            total += distance[checkPoint];
        } else {
            System.out.println(-1);
            return;
        }

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[checkPoint] = 0;

        Arrays.fill(visit, false);

        routing(checkPoint);
        if (visit[destination]) {
            total += distance[destination];
            System.out.println(total);
        } else {
            System.out.println(-1);
            return;
        }
    }

    public void routing(int node) {
        visit[node] = true;
        for (int i = 1; i < vSize + 1; i++) {
            int nextWeight = weight[node][i] + distance[node];
            if (nextWeight >= 0 && nextWeight < distance[i]) {
                distance[i] = nextWeight;
            }
        }
        int min = Integer.MAX_VALUE;
        int next = -1;
        for (int i = 1; i < vSize + 1; i++) {
            if (distance[i] < min && !visit[i]) {
                next = i;
            }
        }
        if (next == -1) {
            return;
        }
        routing(next);
    }

    public static void main(String[] args) throws IOException {
        FutureCityFirst fc = new FutureCityFirst();
        fc.doit();
    }
}
