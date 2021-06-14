package this_is_coding_test.ch15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Router {
    public static void main(String[] args) throws IOException {
        Router r = new Router();
        r.solution();
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] home = new int[N];

        for (int i = 0; i < N; i++) {
            home[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(home);

        int minDistance = getMinDistance(home, 1, 1000000000, C);
        if (check(home, minDistance, C)) {
            System.out.println(minDistance);
        } else {
            System.out.println(minDistance - 1);
        }
        br.close();
    }

    public int getMinDistance(int[] home, int s, int e, int wifiCount) {
        if (s == e) {
            return s;
        }

        int distance = (s + e) / 2;
        if (check(home, distance, wifiCount)) {
            return getMinDistance(home, distance + 1, e, wifiCount);
        } else {
            return getMinDistance(home, s, distance, wifiCount);
        }
    }

    public boolean check(int[] home, int minDistance, int wifiCount) {
        wifiCount -= 1;
        int idx = 1;
        int prev = home[0];

        while (wifiCount > 0 && idx < home.length) {
            if (home[idx] - prev >= minDistance) {
                prev = home[idx];
                wifiCount--;
            }
            idx++;
        }

        if (wifiCount > 0) {
            return false;
        } else {
            return true;
        }
    }
}
