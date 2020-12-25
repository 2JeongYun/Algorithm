package this_is_coding_test.ch8;

import myutil.MyUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AntSoldier {
    int[] cache;
    int[] container;
    int n;

    public void doit() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        container = MyUtil.lineToIntArray(br.readLine());
        cache = new int[n + 1];
        System.out.println(getFoods(0));
    }

    private int getFoods(int num) {
        if (num >= n) {
            return 0;
        }
        if (cache[num] != 0) {
            return cache[num];
        }
        int ret = Integer.max(getFoods(num + 2) + container[num], getFoods(num + 1));
        cache[num] = ret;
        return ret;
    }

    public static void main(String[] args) throws IOException {
        AntSoldier as = new AntSoldier();
        as.doit();
    }
}
