package main

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
 type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

 func maxAncestorDiff(root *TreeNode) int {
	if root == nil {
		return 0;
	}
	return dfs(root, root.Val, root.Val);
 }

func dfs(root *TreeNode, maxVal, minVal int) int {
	if root == nil {
		return 0;
	}
	maxDiff := max(abs(root.Val - maxVal), abs(root.Val - minVal));
	maxVal, minVal = max(maxVal, root.Val), min(minVal, root.Val);
	maxDiff = max(maxDiff, dfs(root.Left, maxVal, minVal));
	maxDiff = max(maxDiff, dfs(root.Right, maxVal, minVal));
	return maxDiff;
}

func max(a, b int) int {
	if a > b {
		return a;
	}
	return b;
}

func min(a, b int) int {
	if a < b {
		return a;
	}
	return b;
}

func abs(a int) int {
	if a < 0 {
		return -a;
	}
	return a;
}