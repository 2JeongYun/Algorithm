package programmers.dynamic;

import static myutil.Util.*;
import java.util.*;

import myutil.Util;

public class ChangeToN {

    public int solution(int N, int number) {
        Set<Integer>[] setArr = new HashSet[9];
        setArr[0] = new HashSet<>();
        setArr[1] = new HashSet<>();
        setArr[1].add(N);

        if (N == number) {
            return 1;
        }

        for (int depth = 2; depth <= 8; depth++) {
            setArr[depth] = new HashSet<>();
            int dup = N;
            for (int i = 1; i < depth; i++) {
                dup = dup * 10 + N;
            }
            setArr[depth].add(dup);

            for (int set1 = 1; set1 <= depth / 2; set1++) {
                combineSet(setArr[set1], setArr[depth - set1], setArr[depth], setArr[0]);
            }

            if (setArr[depth].contains(number)) {
                return depth;
            }
        }

        return -1;
    }

    public void combineSet(Set<Integer> set1, Set<Integer> set2, Set<Integer> result, Set<Integer> all) {
        for (int n1 : set1) {
            for (int n2 : set2) {
                add(all, n1 + n2, result);
                add(all, n1 * n2, result);
                add(all, n1 - n2, result);
                add(all, n2 - n1, result);
                if (n1 != 0) {
                    add(all,n2 / n1, result);
                }
                if (n2 != 0) {
                    add(all,n1 / n2, result);
                }
            }
        }
    }

    public void add(Set<Integer> all, int val, Set<Integer> result) {
        if (val < 0 || val > 32000 || all.contains(val)) {
            return;
        } else {
            result.add(val);
            all.add(val);
        }
    }

    public static void main(String[] args) {
        ChangeToN p = new ChangeToN();

        int t = 1;
        t = getTestCaseCount();

        for (int i = 0; i < t; i++) {
            /*
             * Type var = getTypeArr[]
             * Type ...
             * ...
             * print(p.solution());
             */
            print(p.solution(getInt(), getInt()));
        }

        Util.closeUtil();
    }
}
