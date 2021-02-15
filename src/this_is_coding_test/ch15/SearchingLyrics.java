package this_is_coding_test.ch15;

import java.util.*;
import java.lang.*;

class SearchingLyrics {
    static final int REVERSE = 0;
    static final int NORMAL = 1;

    public int[] solution(String[] words, String[] queries) {
        ArrayList<String>[][] wordLists = new ArrayList[10002][2];
        for (int i = 0; i < 10002; i++) {
            for (int j = 0; j < 2; j++) {
                wordLists[i][j] = new ArrayList<>();
            }
        }

        for (String word : words) {
            StringBuffer sb = new StringBuffer(word);
            sb.reverse();
            wordLists[word.length()][NORMAL].add(word);
            wordLists[word.length()][REVERSE].add(sb.toString());
        }

        for (int i = 0; i < wordLists.length; i++) {
            for (int j = 0; j < wordLists[0].length; j++) {
                Collections.sort(wordLists[i][j]);
            }
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = getMatchCount(wordLists, queries[i]);
        }
        return ans;
    }

    public int getMatchCount(ArrayList<String>[][] wordLists, String query) {
        ArrayList<String> targetList;
        StringBuffer sb = new StringBuffer(query);

        if (query.charAt(0) == '?') {
            targetList = wordLists[query.length()][REVERSE];
            sb.reverse();
        } else {
            targetList = wordLists[query.length()][NORMAL];
        }

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '?') {
                sb.delete(i, sb.length());
                break;
            }
        }

        if (targetList.size() == 0) {
            return 0;
        }

        int alphaLength = sb.length();
        while (sb.length() != query.length()) {
            sb.append('a');
        }
        int first = search(targetList, 0, targetList.size() - 1, sb.toString());

        if (targetList.get(first).compareTo(sb.toString()) < 0) {
            first += 1;
        }

        sb.delete(alphaLength, sb.length());
        while (sb.length() != query.length()) {
            sb.append('z');
        }
        int last = search(targetList, 0, targetList.size() - 1, sb.toString());

        if (targetList.get(last).compareTo(sb.toString()) > 0) {
            last -= 1;
        }

        return (last - first < 0) ? 0 : last - first + 1;
    }

    public int search(ArrayList<String> arr, int s, int e, String target) {
        if (s >= e) {
            return s;
        }

        int midIdx = (s + e) / 2;
        String midStr = arr.get(midIdx);

        if (target.compareTo(midStr) < 0) {
            return search(arr, s, midIdx, target);
        } else if (target.compareTo(midStr) > 0) {
            return search(arr, midIdx + 1, e, target);
        } else {
            return midIdx;
        }
    }
}
