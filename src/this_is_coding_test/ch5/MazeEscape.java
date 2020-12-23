package this_is_coding_test.ch5;

import myutil.MyUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class MazeEscape {
    int ySize, xSize;
    int[][] map;
    Deque<Integer> queue = new LinkedList<>();
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        MazeEscape mazeEscape = new MazeEscape();
        mazeEscape.doit();
    }

    public void doit() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        line = br.readLine();
        int[] input = MyUtil.lineToIntArray(line);
        ySize = input[0];
        xSize = input[1];

        map = MyUtil.make2by2IntArray(br, xSize, ySize, false);
        queue.add(0);
        queue.add(0);
        escape();

        System.out.println(map[ySize - 1][xSize - 1]);
    }

    private void escape() {
        if (queue.isEmpty()) {
            return;
        }
        int x = queue.poll();
        int y = queue.poll();

        if (x == xSize - 1 && y == ySize - 1) {
            return;
        } else {
            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                if (nextX >= 0 && nextX < xSize && nextY >= 0 && nextY < ySize) {
                    if (map[nextY][nextX] == 1) {
                        queue.add(nextX);
                        queue.add(nextY);
                        map[nextY][nextX] = map[y][x] + 1;
                    }
                }
            }
            escape();
        }
    }
}
