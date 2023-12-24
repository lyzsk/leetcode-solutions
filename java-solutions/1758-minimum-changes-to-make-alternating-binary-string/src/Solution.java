/**
 * @author sichu
 * @date 2022/11/29
 **/
public class Solution {
    public int minOperations(String s) {
        int cntZeros = 0;
        int cntOnes = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (i % 2 == 0) {
                if (ch == '0') {
                    ++cntOnes;
                } else {
                    ++cntZeros;
                }
            } else {
                if (ch == '1') {
                    ++cntOnes;
                } else {
                    ++cntZeros;
                }
            }
        }
        return Math.min(cntZeros, cntOnes);
    }
}
