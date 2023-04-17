package main

func kidsWithCandies(candies []int, extraCandies int) []bool {
	n := len(candies)
	maxCandies := 0
	for i := 0; i < n; i++ {
		maxCandies = max(maxCandies, candies[i])
	}
	res := make([]bool, n)
	for i := 0; i < n; i++ {
		res[i] = candies[i]+extraCandies >= maxCandies
	}
	return res
}

func max(x, y int) int {
	if x > y {
		return x
	}
	return y
}