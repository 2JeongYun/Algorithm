package this_is_coding_test.ch6;

import myutil.MyUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaxSum {
    public void doit() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = MyUtil.lineToIntArray(br.readLine());
        int n = input[0];
        int k = input[1];
        int[] arrA = MyUtil.lineToIntArray(br.readLine());
        int[] arrB = MyUtil.lineToIntArray(br.readLine());

        Arrays.sort(arrA);
        Arrays.sort(arrB);

        for (int i = 0; i < k; i++) {
            arrA[i] = arrB[n - 1 - i];
        }

        int total = 0;
        for (int i : arrA) {
            total += i;
        }
        System.out.println(total);
    }

    public static void main(String[] args) throws IOException {
        MaxSum ms = new MaxSum();
        ms.doit();
    }
}
