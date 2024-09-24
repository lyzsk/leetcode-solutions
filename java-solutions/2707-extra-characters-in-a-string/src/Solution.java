import java.util.Arrays;

/**
 * @author sichu huang
 * @date 2024/09/23
 **/
public class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        int[] d = new int[n + 1];
        Arrays.fill(d, Integer.MAX_VALUE);
        Trie trie = new Trie();
        for (String str : dictionary) {
            StringBuilder sb = new StringBuilder(str).reverse();
            trie.insert(sb.toString());
        }
        d[0] = 0;
        for (int i = 1; i <= n; i++) {
            d[i] = d[i - 1] + 1;
            Trie node = trie;
            for (int j = i - 1; j >= 0; j--) {
                if (node != null) {
                    node = node.track(s.charAt(j));
                    if (node != null && node.isEnd()) {
                        d[i] = Math.min(d[i], d[j]);
                    }
                }
            }
        }
        return d[n];
    }
}

class Trie {
    private Trie[] children;
    private boolean isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (node.children[ch - 'a'] == null) {
                node.children[ch - 'a'] = new Trie();
            }
            node = node.children[ch - 'a'];
        }
        node.isEnd = true;
    }

    public Trie track(char ch) {
        Trie node = this;
        if (node == null || node.children[ch - 'a'] == null) {
            return null;
        }
        node = node.children[ch - 'a'];
        return node;
    }

    public boolean isEnd() {
        return isEnd;
    }
}