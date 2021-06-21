package baekjoon.backtracking;

import java.io.*;

public class NQueenV2 {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n;

    private void solution() throws IOException {
        n = Integer.valueOf(br.readLine());
        bw.write(String.valueOf(dfs(new int[n][n], 0, 0)));

        bw.flush();
        bw.close();
        br.close();
    }

    private int dfs(int[][] board, int qCnt, int depth) {
        if (qCnt == n)
            return 1;
        if (depth == n)
            return 0;

        int ret = 0;
        for (int x = 0; x < n; x++) {
            if (board[depth][x] > 0)
                continue;
            placeQueen(board, depth, x);
            ret += dfs(board, qCnt + 1, depth + 1);
            removeQueen(board, depth, x);
        }

        return ret;
    }


    private void placeQueen(int[][] board, int depth, int x) {
        for (int d = depth + 1; d < n; d++) {
            board[d][x]++;
            int diff = d - depth;
            if (x - diff >= 0)
                board[d][x - diff]++;
            if (x + diff < n)
                board[d][x + diff]++;
        }
    }

    private void removeQueen(int[][] board, int depth, int x) {
        for (int d = depth + 1; d < n; d++) {
            board[d][x]--;
            int diff = d - depth;
            if (x - diff >= 0)
                board[d][x - diff]--;
            if (x + diff < n)
                board[d][x + diff]--;
        }
    }

    public static void main(String[] args) throws IOException {
        NQueenV2 sol = new NQueenV2();
        sol.solution();
    }
}
