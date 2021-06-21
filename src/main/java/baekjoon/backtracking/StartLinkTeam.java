package baekjoon.backtracking;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class StartLinkTeam {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int[][] statMap;
    int n;
    static final int S = 0, L = 1;

    private void solution() throws IOException {
        n = Integer.valueOf(br.readLine());
        statMap = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                statMap[i][j] = Integer.valueOf(st.nextToken());
            }
        }

        int[][] team = new int[2][n / 2];
        for (int i = 0; i < team.length; i++) {
            Arrays.fill(team[i], -1);
        }
        bw.write(String.valueOf(dfs(team, 0, 0, 0, 0, 0)));

        bw.flush();
        bw.close();
        br.close();
    }

    private int dfs(int[][] team, int sStat, int lStat, int sIdx, int lIdx, int player) {
        if (player == n)
            return Math.abs(sStat - lStat);

        int maxTeamSize = n / 2;
        int ret = Integer.MAX_VALUE;
        for (int i = 0; i < team.length; i++) {
            int candidate;
            if (i == S) {
                if (sIdx == maxTeamSize)
                    continue;
                team[S][sIdx] = player;
                candidate = dfs(team, addTeamStat(team[S], sStat, player), lStat, sIdx + 1, lIdx, player + 1);
                team[S][sIdx] = -1;
            } else {
                if (lIdx == maxTeamSize)
                    continue;
                team[L][lIdx] = player;
                candidate = dfs(team, sStat, addTeamStat(team[L], lStat, player), sIdx, lIdx + 1, player + 1);
                team[L][lIdx] = -1;
            }
            ret = Integer.min(ret, candidate);
        }
        return ret;
    }

    private int addTeamStat(int[] team, int sStat, int player) {
        for (int i = 0; i < team.length; i++) {
            int other = team[i];
            if (other == -1)
                break;
            sStat += statMap[other][player];
            sStat += statMap[player][other];
        }

        return sStat;
    }

    public static void main(String[] args) throws IOException {
        StartLinkTeam sol = new StartLinkTeam();
        sol.solution();
    }
}
