from typing import List


class Solution:
    def buildArray(self, target: List[int], n: int) -> List[str]:
        res = []
        cur = 1
        idx = 0
        while cur <= n and idx < len(target):
            num = target[idx]
            if num == cur:
                res.append("Push")
                cur += 1
                idx += 1
            else:
                res.append("Push")
                res.append("Pop")
                cur += 1
        return res
