package this_is_coding_test.ch7;

import myutil.MyUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RiceCakeMaking {
    int n, m;
    int[] riceCake;

    public void doit() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = MyUtil.lineToIntArray(br.readLine());
        n = input[0];
        m = input[1];
        riceCake = MyUtil.lineToIntArray(br.readLine());
        Arrays.sort(riceCake);

        System.out.println(cut(m, riceCake, 0, riceCake[n - 1]));
    }

    private int cut(int value, int[] arr, int start, int end) {
        if (start == end) {
            return start;
        }
        int mid = (start + end) / 2;
        if (value == getRiceCakeLength(mid, arr)) {
            return mid;
        } else if (value > getRiceCakeLength(mid, arr)) {
            return cut(value, arr, start, mid - 1);
        } else {
            return cut(value, arr, mid + 1, end);
        }
    }

    private int getRiceCakeLength(int cutValue, int[] arr) {
        int ret = 0;
        for (int i : arr) {
            ret += (i - cutValue < 0) ? 0 : i - cutValue;
        }
        return ret;
    }

    public static void main(String[] args) throws IOException {
        RiceCakeMaking rc = new RiceCakeMaking();
        rc.doit();
    }
}
