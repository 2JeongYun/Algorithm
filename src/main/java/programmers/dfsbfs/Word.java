package programmers.dfsbfs;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

import static myutil.Util.print;

public class Word {

    public int solution(String begin, String target, String[] words) throws IOException {
        Queue<Integer> que = new LinkedList<>();
        int[] dist = new int[words.length];
        boolean[] check = new boolean[words.length];

        for (int i = 0; i < words.length; i++) {
            if (begin.equals(words)) {
                continue;
            }

            if (canChange(begin, words[i])) {
                que.add(i);
                check[i] = true;
                dist[i] = 1;
            }
        }

        while (que.isEmpty() == false) {
            int poll = que.poll();

            if (words[poll].equals(target)) {
                return dist[poll];
            }

            for (int i = 0; i < words.length; i++) {
                if (!check[i] && canChange(words[poll], words[i])) {
                    que.add(i);
                    check[i] = true;
                    dist[i] = dist[poll] + 1;
                }
            }
        }

        return 0;
    }

    public boolean canChange(String current, String next) throws IOException {
        for (int i = 0; i < current.length(); i++) {
            if (i == 0 && current.substring(1, current.length()).equals(next.substring(1, next.length()))) {
                return true;
            } else if (i == current.length() - 1 &&
                    current.substring(0, current.length() - 1).equals(next.substring(0, next.length() - 1))) {
                return true;
            } else {
                if (current.substring(0, i).equals(next.substring(0, i)) &&
                        current.substring(i + 1, current.length()).equals(next.substring(i + 1, next.length()))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        Word p = new Word();

        int t = 1;

        for (int i = 0; i < t; i++) {
            /*
             * Type var = getTypeArr[]
             * Type ...
             * ...
             * print(p.solution());
             */

            print(p.solution("hit", "cog", new String[] {"hot", "dot", "dog", "lot", "log"}));
        }
    }
}
