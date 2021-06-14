package this_is_coding_test.ch10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class TeamMaking {
    int maxNum, operNum;
    int[] team;

    public int findTeam(int[] team, int stNum) {
        if (team[stNum] != stNum) {
            team[stNum] = findTeam(team, team[stNum]);
        }
        return team[stNum];
    }

    public void union(int a, int b) {
        int aTeam = findTeam(team, a);
        int bTeam = findTeam(team, b);
        if (aTeam < bTeam) {
            team[bTeam] = aTeam;
        } else {
            team[aTeam] = bTeam;
        }
    }

    public void doit() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(".\\src\\this_is_coding_test\\ch10\\input.txt"));
        StringTokenizer st;
        String line;

        line = br.readLine();
        st = new StringTokenizer(line);
        maxNum = Integer.parseInt(st.nextToken());
        operNum = Integer.parseInt(st.nextToken());

        team = new int[maxNum + 1];
        for (int i = 0; i < maxNum + 1; i++) {
            team[i] = i;
        }

        for (int i = 0; i < operNum; i++) {
            line = br.readLine();
            st = new StringTokenizer(line);
            int type = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (type == 0) {
                union(a, b);
            } else {
                if (findTeam(team, a) == findTeam(team, b)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        TeamMaking tm = new TeamMaking();
        tm.doit();
    }
}
