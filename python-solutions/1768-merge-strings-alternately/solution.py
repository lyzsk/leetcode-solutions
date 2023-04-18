class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        m, n = len(word1), len(word2)
        p1 = p2 = 0
        res = list()
        while p1 < m or p2 < n:
            if p1 < m:
                res.append(word1[p1])
                p1 += 1
            if p2 < n:
                res.append(word2[p2])
                p2 += 1

        return "".join(res)
