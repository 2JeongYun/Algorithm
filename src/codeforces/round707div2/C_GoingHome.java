package codeforces.round707div2;

import java.io.*;
import java.util.*;

public class C_GoingHome {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve(br, bw);

        br.close();
        bw.close();
    }

    public void solve(BufferedReader br, BufferedWriter bw) throws IOException {
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        HashMap<Integer, Pair> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int sum = arr[i] + arr[j];
                if (map.containsKey(sum)) {
                    Pair pair = map.get(sum);
                    if (!pair.isDuplicate(i) && !pair.isDuplicate(j)) {
                        bw.write(String.format("YES\n%d %d %d %d",
                                i + 1, j + 1, pair.aIdx + 1, pair.bIdx + 1));
                        bw.flush();
                        return;
                    }
                } else {
                    map.put(sum, new Pair(i, j));
                }
            }
        }
        bw.write("NO");
        bw.flush();
        return;
    }

    class Pair {
        int aIdx;
        int bIdx;

        Pair(int aIdx, int bIdx) {
            this.aIdx = aIdx;
            this.bIdx = bIdx;
        }

        public boolean isDuplicate(int idx) {
            return (aIdx == idx || bIdx == idx) ? true : false;
        }
    }

    public static void main(String[] args) throws IOException {
        C_GoingHome p = new C_GoingHome();
        p.solution();
    }
}
