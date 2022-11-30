/**
 * @author sichu
 * @date 2022/11/30
 **/
public class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        return s.length() - s.lastIndexOf(' ') - 1;
    }
}
