package this_is_coding_test.ch5;

import myutil.MyUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IceDrink {
    int map[][];
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    int xSize, ySize;

    public static void main(String[] args) throws IOException {
        IceDrink iceDrink = new IceDrink();
        iceDrink.doit();
    }

    public void doit() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        line = br.readLine();

        int[] input = MyUtil.lineToIntArray(line);
        ySize = input[0];
        xSize = input[1];
        map = new int[ySize][xSize];
        map = MyUtil.make2by2IntArray(br, xSize, ySize, false);

        int answer = 0;

        for (int i = 0; i < ySize; i++) {
            for (int j = 0; j < xSize; j++) {
                if (makeIceDrink(j, i)) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
        return;
    }

    private boolean makeIceDrink(int x, int y) {
        if (map[y][x] == 0) {
            putIce(x, y);
            return true;
        }
        return false;
    }

    private void putIce(int x, int y) {
        if (map[y][x] == 0) {
            map[y][x] = 1;
            for (int i = 0; i < 4; i++) {
                if (x + dx[i] < xSize && y + dy[i] < ySize && x + dx[i] >= 0 && y + dy[i] >= 0) {
                    if (map[y + dy[i]][x + dx[i]] == 0) {
                        putIce(x + dx[i], y + dy[i]);
                    }
                }
            }
        }
    }
}
