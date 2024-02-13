from typing import List


class Solution:
    def firstPalindrome(self, words: List[str]) -> str:
        if words is None or len(words) == 0:
            return None
        for word in words:
            if word == word[::-1]:
                return word
        return ""
