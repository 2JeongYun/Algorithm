package baekjoon.number;

import java.io.*;
import java.util.StringTokenizer;

public class Combination0 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private void solution() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.valueOf(st.nextToken());
        int r = Integer.valueOf(st.nextToken());

        int fiveCnt = getCount(n, 5) - getCount(r, 5) - getCount(n - r, 5);
        int twoCnt = getCount(n, 2) - getCount(r, 2) - getCount(n - r, 2);

        bw.write(String.valueOf(Integer.min(fiveCnt, twoCnt)));
    }

    private int getCount(int n, int target) {
        int ret = 0;
        while (n >= target) {
            ret += n / target;
            n /= target;
        }
        return ret;
    }

    public static void main(String[] args) throws IOException {
        Combination0 sol = new Combination0();
        sol.solution();

        bw.flush();
        bw.close();
        br.close();
    }
}
