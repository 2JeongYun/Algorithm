package codeforces.round706div2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D_LetsGoHiking {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve(br, bw);

        br.close();
        bw.close();
    }

    public boolean canMoveUp(int[] p, int idx) {
        return (p[idx + 1] < p[idx]) ? true : false;
    }

    public boolean canMoveDown(int[] p, int idx) {
        return (p[idx - 1] < p[idx]) ? true : false;
    }

    public void solve(BufferedReader br, BufferedWriter bw) throws IOException {
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] p = new int[n];
        for (int i = 0; i < p.length; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }

        int[] upArr = new int[n];
        int[] downArr = new int[n];
        Arrays.fill(upArr, 1);
        Arrays.fill(downArr, 1);

        int maxUpLength = 0;
        int maxUpCnt = 0;
        int upStart = -1;
        for (int i = 1; i < p.length; i++) {
            if (canMoveUp(p, i - 1)) {
                upArr[i] = upArr[i - 1] + 1;
                if (upArr[i] > maxUpLength) {
                    maxUpCnt = 1;
                    maxUpLength = upArr[i];
                    upStart = i - maxUpLength + 1;
                } else if (upArr[i] == maxUpLength) {
                    maxUpCnt++;
                }
            }
        }

        int maxDownLength = 0;
        int maxDownCnt = 0;
        int downStart = -1;
        for (int i = p.length - 2; i >= 0; i--) {
            if (canMoveDown(p, i + 1)) {
                downArr[i] = downArr[i + 1] + 1;
                if (downArr[i] > maxDownLength) {
                    maxDownCnt = 1;
                    maxDownLength = downArr[i];
                    downStart = i + maxDownLength - 1;
                } else if (downArr[i] == maxDownLength) {
                    maxDownCnt++;
                }
            }
        }

        if (maxUpCnt == 1 && maxDownCnt == 1 &&
                (maxUpLength == maxDownLength) &&
                (upStart == downStart) &&
                (maxUpLength % 2 == 1)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    public static void main(String[] args) throws IOException {
        D_LetsGoHiking p = new D_LetsGoHiking();
        p.solution();
    }
}
