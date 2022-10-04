import java.util.HashMap;
import java.util.Map;

/**
 * @author sichu
 * @date 2022/10/04
 **/
public class Solution {
    private Map<Integer, Integer> map;
    private int[] pre;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>(inorder.length);
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        pre = preorder;
        return buildTree(0, inorder.length - 1, 0, preorder.length - 1);
    }

    private TreeNode buildTree(int inLeft, int inRight, int preLeft, int preRight) {
        if (inLeft > inRight || preLeft > preRight) {
            return null;
        }
        int root = pre[preLeft];
        int rootIdx = map.get(root);
        TreeNode node = new TreeNode(root);
        node.left = buildTree(inLeft, rootIdx - 1, preLeft + 1, preLeft + rootIdx - inLeft);
        node.right = buildTree(rootIdx + 1, inRight, preLeft + rootIdx - inLeft + 1, preRight);
        return node;
    }
}
