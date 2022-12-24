/**
 * @author sichu
 * @date 2022/12/24
 **/
public class Solution {
    public String largestMerge(String word1, String word2) {
        StringBuilder merge = new StringBuilder();
        int i = 0;
        int j = 0;
        while (i < word1.length() || j < word2.length()) {
            if (i < word1.length() && word1.substring(i).compareTo(word2.substring(j)) > 0) {
                merge.append(word1.charAt(i++));
            } else {
                merge.append(word2.charAt(j++));
            }
        }
        return merge.toString();
    }
}
