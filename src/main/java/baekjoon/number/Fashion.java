package baekjoon.number;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Fashion {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private void solution() throws IOException {
        final int TC = Integer.valueOf(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < TC; i++) {
            int n = Integer.valueOf(br.readLine());
            Map<String, Integer> map = new HashMap<>();

            int ans = 1;
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                String type = st.nextToken();
                map.put(type, map.getOrDefault(type, 0) + 1);
            }
            for (int cnt : map.values()) {
                ans *= (cnt + 1);
            }
            sb.append(ans - 1).append("\n");
        }
        bw.write(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        Fashion sol = new Fashion();
        sol.solution();

        bw.flush();
        bw.close();
        br.close();
    }
}
