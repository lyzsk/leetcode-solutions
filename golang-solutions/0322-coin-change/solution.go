package main

func coinChange(coins []int, amount int) int {
	var dp = make([]int, amount+1)
	dp[0] = 0
	for i := 1; i <= amount; i++ {
		dp[i] = amount + 1
		for _, coin := range coins {
			if coin <= i {
				dp[i] = min(dp[i], dp[i-coin]+1)
			}
		}
	}
	if dp[amount] > amount {
		return -1
	}
	return dp[amount]
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}