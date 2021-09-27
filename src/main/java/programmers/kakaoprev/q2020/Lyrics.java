package programmers.kakaoprev.q2020;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Lyrics {

    public int[] solution(String[] words, String[] queries) {
        TrieNode lastQMark = new TrieNode();
        TrieNode firstQMark = new TrieNode();

        for (String word : words) {
            lastQMark.add(word);
            firstQMark.addReverse(word);
        }

        int[] ret = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (queries[i].charAt(0) == '?') {
                ret[i] = firstQMark.queryReverse(queries[i]);
            } else {
                ret[i] = lastQMark.query(queries[i]);
            }
        }

        return ret;
    }

    static class TrieNode {
        TrieNode[] next = new TrieNode[26];
        Map<Integer, Integer> countMap = new HashMap<>();

        public void add(String s) {
            countMap.put(s.length(), countMap.getOrDefault(s.length(), 0) + 1);
            TrieNode curNode = this;
            for (int i = 0; i < s.length(); i++) {
                int curCh = s.charAt(i) - 'a';
                if (curNode.next[curCh] == null) {
                    curNode.next[curCh] = new TrieNode();
                }
                curNode = curNode.next[curCh];
                curNode.countMap.put(s.length(), curNode.countMap.getOrDefault(s.length(), 0) + 1);
            }
        }

        public void addReverse(String s) {
            countMap.put(s.length(), countMap.getOrDefault(s.length(), 0) + 1);
            TrieNode curNode = this;
            for (int i = s.length() - 1; i >= 0; i--) {
                int curCh = s.charAt(i) - 'a';
                if (curNode.next[curCh] == null) {
                    curNode.next[curCh] = new TrieNode();
                }
                curNode = curNode.next[curCh];
                curNode.countMap.put(s.length(), curNode.countMap.getOrDefault(s.length(), 0) + 1);
            }
        }

        public int query(String s) {
            TrieNode curNode = this;

            for (int i = 0; i < s.length(); i++) {
                char curCh = s.charAt(i);
                if (curCh == '?') {
                    return curNode.countMap.getOrDefault(s.length(), 0);
                }
                if (curNode.next[curCh - 'a'] == null) {
                    return 0;
                }
                curNode = curNode.next[curCh - 'a'];
            }

            return 0;
        }

        public int queryReverse(String s) {
            TrieNode curNode = this;

            for (int i = s.length() - 1; i >= 0; i--) {
                char curCh = s.charAt(i);
                if (curCh == '?') {
                    return curNode.countMap.getOrDefault(s.length(), 0);
                }
                if (curNode.next[curCh - 'a'] == null) {
                    return 0;
                }
                curNode = curNode.next[curCh - 'a'];
            }

            return 0;
        }
    }

    public static void main(String[] args) {
        Lyrics l = new Lyrics();
        System.out.println(Arrays.toString(l.solution(new String[]{
                "frodo", "front", "frost", "frozen", "frame", "kakao"
        }, new String[] {
                "fro??", "????o", "fr???", "fro???", "pro?"
        })));
    }
}
