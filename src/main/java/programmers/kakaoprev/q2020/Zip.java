package programmers.kakaoprev.q2020;

public class Zip {

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
            int dupCnt = getDuplicationCount(s.substring(idx + targetLength, s.length()), match);

            if (dupCnt == 0) {
                idx++;
            } else {
                idx += (targetLength * dupCnt);
                reduce += (targetLength * dupCnt) - 1;
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
        Zip z = new Zip();
        System.out.println(z.solution("aabbaccc"));
        System.out.println(z.solution("ababcdcdababcdcd"));
        System.out.println(z.solution("abcabcdede"));
        System.out.println(z.solution("abcabcabcabcdededededede"));
        System.out.println(z.solution("xababcdcdababcdcd"));
    }
}
