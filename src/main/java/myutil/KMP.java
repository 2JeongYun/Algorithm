package myutil;

import java.util.ArrayList;

public class KMP {

    public ArrayList<Integer> search(String source, String pattern) {
        int baseIdx = 0;
        int matchIdx = 0;
        int[] table = makeTable(pattern);
        ArrayList<Integer> ret = new ArrayList<>();

        while (baseIdx <= source.length() - pattern.length()) {
            char sourceCh = source.charAt(baseIdx + matchIdx);
            char patternCh = pattern.charAt(matchIdx);

            if (sourceCh == patternCh) {
                matchIdx++;
                if (matchIdx == pattern.length()) {
                    ret.add(baseIdx);
                    baseIdx = baseIdx + matchIdx;
                    matchIdx = 0;
                }
            } else {
                if (matchIdx == 0)
                    baseIdx++;
                else {
                    baseIdx += matchIdx - table[matchIdx - 1];
                    matchIdx = table[matchIdx - 1];
                }
            }
        }

        return ret;
    }

    public int[] makeTable(String input) {
        int[] table = new int[input.length()];
        int frontIdx = 0;

        for (int rearIdx = 1; rearIdx < input.length(); rearIdx++) {
            char cur = input.charAt(rearIdx);
            if (input.charAt(frontIdx) == cur) {
                frontIdx++;
                table[rearIdx] = table[rearIdx - 1] + 1;
            } else {
                if (input.charAt(0) == cur) {
                    frontIdx = 1;
                    table[rearIdx] = 1;
                } else {
                    frontIdx = 0;
                    table[rearIdx] = 0;
                }
            }
        }

        return table;
    }
}
