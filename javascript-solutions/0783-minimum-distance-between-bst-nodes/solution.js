/**
 * @param {TreeNode} root
 * @return {number}
 */
var minDiffInBST = function (root) {
    let res = Number.MAX_SAFE_INTEGER;
    let pre = -1;
    const dfs = (root) => {
        if (root === null) {
            return;
        }
        dfs(root.left);
        if (pre === -1) {
            pre = root.val;
        } else {
            res = Math.min(res, root.val - pre);
            pre = root.val;
        }
        dfs(root.right);
    };
    dfs(root);
    return res;
};

function TreeNode(val, left, right) {
    this.val = val === undefined ? 0 : val;
    this.left = left === undefined ? null : left;
    this.right = right === undefined ? null : right;
}
