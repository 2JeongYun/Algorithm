package this_is_coding_test.ch14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Antenna {
    public static void main(String[] args) throws IOException {
        Antenna a = new Antenna();
        a.solution();
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] house = new int[n];
        for (int i = 0; i < n; i++) {
            house[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(house);
        System.out.println(house[(n - 1) / 2]);
    }
}
