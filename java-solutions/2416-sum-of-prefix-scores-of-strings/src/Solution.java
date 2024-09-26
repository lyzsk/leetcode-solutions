/**
 * @author sichu huang
 * @date 2024/09/25
 **/
public class Solution {
    public int[] sumPrefixScores(String[] words) {
        int[] res = new int[words.length];
        int index = 0;
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        for (String word : words) {
            int cnt = trie.searchPrefix(word);
            res[index++] = cnt;
        }
        return res;
    }
}

class Trie {
    Trie[] children;
    boolean isEnd;
    int num;

    public Trie() {
        this.children = new Trie[26];
        this.isEnd = false;
        this.num = 0;
    }

    public void insert(String word) {
        Trie node = this;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            node = node.children[index];
            node.num++;
        }
        node.isEnd = true;
    }

    public int searchPrefix(String prefix) {
        Trie node = this;
        int cnt = 0;
        int n = prefix.length();
        for (int i = 0; i < n; ++i) {
            char c = prefix.charAt(i);
            int index = c - 'a';
            if (node.children[index] != null) {
                node = node.children[index];
                cnt += node.num;
            } else {
                return 0;
            }
        }
        return cnt;
    }
}