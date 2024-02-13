from typing import List


class Solution:
    def firstPalindrome(self, words: List[str]) -> str:
        if words is None or len(words) == 0:
            return None
        for word in words:
            if self.is_palidrome(word):
                return word
        return ""

    def is_palidrome(self, word: str) -> bool:
        if word is None or len(word) == 0:
            return False
        left = 0
        right = len(word) - 1
        while left < right:
            if word[left] != word[right]:
                return False
            left += 1
            right -= 1
        return True
