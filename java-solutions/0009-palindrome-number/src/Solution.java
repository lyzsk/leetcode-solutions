/**
 * @author sichu
 * @date 2022/10/21
 **/
public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }
        int revertedNum = 0;
        while (x > revertedNum) {
            revertedNum = revertedNum * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNum || x == revertedNum / 10;
    }
}
