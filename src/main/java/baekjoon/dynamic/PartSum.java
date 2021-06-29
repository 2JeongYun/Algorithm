package baekjoon.dynamic;

import java.io.*;
import java.util.StringTokenizer;

public class PartSum {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private void solution() throws IOException {
        final int N = Integer.valueOf(br.readLine());
        int maxSum = 0, tempSum = 0;
        int maxVal = Integer.MIN_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean isAllMinus = true;
        for (int i = 0; i < N; i++) {
            int cur = Integer.valueOf(st.nextToken());
            maxVal = Integer.max(maxVal, cur);

            if (cur + tempSum < 0) {
                tempSum = 0;
                continue;
            }
            tempSum += cur;
            maxSum = Integer.max(maxSum, tempSum);
            isAllMinus = false;
        }

        if (isAllMinus)
            maxSum = maxVal;
        bw.write(String.valueOf(maxSum));
    }

    public static void main(String[] args) throws IOException {
        PartSum sol = new PartSum();
        sol.solution();

        bw.flush();
        bw.close();
        br.close();
    }
}
