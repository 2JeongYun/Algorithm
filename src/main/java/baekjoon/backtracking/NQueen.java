package baekjoon.backtracking;

import java.io.*;

public class NQueen {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n;

    private void solution() throws IOException {
        n = Integer.valueOf(br.readLine());
        int[] prevX = new int[n];
        int[] prevY = new int[n];
        bw.write(Integer.toString(dfs(prevY, prevX, 0, 0)));
        bw.flush();
        bw.close();
        br.close();
    }

    private int dfs(int[] prevY, int[] prevX, int idx, int curY) {
        if (idx == prevY.length)
            return 1;
        if (curY >= prevY.length)
            return 0;

        int ret = 0;
        for (int x = 0; x < prevX.length; x++) {
            if (!canExist(prevY, prevX, idx, curY, x))
                continue;
            prevY[idx] = curY;
            prevX[idx] = x;
            ret += dfs(prevY, prevX, idx + 1, curY + 1);
        }
        return ret;
    }

    private boolean canExist(int[] prevY, int[] prevX, int idx, int y, int x) {
        for (int i = 0; i < idx; i++) {
            if (prevY[i] == y || prevX[i] == x)
                return false;
            if (Math.abs(prevY[i] - y) == Math.abs(prevX[i] - x))
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        NQueen sol = new NQueen();
        sol.solution();
    }
}
