from typing import List


class Solution:
    def uniqueOccurrences(self, arr: List[int]) -> bool:
        occurences_map = {}
        for num in arr:
            occurences_map[num] = occurences_map.get(num, 0) + 1
        occurences_set = set(occurences_map.values())
        return len(occurences_map) == len(occurences_set)
