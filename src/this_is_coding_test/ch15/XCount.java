package this_is_coding_test.ch15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class XCount {

    public static void main(String[] args) throws IOException {
        XCount x = new XCount();
        x.solution();
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lowIdx = lowSearch(arr, 0, N - 1, x);
        int highIdx = higherSearch(arr, 0, N - 1, x);
        if (arr[lowIdx] != x) {
            System.out.println(-1);
        } else {
            if (arr[highIdx] == x) {
                highIdx++;
            }
            System.out.println(highIdx - lowIdx);
        }
        System.out.printf("%d %d\n", lowIdx, highIdx);
    }

    public int lowSearch(int[] arr, int s, int e, int x) {
        if (s == e) {
            return s;
        }
        int mid = (s + e) / 2;
        if (arr[mid] < x) {
            return lowSearch(arr, mid + 1, e, x);
        } else {
            return lowSearch(arr, s, mid, x);
        }
    }

    public int higherSearch(int[] arr, int s, int e, int x) {
        if (s == e) {
            return s;
        }
        int mid = (s + e) / 2;

        if (arr[mid] > x) {
            return higherSearch(arr, s, mid, x);
        } else {
            return higherSearch(arr, mid + 1, e, x);
        }
    }
}
