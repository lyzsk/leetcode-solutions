class Solution:
    def countHomogenous(self, s: str) -> int:
        mod = 1e9 + 7
        res = 0
        left = 0
        for right in range(len(s)):
            if s[left] == s[right]:
                res += right - left + 1
            else:
                res += 1
                left = right
        return int(res % mod)
