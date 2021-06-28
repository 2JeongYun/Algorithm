package baekjoon.dynamic;

import java.io.*;
import java.util.Arrays;

public class LcsRecursive {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private void solution() throws IOException {
        String a = br.readLine();
        String b = br.readLine();

        int[][] cache = new int[a.length()][b.length()];
        for (int i = 0; i < cache.length; i++) {
            Arrays.fill(cache[i], -1);
        }
        int ans = findLcs(a, b, 0, 0, cache);
        bw.write(String.valueOf(ans));
    }

    private int findLcs(String a, String b, int aIdx, int bIdx, int[][] cache) {
        if (aIdx == a.length() || bIdx == b.length())
            return 0;

        if (cache[aIdx][bIdx] != -1)
            return cache[aIdx][bIdx];

        int ret = 0;
        char curA = a.charAt(aIdx);
        for (int nextB = bIdx; nextB < b.length(); nextB++) {
            char curB = b.charAt(nextB);
            if (curA == curB) {
                ret = findLcs(a, b, aIdx + 1, nextB + 1, cache) + 1;
                break;
            }
        }
        ret = Integer.max(ret, findLcs(a, b, aIdx + 1, bIdx, cache));
        cache[aIdx][bIdx] = ret;
        return ret;
    }

    public static void main(String[] args) throws IOException {
        LcsRecursive sol = new LcsRecursive();
        sol.solution();

        bw.flush();
        bw.close();
        br.close();
    }
}
