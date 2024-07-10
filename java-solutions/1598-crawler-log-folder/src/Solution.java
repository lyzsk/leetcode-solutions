/**
 * @author sichu huang
 * @date 2024/07/10
 **/
public class Solution {
    public int minOperations(String[] logs) {
        int depth = 0;
        for (String log : logs) {
            if ("./".equals(log)) {
                continue;
            } else if ("../".equals(log)) {
                if (depth > 0) {
                    --depth;
                }
            } else {
                ++depth;
            }
        }
        return depth;
    }
}
