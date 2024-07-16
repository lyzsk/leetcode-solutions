import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author sichu huang
 * @date 2024/07/16
 **/
public class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>(16);
        Set<Integer> set = new HashSet<>();
        for (int[] arr : descriptions) {
            int p = arr[0];
            int c = arr[1];
            int lr = arr[2];
            if (!map.containsKey(p)) {
                map.put(p, new TreeNode(p));
            }
            if (!map.containsKey(c)) {
                map.put(c, new TreeNode(c));
            }
            if (lr == 1) {
                map.get(p).left = map.get(c);
            } else {
                map.get(p).right = map.get(c);
            }
            set.add(c);
        }
        for (int key : map.keySet()) {
            if (!set.contains(key)) {
                return map.get(key);
            }
        }
        return null;
    }
}
