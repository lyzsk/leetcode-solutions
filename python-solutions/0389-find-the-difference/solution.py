class Solution:
    def findTheDifference(self, s: str, t: str) -> str:
        res = 0
        for i in s + t:
            res ^= ord(i)

        return chr(res)
