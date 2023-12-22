class Solution:
    def maxScore(self, s: str) -> int:
        res = 0
        zeros = 0
        ones = 0
        for ch in s:
            if ch == '1':
                ones += 1
        i = 0
        while i < len(s) - 1:
            if s[i] == '0':
                zeros += 1
            else:
                ones -= 1
            res = max(res, ones + zeros)
            i += 1
        return res
