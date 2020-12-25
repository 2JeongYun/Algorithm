package this_is_coding_test.ch8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tiling { 
    int n;
    int[] cache;

    public void doit() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        cache = new int[n + 1];
        System.out.println(getTiling(0));
    }

    private int getTiling(int seqNum) {
        if (seqNum == n) {
            return 1;
        } else if (seqNum > n) {
            return 0;
        }

        if (cache[seqNum] != 0) {
            return cache[seqNum];
        }

        int ret = 0;
        ret += getTiling(seqNum + 1);
        ret %= 796796;
        ret += getTiling(seqNum + 2) * 2;
        ret %= 796796;
        cache[seqNum] = ret;

        return ret;
    }

    public static void main(String[] args) throws IOException {
        Tiling tiling = new Tiling();
        tiling.doit();
    }
}
