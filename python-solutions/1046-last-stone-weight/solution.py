import heapq
from typing import List


class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        maxheap = [-stone for stone in stones]
        heapq.heapify(maxheap)
        while len(maxheap) > 1:
            y = heapq.heappop(maxheap)
            x = heapq.heappop(maxheap)
            if x != y:
                heapq.heappush(maxheap, y - x)
        return -maxheap[0] if maxheap else 0
