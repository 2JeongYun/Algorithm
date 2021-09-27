package programmers.kakaoprev.q2021;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NewId2021 {

    public String solution(String new_id) {
        StringBuffer sb = new StringBuffer(new_id);
        sb = step1(sb);
        sb = step2(sb);
        sb = step3(sb);
        sb = step4(sb);
        sb = step5(sb);
        sb = step6(sb);
        sb = step7(sb);

        System.out.println(sb.toString());
        return sb.toString();
    }

    private StringBuffer step1(StringBuffer sb) {
        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                int replaceCh = ch - 'A' + 'a';
                sb.setCharAt(i, (char) replaceCh);
            }
        }
        return sb;
    }

    private StringBuffer step2(StringBuffer sb) {
        Set<Character> validSet = new HashSet<>(Arrays.asList('-', '_', '.'));
        for (int c = 'a'; c <= 'z'; c++) {
            validSet.add((char) c);
        }
        for (int i = 0; i <= 9; i++) {
            validSet.add((char) (i + '0'));
        }

        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            if (!validSet.contains(ch)) {
                sb.deleteCharAt(i--);
            }
        }

        return sb;
    }

    private StringBuffer step3(StringBuffer sb) {
        if (sb.length() == 0)
            return sb;

        char prev = sb.charAt(0);
        for (int i = 1; i < sb.length(); i++) {
            char cur = sb.charAt(i);
            if (prev == '.' && cur == '.') {
                sb.deleteCharAt(i--);
            } else {
                prev = cur;
            }
        }

        return sb;
    }

    private StringBuffer step4(StringBuffer sb) {
        if (sb.length() == 0)
            return sb;

        if (sb.charAt(sb.length() - 1) == '.') {
            sb.deleteCharAt(sb.length() - 1);
        }
        if (sb.length() != 0 && sb.charAt(0) == '.') {
            sb.deleteCharAt(0);
        }
        return sb;
    }

    private StringBuffer step5(StringBuffer sb) {
        if (sb.length() == 0) {
            sb.append("a");
        }
        return sb;
    }

    private StringBuffer step6(StringBuffer sb) {
        if (sb.length() >= 16) {
            sb.delete(15, sb.length());
            if (sb.charAt(sb.length() - 1) == '.') {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return sb;
    }

    private StringBuffer step7(StringBuffer sb) {
        if (sb.length() <= 2) {
            char lastCh = sb.charAt(sb.length() - 1);
            while (sb.length() < 3) {
                sb.append(lastCh);
            }
        }
        return sb;
    }

    public static void main(String[] args) {
        NewId2021 n = new NewId2021();
        n.solution("abcdefghijklmn.p");
    }
}
