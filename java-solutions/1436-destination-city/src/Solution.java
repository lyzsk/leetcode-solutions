import java.util.HashSet;
import java.util.List;

/**
 * @author sichu
 * @date 2023/12/15
 **/
public class Solution {
    public String destCity(List<List<String>> paths) {
        HashSet<String> set = new HashSet<>();
        for (List<String> path : paths) {
            set.add(path.get(0));
        }
        for (List<String> path : paths) {
            String dest = path.get(1);
            if (!set.contains(dest)) {
                return dest;
            }
        }
        return "";
    }
}
