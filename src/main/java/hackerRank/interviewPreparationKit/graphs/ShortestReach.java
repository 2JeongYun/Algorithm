package hackerRank.interviewPreparationKit.graphs;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ShortestReach {

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int queryCnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < queryCnt; i++) {
            ArrayList<Integer>[] graph;

            st = new StringTokenizer(br.readLine());
            int nodeCnt = Integer.parseInt(st.nextToken());
            int edgeCnt = Integer.parseInt(st.nextToken());

            graph = new ArrayList[nodeCnt + 1];
            for (int j = 1; j < graph.length; j++) {
                graph[j] = new ArrayList<>();
            }

            for (int j = 0; j < edgeCnt; j++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                graph[from].add(to);
                graph[to].add(from);
            }

            int start = Integer.parseInt(br.readLine());
            int[] distances = getDistances(graph, start);

            for (int j = 1; j < distances.length; j++) {
                if (j == start) {
                    continue;
                }
                if (distances[j] == 0) {
                    bw.write("-1 ");
                } else {
                    bw.write(String.format("%d ", distances[j]));
                }
            }
            bw.write("\n");
            bw.flush();
        }
    }

    static int[] getDistances(ArrayList<Integer>[] graph, int start) {
        int[] distances = new int[graph.length];
        Queue<Integer> bfsQue = new LinkedList<>();

        bfsQue.add(start);
        int passCnt = 1;
        int nextPassCnt = 0;
        int distance = 0;
        boolean[] visit = new boolean[graph.length];
        while (bfsQue.isEmpty() == false) {
            int cur = bfsQue.poll();
            distances[cur] = distance * 6;
            visit[cur] = true;

            passCnt -= 1;
            if (passCnt == 0) {
                distance++;
            }

            for (int node : graph[cur]) {
                if (visit[node] == false && bfsQue.contains(node) == false) {
                    bfsQue.add(node);
                    nextPassCnt++;
                }
            }

            if (passCnt == 0) {
                passCnt = nextPassCnt;
                nextPassCnt = 0;
            }
        }

        return distances;
    }
}
