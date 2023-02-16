package main

func digitCount(num string) bool {
	hash := [10]int{0}
	for _, ch := range num {
		hash[ch-'0']++
	}
	for i, ch := range num {
		if hash[i] != int(ch-'0') {
			return false
		}
	}
	return true
}