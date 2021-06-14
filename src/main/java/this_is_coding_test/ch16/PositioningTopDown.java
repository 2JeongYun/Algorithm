package this_is_coding_test.ch16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PositioningTopDown {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] atk = new int[N + 1];
        int[][] cache = new int[N + 1][N + 1];

        st = new StringTokenizer(br.readLine());
        atk[0] = Integer.MAX_VALUE;
        for (int i = 1; i < N + 1; i++) {
            atk[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(N - findMax(atk, 1, 0, cache));
    }
    
    public int findMax(int[] atk, int i, int maxIdx, int[][] cache) {
        if (i >= atk.length) {
            return 0;
        }
        if (cache[i][maxIdx] != 0) {
            return cache[i][maxIdx];
        }
        
        int ret = 0;
        if (atk[i] >= atk[maxIdx]) {
            ret = findMax(atk, i + 1, maxIdx, cache);
        } else {
            int cand1 = findMax(atk, i + 1, i, cache) + 1;
            int cand2 = findMax(atk, i + 1, maxIdx, cache);
            ret = Integer.max(cand1, cand2);
        }

        cache[i][maxIdx] = ret;
        return ret;
    }
    
    public static void main(String[] args) throws IOException {
        PositioningTopDown p = new PositioningTopDown();
        p.solution();
    }
}
