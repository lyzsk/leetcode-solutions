class Solution:
    def minSteps(self, s: str, t: str) -> int:
        cntS = [0] * 26
        cntT = [0] * 26

        for ch in s:
            cntS[ord(ch) - ord('a')] += 1
        for ch in t:
            cntT[ord(ch) - ord('a')] += 1

        res = 0
        for i in range(26):
            res += abs(cntS[i] - cntT[i])
        return res // 2
