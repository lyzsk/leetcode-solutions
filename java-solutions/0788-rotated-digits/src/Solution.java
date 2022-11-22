/**
 * @author sichu
 * @date 2022/11/22
 **/
public class Solution {
    // 2, 5, 6, 9 至少出现一次
    // 0, 1, 8 无需求
    // 3, 4, 7 不能出现
    private static int[] check = new int[] {0, 0, 1, -1, -1, 1, 1, -1, 0, 1};

    public int rotatedDigits(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            String num = String.valueOf(i);
            boolean valid = true;
            boolean diff = false;
            for (int j = 0; j < num.length(); j++) {
                char ch = num.charAt(j);
                if (check[ch - '0'] == -1) {
                    valid = false;
                } else if (check[ch - '0'] == 1) {
                    diff = true;
                }
            }
            if (valid && diff) {
                ++res;
            }
        }
        return res;
    }
}
