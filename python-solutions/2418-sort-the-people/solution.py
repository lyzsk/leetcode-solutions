from typing import List


class Solution:
    def sortPeople(self, names: List[str], heights: List[int]) -> List[str]:
        n = len(names)
        indices = list(range(n))
        indices.sort(key=lambda x: heights[x], reverse=True)
        res = []
        for i in indices:
            res.append(names[i])
        return res
