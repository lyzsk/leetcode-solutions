/**
 * @author sichu
 * @date 2022/12/08
 **/
public class Solution {
    public boolean squareIsWhite(String coordinates) {
        return (coordinates.charAt(0) - 'a' + coordinates.charAt(1) - '0') % 2 == 0;
    }
}
