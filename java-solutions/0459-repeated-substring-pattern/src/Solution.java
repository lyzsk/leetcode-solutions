/**
 * @author sichu
 * @since 2023/08/21
 **/
public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        return (s + s).indexOf(s, 1) != s.length();
    }
}
