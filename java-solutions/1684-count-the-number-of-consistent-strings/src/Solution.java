/**
 * @author sichu huang
 * @date 2024/09/12
 **/
public class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int[] arr = new int[26];
        for (char ch : allowed.toCharArray()) {
            arr[ch - 'a'] = 1;
        }
        int count = 0;
        for (String word : words) {
            count += findCosistentString(arr, word);
        }
        return count;
    }

    private int findCosistentString(int[] arr, String word) {
        int flag = 1;
        for (int i = 0; i < word.length(); i++) {
            if (arr[word.charAt(i) - 'a'] == 0) {
                flag = 0;
                break;
            }
        }
        return flag;
    }
}
