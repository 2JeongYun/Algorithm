package this_is_coding_test.ch17;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Mars {
    final int MAX = 99999999;
    final int[] dx = {0, 1, 0, -1};
    final int[] dy = {1, 0, -1, 0};

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./src/this_is_coding_test/ch17/input.txt"));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        for (int testCase = 0; testCase < TC; testCase++) {
            int N = Integer.parseInt(br.readLine());
            int[][] map = new int[N + 2][N + 2];
            Arrays.fill(map[0], MAX);
            Arrays.fill(map[map.length - 1], MAX);
            for (int y = 1; y < map.length - 1; y++) {
                st = new StringTokenizer(br.readLine());
                for (int x = 0; x < map.length; x++) {
                    map[y][x] = (x == 0 || x == map.length - 1) ?
                            MAX : Integer.parseInt(st.nextToken());
                }
            }
            System.out.println(findRoute(map));
        }
    }

    public int findRoute(int[][] map) {
        int[][] minDist = new int[map.length][map.length];
        for (int y = 0; y < minDist.length; y++) {
            Arrays.fill(minDist[y], MAX);
        }
        minDist[1][1] = map[1][1];
        PriorityQueue<YX> pQue = new PriorityQueue<>();
        pQue.add(new YX(1, 1, minDist[1][1]));

        while (pQue.isEmpty() == false) {
            YX cur = pQue.poll();
            if (cur.y == map.length - 2 && cur.x == map.length - 2) {
                break;
            }

            for (int d = 0; d < dx.length; d++) {
                YX next = new YX(cur.y + dy[d], cur.x + dx[d]);
                int nextDist = minDist[cur.y][cur.x] + map[next.y][next.x];
                if (nextDist < minDist[next.y][next.x]) {
                    minDist[next.y][next.x] = nextDist;
                    next.dist = nextDist;
                    pQue.add(next);
                }
            }
        }

        return minDist[map.length - 2][map.length - 2];
    }

    public static void main(String[] args) throws IOException {
        Mars m = new Mars();
        m.solution();
    }

    class YX implements Comparable<YX> {
        int x, y, dist;

        YX(int y, int x) {
            this.x = x;
            this.y = y;
            this.dist = -1;
        }

        YX(int y, int x, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public int compareTo(YX o) {
            if (this.dist > o.dist) {
                return 1;
            }
            return -1;
        }
    }
}
