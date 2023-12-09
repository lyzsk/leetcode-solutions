function TreeNode(val, left, right) {
    this.val = val === undefined ? 0 : val;
    this.left = left === undefined ? null : left;
    this.right = right === undefined ? null : right;
}

/**
 * @param {TreeNode} root
 * @return {number[]}
 */
var inorderTraversal = function (root) {
    const res = [];
    helper(res, root);
    return res;
};

function helper(res, root) {
    if (root === null) {
        return;
    }
    helper(res, root.left);
    res.push(root.val);
    helper(res, root.right);
}
