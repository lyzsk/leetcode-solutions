package main

func zeroFilledSubarray(nums []int) int64 {
	res := int64(0)
	zeroCnt := 0
	for _, num := range nums {
		if num == 0 {
			zeroCnt++
			res += int64(zeroCnt)
		} else {
			zeroCnt = 0
		}
	}
	return res
}