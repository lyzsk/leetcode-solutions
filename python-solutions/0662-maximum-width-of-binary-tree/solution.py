from typing import Optional

from treenode import TreeNode


class Solution:
    def widthOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        map = dict()

        def dfs(root: Optional[TreeNode], depth: int, index: int) -> int:
            if root is None:
                return 0
            if depth not in map.keys():
                map[depth] = index
            return max(index - map[depth] + 1, dfs(root.left, depth + 1, index * 2),
                       dfs(root.right, depth + 1, index * 2 + 1))

        return dfs(root, 1, 1)
