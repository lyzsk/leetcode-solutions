class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        map = dict()
        res = 0
        left = 0
        for right in range(len(s)):
            if s[right] in map:
                left = max(left, map[s[right]] + 1)
            map[s[right]] = right
            res = max(res, right - left + 1)
        return res
   