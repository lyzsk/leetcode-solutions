from typing import List


class Solution:
    def longestCommonPrefix(self, arr1: List[int], arr2: List[int]) -> int:
        res = 0
        st = set()
        for x in map(str, arr1):
            for i in range(1, len(x) + 1):
                st.add(x[:i])
        for x in map(str, arr2):
            for i in range(1, len(x) + 1):
                if x[:i] not in st:
                    break
                res = max(res, i)
        return res