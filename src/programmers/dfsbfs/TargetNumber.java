package programmers.dfsbfs;

import static programmers.Util.*;

import java.io.IOException;
import java.util.*;

public class TargetNumber {

    public int solution(int[] numbers, int target) {
        return makeTarget(numbers, 0, 0, target);
    }

    public int makeTarget(int[] arr, int idx, int val, int target) {
        if (idx == arr.length) {
            if (val == target) {
                return 1;
            } else {
                return 0;
            }
        }

        return makeTarget(arr, idx + 1, val + arr[idx], target) +
                makeTarget(arr, idx + 1, val - arr[idx], target);
    }

    public static void main(String[] args) throws IOException {
        TargetNumber p = new TargetNumber();

        int t = 1;
        //t = getTestCaseCount();

        for (int i = 0; i < t; i++) {
            /*
             * Type var = getTypeArr[]
             * Type ...
             * ...
             * print(p.solution());
             */
            print(p.solution(getIntArray(), getInt()));
        }
    }
}
