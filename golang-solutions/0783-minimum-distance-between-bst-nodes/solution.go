package main

import "math"

func minDiffInBST(root *TreeNode) int {
	res := math.MaxInt64
	pre := -1
	var dfs func(*TreeNode)
	dfs = func(root *TreeNode) {
		if root == nil {
			return
		}
		dfs(root.Left)
		if pre == -1 {
			pre = root.Val
		} else {
			res = min(res, root.Val-pre)
			pre = root.Val
		}
		dfs(root.Right)
	}
	dfs(root)
	return res
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}