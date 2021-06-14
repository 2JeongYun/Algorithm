package this_is_coding_test.ch8;

import myutil.MyUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinCoin {
    int n;
    int price;
    int[] coins;
    int[] cache;
    boolean check = false;

    public void doit() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input[] = MyUtil.lineToIntArray(br.readLine());
        n = input[0];
        price = input[1];
        coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        cache = new int[price + 1];
        int answer = addCoin(0);
        if (check) {
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }
    }

    private int addCoin(int value) {
        if (value == price) {
            check = true;
            return 0;
        } else if (value > price) {
            return Integer.MIN_VALUE;
        }

        if (cache[value] != 0) {
            return cache[value];
        }

        int ret = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int temp = addCoin(value + coins[i]) + 1;
            if (temp > 0) {
                ret = Integer.min(ret, temp);
            }
        }

        cache[value] = ret;
        return ret;
    }

    public static void main(String[] args) throws IOException {
        MinCoin mc = new MinCoin();
        mc.doit();
    }
}
