import java.util.HashMap;
import java.util.Map;

/**
 * @author sichu
 * @date 2023/02/02
 **/
public class Solution {
    private Map<Integer, Integer> map;
    private int[] post;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // inorder: 左中右, post: 左右中
        this.map = new HashMap<>(inorder.length);
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        this.post = postorder;
        return buildTree(0, inorder.length - 1, 0, post.length - 1);
    }

    private TreeNode buildTree(int inLeft, int inRight, int postLeft, int postRight) {
        if (inLeft > inRight || postLeft > postRight) {
            return null;
        }
        int root = post[postRight];
        int rootIdx = map.get(root);
        TreeNode node = new TreeNode(root);
        node.left = buildTree(inLeft, rootIdx - 1, postLeft, postLeft + rootIdx - inLeft - 1);
        node.right = buildTree(rootIdx + 1, inRight, postLeft + rootIdx - inLeft, postRight - 1);
        return node;
    }
}
