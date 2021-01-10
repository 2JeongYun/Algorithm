package this_is_coding_test.ch13;

public class Bracket {
    public String solution(String p) {
        String answer = "";
        StringBuilder res;
        res = makeString(new StringBuilder(p));

        answer = res.toString();
        System.out.println(answer);
        return answer;
    }

    public StringBuilder makeString(StringBuilder w) {
        if (w.length() == 0) {
            return w;
        }
        StringBuilder u = new StringBuilder();
        StringBuilder v = new StringBuilder();
        int idx = 0;
        boolean correct = true;
        int leftCnt = 0;
        int rightCnt = 0;

        while (idx != w.length()) {
            if (w.charAt(idx) == '(') {
                leftCnt++;
            } else if (w.charAt(idx) == ')') {
                rightCnt++;
            }
            if (rightCnt > leftCnt) {
                correct = false;
            }
            if (leftCnt == rightCnt) {
                u.append(w.substring(0, idx + 1));
                v.append(w.substring(idx + 1, w.length()));
                break;
            }
            idx++;
        }

        if (correct) {
            StringBuilder res = u.append(makeString(v));
            return res;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append('(');
            sb.append(makeString(v));
            sb.append(')');
            u.deleteCharAt(u.length() - 1);
            u.deleteCharAt(0);
            for (int i = 0; i < u.length(); i++) {
                if (u.charAt(i) == '(') {
                    u.replace(i, i + 1, ")");
                } else if (u.charAt(i) == ')') {
                    u.replace(i, i + 1, "(");
                }
            }
            sb.append(u);
            return sb;
        }
    }

    public static void main(String[] args) {
        Bracket b = new Bracket();
        String p = "()))((()";
        b.solution(p);
    }
}
