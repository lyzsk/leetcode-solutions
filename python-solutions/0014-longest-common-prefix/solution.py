from typing import List


class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        if not strs:
            return ""
        res = strs[0]
        for i in range(1, len(strs)):
            while strs[i].find(res) != 0:
                res = res[:-1]
                if not res:
                    return ""
        return res
