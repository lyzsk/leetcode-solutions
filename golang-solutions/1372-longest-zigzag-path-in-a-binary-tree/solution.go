package main

func longestZigZag(root *TreeNode) int {
	res := 0
	var dfs func(*TreeNode, int, int)
	dfs = func(root *TreeNode, leftMax, rightMax int) {
		res = max(res, max(leftMax, rightMax))
		if root == nil {
			return
		}
		if root.Left != nil {
			dfs(root.Left, rightMax+1, 0)
		}
		if root.Right != nil {
			dfs(root.Right, 0, leftMax+1)
		}
	}
	dfs(root, 0, 0)
	return res
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}