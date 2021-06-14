package this_is_coding_test.ch16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ResignTopDown {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] T;
        int[] P;
        int[] cache;

        int N = Integer.parseInt(br.readLine());
        T = new int[N];
        P = new int[N];
        cache = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(findMax(T, P, 0, cache));
    }

    public int findMax(int[] T, int[] P, int day, int[] cache) {
        if (day >= T.length) {
            return 0;
        }
        if (cache[day] != 0) {
            return cache[day];
        }

        int ret = 0;
        if (day + T[day] > T.length) {
            ret = findMax(T, P, day + 1, cache);
        } else {
            ret = Integer.max(findMax(T, P, day + T[day], cache) + P[day],
                    findMax(T, P, day + 1, cache));
        }
        cache[day] = ret;
        return ret;
    }

    public static void main(String[] args) throws IOException {
        ResignTopDown r = new ResignTopDown();
        r.solution();
    }
}
