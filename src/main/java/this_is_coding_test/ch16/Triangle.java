package this_is_coding_test.ch16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Triangle {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int maxDepth = Integer.parseInt(br.readLine());
        int[][] triangle = new int[maxDepth][];
        int[][] cache = new int[maxDepth][];

        for (int depth = 0; depth < maxDepth; depth++) {
            triangle[depth] = new int[depth + 1];
            cache[depth] = new int[depth + 1];

            st = new StringTokenizer(br.readLine());
            int idx = 0;
            while (st.hasMoreTokens()) {
                triangle[depth][idx++] = Integer.parseInt(st.nextToken());
            }
        }

        for (int depth = 0; depth < maxDepth; depth++) {
            for (int idx = 0; idx < depth + 1; idx++) {
                if (depth == 0) {
                    cache[depth][idx] = triangle[depth][idx];
                    continue;
                }
                if (idx - 1 < 0) {
                    cache[depth][idx] = cache[depth - 1][idx];
                } else if (idx == cache[depth].length - 1) {
                    cache[depth][idx] = cache[depth - 1][idx - 1];
                } else {
                    cache[depth][idx] = Integer.max(cache[depth - 1][idx - 1], cache[depth - 1][idx]);
                }
                cache[depth][idx] += triangle[depth][idx];
            }
        }

        int ans = 0;
        for (int i = 0; i < cache[maxDepth - 1].length; i++) {
            ans = Integer.max(ans, cache[maxDepth - 1][i]);
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        Triangle t = new Triangle();
        t.solution();
    }
}
