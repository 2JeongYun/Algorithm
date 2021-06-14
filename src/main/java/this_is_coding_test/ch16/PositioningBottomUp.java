package this_is_coding_test.ch16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class PositioningBottomUp {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> atk = new ArrayList<>();
        int[] dp = new int[N + 1];
        Arrays.fill(dp, 1);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            atk.add(Integer.parseInt(st.nextToken()));
        }
        Collections.reverse(atk);
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (atk.get(i) > atk.get(j)) {
                    dp[i] = Integer.max(dp[j] + 1, dp[i]);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Integer.max(max, dp[i]);
        }
        System.out.println(N - max);
    }

    public static void main(String[] args) throws IOException {
        PositioningBottomUp p = new PositioningBottomUp();
        p.solution();
    }
}
