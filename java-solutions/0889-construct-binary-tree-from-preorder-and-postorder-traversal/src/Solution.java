import java.util.HashMap;
import java.util.Map;

/**
 * @author sichu huang
 * @since 2025/02/23 18:45
 */
public class Solution {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = preorder.length;
        Map<Integer, Integer> postMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            postMap.put(postorder[i], i);
        }
        return dfs(preorder, postorder, postMap, 0, n - 1, 0, n - 1);
    }

    private TreeNode dfs(int[] preorder, int[] postorder, Map<Integer, Integer> postMap,
        int preLeft, int preRight, int postLeft, int postRight) {
        if (preLeft > preRight) {
            return null;
        }
        int leftCount = 0;
        if (preLeft < preRight) {
            leftCount = postMap.get(preorder[preLeft + 1]) - postLeft + 1;
        }
        return new TreeNode(preorder[preLeft],
            dfs(preorder, postorder, postMap, preLeft + 1, preLeft + leftCount, postLeft,
                postLeft + leftCount - 1),
            dfs(preorder, postorder, postMap, preLeft + leftCount + 1, preRight,
                postLeft + leftCount, postRight - 1));
    }
}
