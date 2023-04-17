/**
 * @param {TreeNode} root
 * @return {number}
 */
var maxAncestorDiff = function (root) {
    if (root === null) {
        return 0;
    }
    return dfs(root, root.val, root.val);
};

function dfs(root, max, min) {
    if (root === null) {
        return 0;
    }
    let maxDiff = Math.max(Math.abs(root.val - max), Math.abs(root.val - min));
    max = Math.max(root.val, max);
    min = Math.min(root.val, min);
    maxDiff = Math.max(maxDiff, dfs(root.left, max, min));
    maxDiff = Math.max(maxDiff, dfs(root.right, max, min));
    return maxDiff;
}
