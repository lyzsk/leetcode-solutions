/**
 * @author sichu
 * @date 2023/11/20
 **/
public class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int n = garbage.length;
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            res += 3 * travel[i];
        }
        for (String g : garbage) {
            res += g.length();
        }
        for (int i = n - 1; i > 0; i--) {
            if (!garbage[i].contains("M")) {
                res -= travel[i - 1];
            } else {
                break;
            }
        }
        for (int i = n - 1; i > 0; i--) {
            if (!garbage[i].contains("P")) {
                res -= travel[i - 1];
            } else {
                break;
            }
        }
        for (int i = n - 1; i > 0; i--) {
            if (!garbage[i].contains("G")) {
                res -= travel[i - 1];
            } else {
                break;
            }
        }
        return res;
    }
}
