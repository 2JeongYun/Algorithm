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

        int moveCnt = 0;
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
    }

    ArrayList<Pair> getUnion(int[][] map, Pair country, boolean[][] visit, int l, int r) {
        ArrayList<Pair> result = new ArrayList<>();
        result.add(new Pair(country.x, country.y));


    }

    public class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        Immigration i = new Immigration();
        i.solution();
    }
}
