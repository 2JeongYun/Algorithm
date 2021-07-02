package baekjoon.greedy;

import java.io.*;
import java.util.StringTokenizer;

public class GasStation {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private void solution() throws IOException {
        final int N = Integer.valueOf(br.readLine());
        int[] distances = new int[N - 1];
        int[] prices = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < distances.length; i++) {
            distances[i] = Integer.valueOf(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < prices.length; i++) {
            prices[i] = Integer.valueOf(st.nextToken());
        }

        long totalPrice = 0;
        long distance = 0;

        int prevPrice = prices[0];
        for (int i = 1; i < N; i++) {
            distance += distances[i - 1];
            if (prevPrice < prices[i])
                continue;
            totalPrice += prevPrice * distance;
            distance = 0;
            prevPrice = prices[i];
        }

        totalPrice += prevPrice * distance;
        bw.write(String.valueOf(totalPrice));
    }

    public static void main(String[] args) throws IOException {
        GasStation sol = new GasStation();
        sol.solution();

        bw.flush();
        bw.close();
        br.close();
    }
}
