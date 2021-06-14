package this_is_coding_test.ch15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FixedPoint {
    public static void main(String[] args) throws IOException {
        FixedPoint f = new FixedPoint();
        f.solution();
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(search(arr, 0, N - 1));
    }

    public int search(int[] arr, int s, int e) {
        int midIdx = (s + e) / 2;

        if (arr[midIdx] == midIdx) {
            return midIdx;
        }

        if (s == e) {
            return -1;
        }

        if (arr[midIdx] < midIdx) {
            return search(arr, midIdx + 1, e);
        } else {
            return search(arr, s, midIdx);
        }
    }
}
