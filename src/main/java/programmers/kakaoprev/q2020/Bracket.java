package programmers.kakaoprev.q2020;

public class Bracket {

    final int U = 0, V = 1;

    public String solution(String p) {
        return makeCorrectBracket(p);
    }

    private String makeCorrectBracket(String s) {
        if (s.equals(""))
            return "";

        StringBuffer sb = new StringBuffer();

        String[] uv = split(s);
        if (isCorrect(uv[U])) {
            sb.append(uv[U]).append(makeCorrectBracket(uv[V]));
        } else {
            sb.append("(").append(makeCorrectBracket(uv[V])).append(")");
            String u = process(uv[U]);
            sb.append(u);
        }

        return sb.toString();
    }

    private String process(String str) {
        StringBuffer u = new StringBuffer(str);
        u.deleteCharAt(u.length() - 1);
        u.deleteCharAt(0);
        for (int i = 0; i < u.length(); i++) {
            char ch = u.charAt(i);
            if (ch == '(') {
                u.setCharAt(i, ')');
            } else {
                u.setCharAt(i, '(');
            }
        }

        return u.toString();
    }

    private boolean isCorrect(String s) {
        int checker = 0;
        for (int i = 0; i < s.length(); i++) {
            if (checker < 0)
                return false;

            char cur = s.charAt(i);
            if (cur == '(')
                checker++;
            else
                checker--;
        }

        if (checker == 0)
            return true;
        else
            return false;
    }

    private String[] split(String s) {
        int checker = 0;
        String[] ret = new String[2];

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '(')
                checker++;
            else
                checker--;

            if (checker == 0) {
                ret[U] = s.substring(0, i + 1);
                ret[V] = s.substring(i + 1);
                return ret;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Bracket b = new Bracket();
        System.out.println(b.solution("()))((()"));
    }
}
