//package codeforces.eduRound106;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class C {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            solve(br, bw);
        }

        br.close();
        bw.close();
    }

    public void solve(BufferedReader br, BufferedWriter bw) throws IOException {
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        Long[] arr = new Long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Long rMin = Long.MAX_VALUE;
        Long rSum = 0L;
        Long rMinSum = Long.MAX_VALUE;
        Long uMin = Long.MAX_VALUE;
        Long uSum = 0L;
        Long uMinSum = Long.MAX_VALUE;
        Long minSum = Long.MAX_VALUE;
        boolean rTurn = true;
        int r = 0;
        int u = 0;
        for (int i = 0; i < n; i++) {
            if (rTurn) {
                if (arr[i] < rMin) {
                    rMin = arr[i];
                    rMinSum = rSum + (n - r) * rMin;
                } else {
                    rMinSum = rMinSum - rMin + arr[i];
                }
                r++;
                rSum += arr[i];
                rTurn = false;
            } else {
                if (arr[i] < uMin) {
                    uMin = arr[i];
                    uMinSum = uSum + (n - u) * uMin;
                } else {
                    uMinSum = uMinSum - uMin + arr[i];
                }
                u++;
                uSum += arr[i];
                rTurn = true;
            }
            if (rMinSum != Long.MAX_VALUE && uMinSum != Long.MAX_VALUE) {
                minSum = Long.min(rMinSum + uMinSum, minSum);
            }
        }
        bw.write(String.format("%d\n", minSum));
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        C p = new C();
        p.solution();
    }
}
