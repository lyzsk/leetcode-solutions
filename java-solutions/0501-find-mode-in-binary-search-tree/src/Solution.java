import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sichu
 * @date 2023/11/01
 **/
public class Solution {
    public int[] findMode(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        Map<Integer, Integer> freq = new HashMap<>(16);
        int maxCnt = 0;
        for (Integer val : list) {
            freq.put(val, freq.getOrDefault(val, 0) + 1);
            maxCnt = Math.max(maxCnt, freq.get(val));
        }
        List<Integer> resList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == maxCnt) {
                resList.add(entry.getKey());
            }
        }
        int[] res = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }
        return res;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        inorder(root.left, list);
        inorder(root.right, list);
    }
}
