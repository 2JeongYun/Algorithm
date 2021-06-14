package codeforces.round708div2;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class C2_kLCM {
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());

        if ((n % 2 == 0 && k % 2 == 0) || (n % 2 == 1 && k % 2 == 1)) {
            int oneCnt = k - 2;
            n -= oneCnt;
            for (int i = 0; i < oneCnt; i++) {
                bw.write("1 ");
            }
            bw.write(String.format("%d %d\n", n / 2, n / 2));
        } else {
            int[][] cache = new int[2][2];
            ArrayList<Integer> res = new ArrayList<>();

            if (n % 2 == 1) {
                n--;
                k--;
                res.add(1);
                updateCache(cache, n, k);
            }

            while (true) {
                if (k == 2) {
                    if ((n / 2) % 2 == 1) {
                        n = cache[1][0];
                        k = cache[1][1];
                    } else {

                    }
                }

                if ((n / 2) % 2 == 1) {
                    n -= 2;
                    k--;
                    res.add(2);
                }
            }
        }
        bw.flush();
    }

    public void updateCache(int[][] cache, int n, int k) {
        cache[1] = cache[0];
        cache[0][0] = n;
        cache[0][1] = k;
    }

    public static void main(String[] args) throws IOException {
        C2_kLCM p = new C2_kLCM();
        p.solution();
    }
}
