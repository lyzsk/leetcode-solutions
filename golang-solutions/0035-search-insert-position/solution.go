package main

func searchInsert(nums []int, target int) int {
	n := len(nums)
	left := 0
	right := n - 1
	for left < right {
		mid := left + ((right - left) >> 1)
		if nums[mid] < target {
			left = mid + 1
		} else {
			right = mid
		}
	}
	if left == n-1 && nums[left] < target {
		return n
	}
	return left
}