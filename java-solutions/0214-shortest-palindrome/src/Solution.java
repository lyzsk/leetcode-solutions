/**
 * @author sichu huang
 * @date 2024/09/20
 **/
public class Solution {
    public String shortestPalindrome(String s) {
        int count = kmp(new StringBuilder(s).reverse().toString(), s);
        return new StringBuilder(s.substring(count)).reverse() + s;
    }

    private int kmp(String reverse, String origin) {
        String str = origin + "." + reverse;
        int[] arr = new int[str.length()];
        int i = 1;
        int left = 0;
        while (i < str.length()) {
            if (str.charAt(i) == str.charAt(left)) {
                ++left;
                arr[i++] = left;
            } else {
                if (left > 0) {
                    left = arr[--left];
                } else {
                    arr[i++] = 0;
                }
            }
        }
        return arr[str.length() - 1];
    }
}
