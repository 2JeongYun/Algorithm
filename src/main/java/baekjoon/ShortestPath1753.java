package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ShortestPath1753 {
    int vSize, eSize;
    int startNode;
    int[][] weight;
    int[] distance;
    boolean[] visit;
    PriorityQueue<Integer> pQue;

    public void doit() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringTokenizer st;

        line = br.readLine();
        st = new StringTokenizer(line);
        vSize = Integer.parseInt(st.nextToken());
        eSize = Integer.parseInt(st.nextToken());

        line = br.readLine();
        startNode = Integer.parseInt(line);

        weight = new int[vSize + 1][vSize + 1];
        distance = new int[vSize + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[1] = 0;
        visit = new boolean[vSize + 1];
        Arrays.fill(visit, false);
        pQue = new PriorityQueue<>();

        for (int i = 0; i < vSize + 1; i++) {
            Arrays.fill(weight[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < eSize; i++) {
            line = br.readLine();
            st = new StringTokenizer(line);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (weight[a][b] > c)
                weight[a][b] = c;
        }

        routing(1);
        for (int i = 1; i < vSize + 1; i++) {
            if (visit[i])
                System.out.println(distance[i]);
            else
                System.out.println("INF");
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
        ShortestPath1753 st = new ShortestPath1753();
        st.doit();
    }
}
