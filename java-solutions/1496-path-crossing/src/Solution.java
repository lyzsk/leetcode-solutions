import java.util.HashSet;
import java.util.Set;

/**
 * @author sichu
 * @date 2023/12/23
 **/
public class Solution {
    public boolean isPathCrossing(String path) {
        int x = 0;
        int y = 0;
        Set<String> set = new HashSet<>();
        set.add(x + ":" + y);
        for (char ch : path.toCharArray()) {
            if (ch == 'N') {
                ++y;
            } else if (ch == 'S') {
                --y;
            } else if (ch == 'E') {
                ++x;
            } else {
                --x;
            }
            String point = x + ":" + y;
            if (set.contains(point)) {
                return true;
            }
            set.add(point);
        }
        return false;
    }
}
