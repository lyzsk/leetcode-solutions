/**
 * @author sichu
 * @date 2022/08/17
 **/
public class Solution {
    private static int findLongest(char[] arr, int left, int[] range) {
        int right = left;
        while (right < arr.length - 1 && arr[right] == arr[right + 1]) {
            ++right;
        }
        int res = right;
        while (left > 0 && right < arr.length - 1 && arr[left - 1] == arr[right + 1]) {
            --left;
            ++right;
        }
        if (right - left > range[1] - range[0]) {
            range[0] = left;
            range[1] = right;
        }
        return res;
    }

    public String longestPalindrome(String s) {
        int[] range = new int[2];
        char[] arr = s.toCharArray();
        for (int left = 0; left < arr.length; left++) {
            left = findLongest(arr, left, range);
        }
        return s.substring(range[0], range[1] + 1);
    }
}
