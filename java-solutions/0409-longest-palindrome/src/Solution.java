/**
 * @author sichu
 * @date 2022/10/22
 **/
public class Solution {
    public int longestPalindrome(String s) {
        int[] arr = new int[128];
        for (char ch : s.toCharArray()) {
            ++arr[ch - '0'];
        }
        int cnt = 0;
        for (int x : arr) {
            cnt += (x % 2);
        }
        return cnt == 0 ? s.length() : (s.length() - cnt + 1);
    }
}
