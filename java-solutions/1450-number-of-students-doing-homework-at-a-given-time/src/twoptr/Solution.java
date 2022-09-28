package twoptr;

/**
 * @author sichu
 * @date 2022/08/21
 **/
public class Solution {
    private static final char SPACE = ' ';

    private static boolean isPrefix(String sentence, int start, int end, String searchWord) {
        for (int i = 0; i < searchWord.length(); i++) {
            if (start + i >= end || sentence.charAt(start + i) != searchWord.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public int isPrefixOfWord(String sentence, String searchWord) {
        int start = 0;
        int end = 0;
        int index = 1;
        while (start < sentence.length()) {
            while (end < sentence.length() && sentence.charAt(end) != SPACE) {
                ++end;
            }
            if (isPrefix(sentence, start, end, searchWord)) {
                return index;
            }
            ++index;
            ++end;
            start = end;
        }
        return -1;
    }
}
