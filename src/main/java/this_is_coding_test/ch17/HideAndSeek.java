package this_is_coding_test.ch17;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class HideAndSeek {
    final int MAX = 9999999;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./src/this_is_coding_test/ch17/input.txt"));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //인접리스트
        ArrayList<Integer>[] map = new ArrayList[N + 1];
        for (int i = 0; i < map.length; i++) {
            map[i] = new ArrayList<>();
        }
        int[] minDistance = new int[N + 1];
        Arrays.fill(minDistance, MAX);
        minDistance[1] = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a].add(b);
            map[b].add(a);
        }

        //다익스트라
        PriorityQueue<Place> pQue = new PriorityQueue<>();
        pQue.add(new Place(1, 0));
        while (pQue.isEmpty() == false) {
            Place cur = pQue.poll();
            int nextDist = minDistance[cur.no] + 1;
            for (int next : map[cur.no]) {
                if (nextDist < minDistance[next]) {
                    pQue.add(new Place(next, nextDist));
                    minDistance[next] = nextDist;
                }
            }
        }

        int maxDist = -1;
        int farPlace = -1;
        int cnt = 0;
        for (int i = 1; i < minDistance.length; i++) {
            if (minDistance[i] > maxDist) {
                cnt = 1;
                maxDist = minDistance[i];
                farPlace = i;
            } else if (minDistance[i] == maxDist) {
                cnt++;
            }
        }
        System.out.println(String.format("%d %d %d", farPlace, maxDist, cnt));
    }

    class Place implements Comparable<Place> {
        int no;
        int distance;

        Place(int no, int distance) {
            this.no = no;
            this.distance = distance;
        }

        @Override
        public int compareTo(Place o) {
            return (distance > o.distance) ? 1 : -1;
        }
    }

    public static void main(String[] args) throws IOException {
        HideAndSeek h = new HideAndSeek();
        h.solution();
    }
}
