package this_is_coding_test.ch16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GoldMine {
    public static void main(String[] args) throws IOException {
        GoldMine g = new GoldMine();
        g.solution();
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine());
            int ySize = Integer.parseInt(st.nextToken());
            int xSize = Integer.parseInt(st.nextToken());
            int[][] mine = new int[ySize][xSize];

            st = new StringTokenizer(br.readLine());
            for (int y = 0; y < ySize; y++) {
                for (int x = 0; x < xSize; x++) {
                    mine[y][x] = Integer.parseInt(st.nextToken());
                }
            }

            System.out.println(getMaxGold(mine));
        }
    }

    public int getMaxGold(int[][] mine) {
        int[][] cache = new int[mine.length][mine[0].length];

        for (int x = 0; x < mine[0].length; x++) {
            for (int y = 0; y < mine.length; y++) {
                if (x - 1 >= 0) {
                    if (y + 1 < mine.length) {
                        cache[y][x] = Integer.max(cache[y][x - 1], cache[y + 1][x - 1]);
                    }
                    if (y - 1 >= 0) {
                        cache[y][x] = Integer.max(cache[y][x], cache[y - 1][x - 1]);
                    }
                }
                cache[y][x] += mine[y][x];
            }
        }

        int ret = Integer.MIN_VALUE;
        for (int y = 0; y < mine.length; y++) {
            ret = Integer.max(ret, cache[y][cache[0].length - 1]);
        }
        return ret;
    }
}
