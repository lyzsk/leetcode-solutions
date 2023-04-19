/**
 * @param {TreeNode} root
 * @return {number}
 */
var longestZigZag = function (root) {
    let res = 0;
    const dfs = (root, leftMax, rightMax) => {
        res = Math.max(res, leftMax, rightMax);
        if (root.left) {
            dfs(root.left, rightMax + 1, 0);
        }
        if (root.right) {
            dfs(root.right, 0, leftMax + 1);
        }
    };
    dfs(root, 0, 0);
    return res;
};

function TreeNode(val, left, right) {
    this.val = val === undefined ? 0 : val;
    this.left = left === undefined ? null : left;
    this.right = right === undefined ? null : right;
}
