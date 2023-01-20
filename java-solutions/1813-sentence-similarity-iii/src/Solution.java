/**
 * @author sichu
 * @date 2023/01/20
 **/
public class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");
        int i = 0;
        int j = 0;
        while (i < words1.length && i < words2.length && words1[i].equals(words2[i])) {
            ++i;
        }
        while (j < words1.length - i && j < words2.length - i && words1[words1.length - 1 - j].equals(
            words2[words2.length - 1 - j])) {
            ++j;
        }
        return i + j == Math.min(words1.length, words2.length);
    }
}
