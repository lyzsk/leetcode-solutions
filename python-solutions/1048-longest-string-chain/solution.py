from collections import defaultdict
from typing import List


class Solution:
    def longestStrChain(self, words: List[str]) -> int:
        res = 0
        map = defaultdict(int)
        words.sort(key=len)
        for word in words:
            map[word] = 1
            for i in range(len(word)):
                subseq = word[:i] + word[i + 1:]
                if subseq in map:
                    map[word] = max(map[word], map[subseq] + 1)
            res = max(res, map[word])
        return res
