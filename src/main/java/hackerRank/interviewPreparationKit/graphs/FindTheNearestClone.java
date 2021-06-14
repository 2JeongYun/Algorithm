package hackerRank.interviewPreparationKit.graphs;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FindTheNearestClone {

    // Complete the findShortest function below.

    /*
     * For the unweighted graph, <name>:
     *
     * 1. The number of nodes is <name>Nodes.
     * 2. The number of edges is <name>Edges.
     * 3. An edge exists between <name>From[i] to <name>To[i].
     *
     */
    static int findShortest(int graphNodes, int[] graphFrom, int[] graphTo, long[] ids, int val) {
        // solve here
        ArrayList<Integer>[] graph = new ArrayList[graphNodes + 1];
        for (int i = 0; i < graphFrom.length; i++) {
            int from = graphFrom[i];
            int to = graphTo[i];

            if (graph[from] == null) {
                graph[from] = new ArrayList<>();
            }
            if (graph[to] == null) {
                graph[to] = new ArrayList<>();
            }

            graph[from].add(to);
            graph[to].add(from);
        }

        ArrayList<Integer> targetNodes = new ArrayList<>();
        for (int i = 0; i < ids.length; i++) {
            if (ids[i] == val) {
                targetNodes.add(i + 1);
            }
        }

        int minDistance = Integer.MAX_VALUE;
        for (int node : targetNodes) {
            minDistance = Integer.min(minDistance, getDistance(node, graph, ids, val));
        }

        return (minDistance == Integer.MAX_VALUE) ? -1 : minDistance;
    }

    static int getDistance(int start, ArrayList<Integer>[] graph, long[] ids, int color) {
        Queue<Integer> bfsQue = new LinkedList<>();
        bfsQue.add(start);
        int cnt = 1;
        int nextCnt = 0;
        int distance = 0;

        boolean[] visit = new boolean[graph.length];

        while (bfsQue.isEmpty() == false) {
            int curNode = bfsQue.poll();
            visit[curNode] = true;

            if (ids[curNode - 1] == color && curNode != start) {
                return distance;
            }

            cnt -= 1;
            if (cnt == 0) {
                distance++;
            }

            for (int node : graph[curNode]) {
                if (visit[node] == false) {
                    bfsQue.add(node);
                    nextCnt++;
                }
            }

            if (cnt == 0) {
                cnt = nextCnt;
                nextCnt = 0;
            }
        }

        return Integer.MAX_VALUE;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] graphNodesEdges = scanner.nextLine().split(" ");
        int graphNodes = Integer.parseInt(graphNodesEdges[0].trim());
        int graphEdges = Integer.parseInt(graphNodesEdges[1].trim());

        int[] graphFrom = new int[graphEdges];
        int[] graphTo = new int[graphEdges];

        for (int i = 0; i < graphEdges; i++) {
            String[] graphFromTo = scanner.nextLine().split(" ");
            graphFrom[i] = Integer.parseInt(graphFromTo[0].trim());
            graphTo[i] = Integer.parseInt(graphFromTo[1].trim());
        }

        long[] ids = new long[graphNodes];

        String[] idsItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < graphNodes; i++) {
            long idsItem = Long.parseLong(idsItems[i]);
            ids[i] = idsItem;
        }

        int val = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int ans = findShortest(graphNodes, graphFrom, graphTo, ids, val);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
