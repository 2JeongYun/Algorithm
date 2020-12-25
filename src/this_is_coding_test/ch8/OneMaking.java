package this_is_coding_test.ch8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class OneMaking {
    int[] cache;

    public void doit() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());

        cache = new int[x + 1];

        System.out.println(decrease(x));
    }

    private int decrease(int num) {
        int ret = 0;
        if (num == 1) {
            return ret;
        }
        if (cache[num] != 0) {
            return cache[num];
        }

        int min = Integer.MAX_VALUE;

        if (num % 5 == 0) {
            if (min > decrease(num / 5) + 1) {
                min = decrease(num / 5) + 1;
            }
        } else if (num % 3 == 0) {
            if (min > decrease(num / 3) + 1) {
                min = decrease(num / 3) + 1;
            }
        } else if (num % 2 == 0) {
            if (min > decrease(num / 2) + 1) {
                min = decrease(num / 2) + 1;
            }
        } else {
            if (min > decrease(num - 1) + 1) {
                min = decrease(num - 1) + 1;
            }
        }

        cache[num] = min;
        return min;
    }

    public static void main(String[] args) throws IOException {
        OneMaking om = new OneMaking();
        om.doit();
    }
}
