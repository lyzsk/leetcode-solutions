import java.util.*;

/**
 * @author sichu
 * @date 2022/10/20
 **/
public class Solution {
    int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private void dfs(Set<String> res, char[][] board, Trie cur, int x, int y) {
        if (!cur.children.containsKey(board[x][y])) {
            return;
        }
        char ch = board[x][y];
        Trie next = cur.children.get(ch);
        if (!"".equals(next.word)) {
            res.add(next.word);
            next.word = "";
        }
        if (!next.children.isEmpty()) {
            board[x][y] = '.';
            for (int[] dir : dirs) {
                int i = x + dir[0];
                int j = y + dir[1];
                if (i >= 0 && j >= 0 && i < board.length && j < board[0].length) {
                    dfs(res, board, next, i, j);
                }
            }
            board[x][y] = ch;
        }
        if (next.children.isEmpty()) {
            cur.children.remove(ch);
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        Set<String> res = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(res, board, trie, i, j);
            }
        }
        return new ArrayList<>(res);
    }

    static class Trie {
        String word;
        Map<Character, Trie> children;
        boolean isWord;

        public Trie() {
            this.word = "";
            this.children = new HashMap<>(16);
        }

        public void insert(String word) {
            Trie cur = this;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (!cur.children.containsKey(ch)) {
                    cur.children.put(ch, new Trie());
                }
                cur = cur.children.get(ch);
            }
            cur.word = word;
        }
    }
}