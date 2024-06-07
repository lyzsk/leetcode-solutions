import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author sichu huang
 * @date 2024/06/07
 **/
public class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> set = new HashSet<>(dictionary);
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                if (set.contains(word.substring(0, j + 1))) {
                    words[i] = word.substring(0, j + 1);
                    break;
                }
            }
        }
        return String.join(" ", words);
    }
}
