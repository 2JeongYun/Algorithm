package myutil;

public class KMP {

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
