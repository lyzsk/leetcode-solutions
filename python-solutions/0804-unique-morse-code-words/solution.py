from typing import List


class Solution:
    def uniqueMorseRepresentations(self, words: List[str]) -> int:
        MORSE = [".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.",
                 "---",
                 ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."]
        return len(
            set(
                "".join(MORSE[ord(ch) - ord('a')] for ch in word) for word in words
            )
        )
