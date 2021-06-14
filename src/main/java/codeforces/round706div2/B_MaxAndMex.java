package codeforces.round706div2;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class B_MaxAndMex {
    final int MAX = 1000000001;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int TC = Integer.parseInt(br.readLine());
        for (int i = 0; i < TC; i++) {
            solve(br, bw);
        }

        br.close();
        bw.close();
    }

    public void solve(BufferedReader br, BufferedWriter bw) throws IOException {
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Set<Integer> set = new HashSet<>();

        int ans = 0;
        int max = -1;
        int mex = -1;
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            if (set.add(num)) {
                if (num > max) {
                    max = num;
                }
                ans++;
            }
        }
        for (int i = 0; i < MAX; i++) {
            if (!set.contains(i)) {
                mex = i;
                break;
            }
        }

        int prevRes = -1;
        for (int i = 0; i < k; i++) {
            int res = compute(mex, max);
            if (res == prevRes) {
                break;
            }
            if (res == max + 1) {
                ans += k - i;
                break;
            }

            if (set.add(res)) {
                if (res == mex) {
                    for (int j = mex + 1; j < MAX; j++) {
                        if (!set.contains(j)) {
                            mex = j;
                            break;
                        }
                    }
                }
                ans++;
            }
            prevRes = res;
        }

        bw.write(Integer.toString(ans));
        bw.newLine();
        bw.flush();
    }

    public int compute(int mex, int max) {
        if ((mex + max) % 2 == 1) {
            return (mex + max) / 2 + 1;
        } else {
            return (mex + max) / 2;
        }
    }

    public static void main(String[] args) throws IOException {
        B_MaxAndMex p = new B_MaxAndMex();
        p.solution();
    }
}
