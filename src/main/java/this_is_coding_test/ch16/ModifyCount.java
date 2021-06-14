package this_is_coding_test.ch16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ModifyCount {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String strA = br.readLine();
        String strB = br.readLine();
        int[][] cache = new int[strA.length()][strB.length()];

        System.out.println(makeSame(strA, strB, 0, 0, cache));
    }

    public int makeSame(String strA, String strB, int idxA, int idxB, int[][] cache) {
        if (idxA == strA.length() && idxB == strB.length()) {
            return 0;
        } else if (idxA == strA.length()) {
            return strB.length() - idxB;
        } else if (idxB == strB.length()) {
            return strA.length() - idxA;
        }

        if (cache[idxA][idxB] != 0) {
            return cache[idxA][idxB];
        }

        int ret;
        if (strA.charAt(idxA) == strB.charAt(idxB)) {
            ret = makeSame(strA, strB, idxA + 1, idxB + 1, cache);
        } else {
            ret = 1 + Integer.min(makeSame(strA, strB, idxA + 1, idxB + 1, cache),
                    makeSame(strA, strB, idxA + 1, idxB, cache));
            ret = Integer.min(ret, makeSame(strA, strB, idxA, idxB + 1, cache) + 1);
        }

        cache[idxA][idxB] = ret;
        return ret;
    }

    public static void main(String[] args) throws IOException {
        ModifyCount m = new ModifyCount();
        m.solution();
    }
}
