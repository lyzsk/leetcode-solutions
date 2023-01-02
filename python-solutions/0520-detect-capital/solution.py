class Solution:
    def detectCapitalUse(self, word: str) -> bool:
        if len(word) >= 2 and word[0].islower() and word[1].isupper():
            return False
        for i in range(2, len(word)):
            if word[1].islower() ^ word[i].islower():
                return False
        return True
