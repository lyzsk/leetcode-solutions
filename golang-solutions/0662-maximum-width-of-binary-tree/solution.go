package main

func widthOfBinaryTree(root *TreeNode) int {
	myMap := map[int]int{}
	var dfs func(*TreeNode, int, int) int
	dfs = func(root *TreeNode, depth, index int) int {
		if root == nil {
			return 0
		}
		if _, ok := myMap[depth]; !ok {
			myMap[depth] = index
		}
		return max(index-myMap[depth]+1, max(dfs(root.Left, depth+1, index*2), dfs(root.Right, depth+1, index*2+1)))
	}
	return dfs(root, 1, 1)
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