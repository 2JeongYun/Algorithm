package programmers.kakaoprev.q2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Taxi {

    static final int INF = Integer.MAX_VALUE;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        ArrayList<Info>[] map = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            map[i] = new ArrayList<>();
        }

        for (int[] fare : fares) {
            map[fare[0]].add(new Info(fare[1], fare[2]));
            map[fare[1]].add(new Info(fare[0], fare[2]));
        }

        int[] distA = new int[n + 1];
        int[] distB = new int[n + 1];
        int[] distS = new int[n + 1];

        compute(distA, a, map);
        compute(distB, b, map);
        compute(distS, s, map);

        int minPrice = Integer.min(distS[a] + distA[b], distS[b] + distB[a]);
        minPrice = Integer.min(minPrice, distS[a] + distS[b]);

        for (int midNode = 1; midNode < distS.length; midNode++) {
            int midDist = distS[midNode];
            if (midDist == 0)
                continue;

            int candidate = midDist + distA[midNode] + distB[midNode];
            minPrice = Integer.min(minPrice, candidate);
        }

        return minPrice;
    }

    private int[] compute(int[] dist, int start, ArrayList<Info>[] map) {
        for (int i = 0; i < dist.length; i++) {
            dist[i] = INF;
        }
        dist[start] = 0;

        PriorityQueue<Info> pQue = new PriorityQueue<>((o1, o2) -> o1.dist - o2.dist);
        boolean[] visit = new boolean[dist.length];
        Arrays.fill(visit, false);
        pQue.add(new Info(start, 0));

        while (!pQue.isEmpty()) {
            int curNode = pQue.poll().node;
            if (visit[curNode])
                continue;

            visit[curNode] = true;
            for (Info next : map[curNode]) {
                int newDist = next.dist + dist[curNode];
                if (newDist < 0)
                    newDist = INF;

                if (newDist < dist[next.node]) {
                    dist[next.node] = newDist;
                    pQue.add(new Info(next.node, newDist));
                }
            }
        }

        return dist;
    }

    static class Info {
        int node;
        int dist;

        public Info(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }

        @Override
        public String toString() {
            return "Info{" +
                    "node=" + node +
                    ", dist=" + dist +
                    '}';
        }
    }
}
