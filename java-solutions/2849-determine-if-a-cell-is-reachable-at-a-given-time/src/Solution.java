/**
 * @author sichu
 * @date 2023/09/10
 **/
public class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        if (sx == fx && sy == fy) {
            return t == 0 || t >= 2;
        }
        int minx = Math.min(sx, fx);
        int miny = Math.min(sy, fy);
        int maxx = Math.max(sx, fx);
        int maxy = Math.max(sy, fy);
        return minx + t >= maxx && miny + t >= maxy;
    }
}
