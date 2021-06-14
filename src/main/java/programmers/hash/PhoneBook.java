package programmers.hash;

import java.util.Arrays;

public class PhoneBook {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);

        for (int i = 1; i < phone_book.length; i++) {
            String prev = phone_book[i - 1];
            String cur = phone_book[i];
            if (cur.length() > prev.length()) {
                cur = cur.substring(0, prev.length());

                if (prev.equals(cur)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PhoneBook p = new PhoneBook();
        System.out.println(p.solution(new String[] {"119", "97674223", "1195524421"}));
    }
}
