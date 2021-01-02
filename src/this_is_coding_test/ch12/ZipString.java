package this_is_coding_test.ch12;

public class ZipString {
    public int solution(String s) {
        int answer = 0;
        answer = s.length();
        for (int i = 1; i <= s.length() / 2; i++) {
            answer = Integer.min(answer, getZipLength(s, i));
        }
        System.out.println(answer);
        return answer;
    }

    public int getZipLength(String s, int r) {
        String prev = "-1";
        int dup = 0;
        int dupMinus = 0;
        int ret = s.length();

        for (int i = 0; i < s.length(); i = i + r) {
            String substring;
            if (i + r <= s.length()) {
                substring = s.substring(i, i + r);
            } else {
                break;
            }
            if (prev.equals(substring)) {
                ret -= r;
                dup++;
                if (Math.pow(10, dupMinus) - 1 <= dup) {
                    dupMinus++;
                    ret += 1;
                }
            } else {
                dup = 0;
                dupMinus = 0;
            }
            prev = substring;
        }
        return ret;
    }

    public static void main(String[] args) {
        ZipString zs = new ZipString();
        String s = "aaaaaaaaaa";
        zs.solution(s);
    }
}
