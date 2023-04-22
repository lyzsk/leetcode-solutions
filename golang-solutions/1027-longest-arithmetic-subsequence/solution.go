package main

func longestArithSeqLength(nums []int) int {
	minv, maxv := nums[0], nums[0]
	for _, num := range nums[1:] {
		if num < minv {
			minv = num
		} else if num > maxv {
			maxv = num
		}
	}
	diff := maxv - minv
	res := 1
	for i := -diff; i <= diff; i++ {
		dp := make([]int, maxv+1)
		for j := range dp {
			dp[j] = -1
		}
		for _, num := range nums {
			prev := num - i
			if prev >= minv && prev <= maxv && dp[prev] != -1 {
				dp[num] = max(dp[num], dp[prev]+1)
				res = max(res, dp[num])
			}
			dp[num] = max(dp[num], 1)
		}
	}
	return res
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}