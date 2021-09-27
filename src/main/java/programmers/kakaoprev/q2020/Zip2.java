package programmers.kakaoprev.q2020;

public class Zip2 {

    public int solution(String s) {
        int maxReduce = 0;

        for (int targetLength = 1; targetLength <= s.length() / 2; targetLength++) {
            maxReduce = Integer.max(maxReduce, getMaxReduce(s, targetLength));
        }

        return s.length() - maxReduce;
    }

    private int getMaxReduce(String s, int targetLength) {
        int idx = 0;
        int reduce = 0;

        while (idx + targetLength <= s.length()) {
            String match = s.substring(idx, idx + targetLength);
            int dupCnt = getDuplicationCount(s.substring(idx + targetLength), match);

            if (dupCnt == 0) {
                idx += targetLength;
            } else {
                idx += targetLength * dupCnt;
                reduce += targetLength * dupCnt;

                int minus = 1;
                dupCnt++;
                while (dupCnt >= 10) {
                    dupCnt /= 10;
                    minus++;
                }
                reduce -= minus;
            }
        }

        if (reduce == -1);
        return reduce;
    }

    private int getDuplicationCount(String s, String match) {
        int idx = 0, ret = 0;
        while (idx + match.length() <= s.length()) {
            String cur = s.substring(idx, idx + match.length());
            if (match.equals(cur)) {
                ret++;
                idx += match.length();
            } else {
                return ret;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Zip2 z = new Zip2();
        System.out.println(z.solution("aaaaaaaaaa"));
        System.out.println(z.solution("ababcdcdababcdcd"));
        System.out.println(z.solution("abcabcdede"));
        System.out.println(z.solution("abcabcabcabcdededededede"));
        System.out.println(z.solution("xababcdcdababcdcd"));
    }
}
