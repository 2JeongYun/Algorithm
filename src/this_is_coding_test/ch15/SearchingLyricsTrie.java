package this_is_coding_test.ch15;

class SearchingLyricsTrie {
    public int[] solution(String[] words, String[] queries) {
        TrieNode[] normalTrie = new TrieNode[10001];
        TrieNode[] reverseTrie = new TrieNode[10001];

        for (int i = 0; i < 10001; i++) {
            normalTrie[i] = new TrieNode();
            reverseTrie[i] = new TrieNode();
        }

        for (int i = 0; i < words.length; i++) {
            StringBuffer sb = new StringBuffer(words[i]);
            sb.reverse();

            normalTrie[words[i].length()].insert(words[i]);
            reverseTrie[words[i].length()].insert(sb.toString());
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            if (query.charAt(0) == '?') {
                StringBuffer sb = new StringBuffer(query);
                sb.reverse();
                ans[i] = reverseTrie[query.length()].search(sb.toString());
            } else {
                ans[i] = normalTrie[query.length()].search(query);
            }
        }
        return ans;
    }

    class TrieNode {
        int childCount;
        TrieNode[] childs;

        TrieNode() {
            childCount = 0;
            childs = new TrieNode[26];
        }

        public void insert(String word) {
            TrieNode curNode = this;
            for (int i = 0; i < word.length(); i++) {
                curNode.childCount++;

                int alphaNum = word.charAt(i) - 'a';
                if (curNode.childs[alphaNum] == null) {
                    curNode.childs[alphaNum] = new TrieNode();
                }
                curNode = curNode.childs[alphaNum];
            }
        }

        public int search(String query) {
            TrieNode curNode = this;
            for (int i = 0; i < query.length(); i++) {
                int alphaNum = query.charAt(i) - 'a';

                if (query.charAt(i) == '?') {
                    return curNode.childCount;
                } else if (curNode.childs[alphaNum] == null) {
                    return 0;
                }

                curNode = curNode.childs[alphaNum];
            }
            return 0;
        }
    }
}
