import java.util.ArrayList;
import java.util.List;

/**
 * @author sichu huang
 * @since 2026/02/17 17:59
 */
public class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> res = new ArrayList<String>();
        for (int h = 0; h < 12; ++h) {
            for (int m = 0; m < 60; ++m) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    res.add(h + ":" + (m < 10 ? "0" : "") + m);
                }
            }
        }
        return res;
    }
}
