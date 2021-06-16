package baekjoon.bruteforce;

import java.io.*;
import java.util.StringTokenizer;

public class BlackJack {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        final int N = Integer.valueOf(st.nextToken());
        final int M = Integer.valueOf(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] cards = new int[N];
        for (int i = 0; i < N; i++)
            cards[i] = Integer.valueOf(st.nextToken());

        int max = -1;
        for (int i = 0; i < cards.length - 2; i++) {
            for (int j = 1; j < cards.length - 1; j++) {
                if (j == i)
                    continue;
                for (int k = 2; k < cards.length; k++) {
                    if (k == j || k == i)
                        continue;
                    int sum = cards[i] + cards[j] + cards[k];
                    if (sum <= M &&
                            sum > max) {
                        max = sum;
                    }
                }
            }
        }
        bw.write(Integer.toString(max));
        bw.flush();
    }
}
