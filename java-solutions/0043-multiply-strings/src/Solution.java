/**
 * @author sichu
 * @date 2022/10/20
 **/
public class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int m = num1.length();
        int n = num2.length();
        int[] arr = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                arr[i + j + 1] += x * y;
            }
        }
        for (int i = m + n - 1; i > 0; i--) {
            arr[i - 1] += arr[i] / 10;
            arr[i] %= 10;
        }
        int idx = arr[0] == 0 ? 1 : 0;
        StringBuilder res = new StringBuilder();
        while (idx < m + n) {
            res.append(arr[idx++]);
        }
        return res.toString();
    }
}
