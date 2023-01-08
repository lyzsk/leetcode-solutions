/**
 * @author sichu
 * @date 2023/01/08
 **/
public class Solution {
    public boolean isItPossible(String word1, String word2) {
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (char ch : word1.toCharArray()) {
            ++cnt1[ch - 'a'];
        }
        for (char ch : word2.toCharArray()) {
            ++cnt2[ch - 'a'];
        }
        for (int i = 0; i < 26; i++) {
            if (cnt1[i] > 0) {
                for (int j = 0; j < 26; j++) {
                    if (cnt2[j] > 0) {
                        --cnt1[i];
                        ++cnt1[j];
                        ++cnt2[i];
                        --cnt2[j];
                        int num1 = 0;
                        int num2 = 0;
                        for (int k = 0; k < 26; k++) {
                            if (cnt1[k] > 0) {
                                ++num1;
                            }
                            if (cnt2[k] > 0) {
                                ++num2;
                            }
                        }
                        if (num1 == num2) {
                            return true;
                        }
                        ++cnt1[i];
                        --cnt1[j];
                        --cnt2[i];
                        ++cnt2[j];
                    }
                }
            }
        }
        return false;
    }
}
