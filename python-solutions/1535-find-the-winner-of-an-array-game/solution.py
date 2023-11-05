from typing import List


class Solution:
    def getWinner(self, arr: List[int], k: int) -> int:
        if k == 1:
            return max(arr[0], arr[1])
        n = len(arr)
        if k >= n:
            return max(arr)
        curWinner = arr[0]
        winCnt = 0
        for i in range(1, n):
            if curWinner > arr[i]:
                winCnt += 1
            else:
                curWinner = arr[i]
                winCnt = 1
            if winCnt == k:
                return curWinner
        return curWinner
