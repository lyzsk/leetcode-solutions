package main

func findTheDifference(s string, t string) byte {
	var res byte
	// for i := range s {
	// 	res ^= s[i] ^ t[i]
	// }
	// return res ^ t[len(t)-1]
	for i := range s {
		res ^= s[i]
	}
	for j := range t {
		res ^= t[j]
	}
	return res
}