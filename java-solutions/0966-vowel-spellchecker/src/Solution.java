import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author sichu huang
 * @since 2025/09/14 22:12
 */
public class Solution {

    private Set<String> wordsPerfect;
    private Map<String, String> wordsCap;
    private Map<String, String> wordsVow;

    public String[] spellchecker(String[] wordlist, String[] queries) {
        wordsPerfect = new HashSet<>();
        wordsCap = new HashMap<>();
        wordsVow = new HashMap<>();

        for (String word : wordlist) {
            wordsPerfect.add(word);

            String wordlow = word.toLowerCase();
            wordsCap.putIfAbsent(wordlow, word);

            String wordlowDV = devowel(wordlow);
            wordsVow.putIfAbsent(wordlowDV, word);
        }

        String[] res = new String[queries.length];
        int t = 0;
        for (String query : queries) {
            res[t++] = solve(query);
        }
        return res;
    }

    private String solve(String query) {
        if (wordsPerfect.contains(query)) {
            return query;
        }

        String queryL = query.toLowerCase();
        if (wordsCap.containsKey(queryL)) {
            return wordsCap.get(queryL);
        }

        String queryLV = devowel(queryL);
        if (wordsVow.containsKey(queryLV)) {
            return wordsVow.get(queryLV);
        }

        return "";
    }

    private String devowel(String word) {
        StringBuilder ans = new StringBuilder();
        for (char c : word.toCharArray()) {
            ans.append(isVowel(c) ? '*' : c);
        }
        return ans.toString();
    }

    private boolean isVowel(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }
}
