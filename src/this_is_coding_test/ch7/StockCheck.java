package this_is_coding_test.ch7;

import myutil.MyUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class StockCheck {
    int n, m;
    int[] arrN;
    int[] arrM;

    public void doit() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arrN = MyUtil.lineToIntArray(br.readLine());
        m = Integer.parseInt(br.readLine());
        arrM = MyUtil.lineToIntArray(br.readLine());

        Arrays.sort(arrN);
        Arrays.sort(arrM);

        for (int request : arrM) {
            int goodsIdx = MyUtil.binarySearch(request, arrN, 0, n - 1);
            if (goodsIdx != -1) {
                System.out.print("yes ");
            } else {
                System.out.print("no ");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        StockCheck sc = new StockCheck();
        sc.doit();
    }
}
