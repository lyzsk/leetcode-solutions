import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sichu
 * @date 2023/08/15
 **/
public class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int n = s.length();
        int k = indices.length;
        Map<Integer, List<Integer>> map = new HashMap<>(16);
        for (int i = 0; i < k; i++) {
            map.putIfAbsent(indices[i], new ArrayList<Integer>());
            map.get(indices[i]).add(i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; ) {
            boolean flag = false;
            if (map.containsKey(i)) {
                for (int x : map.get(i)) {
                    if (s.substring(i, Math.min(i + sources[x].length(), n)).equals(sources[x])) {
                        flag = true;
                        sb.append(targets[x]);
                        i += sources[x].length();
                        break;
                    }
                }
            }
            if (!flag) {
                sb.append(s.charAt(i));
                ++i;
            }
        }
        return sb.toString();
    }
}
