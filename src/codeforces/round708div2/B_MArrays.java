package codeforces.round708div2;

import java.io.*;
import java.util.*;

public class B_MArrays {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            solve(br, bw);
        }

        br.close();
        bw.close();
    }

    public void solve(BufferedReader br, BufferedWriter bw) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Integer> arr = new ArrayList<>();
        int ans = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int cur = Integer.parseInt(st.nextToken());
            if (cur % m == 0) {
                ans = 1;
            } else {
                arr.add(cur % m);
            }
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int key : map.keySet()) {
            int a = map.get(key);
            if (a == 0) {
                continue;
            }

            int b = map.getOrDefault(m - key, 0);
            if (a > 0 && b > 0) {
                if (key * 2 == m) {
                    ans++;
                    map.put(key, 0);
                    continue;
                }
                if (a > b) {
                    ans += a - b;
                } else if (b > a) {
                    ans += b - a;
                } else {
                    ans++;
                }
                map.put(key, 0);
                map.put(m - key, 0);
            } else {
                ans += a;
                map.put(key, 0);
            }
        }

        bw.write(Integer.toString(ans));
        bw.newLine();
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        B_MArrays p = new B_MArrays();
        p.solution();
    }
}
