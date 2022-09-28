/**
 * @author sichu
 * @date 2022/08/21
 **/
public class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                if (words[i].substring(0, j + 1).equals(searchWord)) {
                    return i + 1;
                }
            }
        }
        return -1;
    }
}
