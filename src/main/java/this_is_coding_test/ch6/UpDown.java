package this_is_coding_test.ch6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class UpDown {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        int n = Integer.parseInt(line);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            line = br.readLine();
            arr[i] = Integer.parseInt(line);
        }

        Arrays.sort(arr);
        Collections.reverse(Arrays.asList(arr));
        System.out.println(Arrays.toString(arr));
    }
}
