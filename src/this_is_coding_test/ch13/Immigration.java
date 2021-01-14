package this_is_coding_test.ch13;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Immigration {
    final int[] dx = {0, 1, 0, -1};
    final int[] dy = {1, 0, -1, 0};

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./src/this_is_coding_test/ch13/input.txt"));
        StringTokenizer st;

        int[][] map;
        int n, l, r;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        for (int y = 0; y < n; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < n; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        while (doImmigration(map, l, r)) {
            answer++;
        }
        System.out.println(answer);
    }

    private boolean doImmigration(int[][] map, int l, int r) {
        ArrayList<ArrayList<Pair>> unions = new ArrayList<>();
        boolean[][] visit = new boolean[map.length][map.length];
        boolean isMove = false;

        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map.length; x++) {
                if (!visit[y][x]) {
                    ArrayList<Pair> union = new ArrayList<>();
                    setUnion(map, l, r, new Pair(x, y), visit, union);
                    unions.add(union);
                }
            }

            for (ArrayList<Pair> union : unions) {
                if (union.size() > 1) {
                    isMove = true;
                }
                int total = 0;
                int population = 0;
                for (Pair country : union) {
                    total += map[country.y][country.x];
                }
                population = total / union.size();

                for (Pair country : union) {
                    map[country.y][country.x] = population;
                }
            }
        }

        return isMove;
    }

    private void setUnion(int[][] map, int l, int r, Pair country, boolean[][] visit, ArrayList<Pair> union) {
        if (visit[country.y][country.x]) {
            return;
        }
        visit[country.y][country.x] = true;
        union.add(country);

        for (int d = 0; d < 2; d++) {
            int nextX = country.x + dx[d];
            int nextY = country.y + dy[d];
            if (nextX >= 0 && nextY >= 0 && nextX < map.length && nextY < map.length) {
                int diff = Math.abs(map[nextY][nextX] - map[country.y][country.x]);
                if (diff <= r && diff >= l) {
                    setUnion(map, l, r, new Pair(nextX, nextY), visit, union);
                }
            }
        }

        return;
    }

    public class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return String.format("%d %d", x, y);
        }
    }

    public static void main(String[] args) throws IOException {
        Immigration i = new Immigration();
        i.solution();
    }
}
