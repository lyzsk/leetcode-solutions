import java.util.ArrayList;
import java.util.List;

/**
 * @author sichu
 * @date 2023/01/30
 **/
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        constructPaths(root, "", paths);
        return paths;
    }

    private void constructPaths(TreeNode root, String path, List<String> paths) {
        if (root != null) {
            StringBuilder sb = new StringBuilder(path);
            sb.append(Integer.toString(root.val));
            if (root.left == null && root.right == null) {
                paths.add(sb.toString());
            } else {
                sb.append("->");
                constructPaths(root.left, sb.toString(), paths);
                constructPaths(root.right, sb.toString(), paths);
            }
        }
    }
}
