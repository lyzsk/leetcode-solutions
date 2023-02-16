package main

func maxDepth(root *TreeNode) int {
	if root == nil {
		return 0
	} else {
		left := maxDepth(root.Left)
		right := maxDepth(root.Right)
		return max(left, right) + 1
	}
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
