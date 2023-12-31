class Solution:
    def maxLengthBetweenEqualCharacters(self, s: str) -> int:
        n = len(s)
        res = -1
        for left in range(n):
            for right in range(left + 1, n):
                if s[left] == s[right]:
                    res = max(res, right - left - 1)
        return res
