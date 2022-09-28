class Solution:
    def longestPalindrome(self, s: str) -> str:
        sub_range = [0] * 2
        arr = list(s)
        for left in range(len(s)):
            left = self.findLongest(arr, left, sub_range)
        return s[sub_range[0]: sub_range[1] + 1]

    def findLongest(self, arr: list[str], left: int, sub_range: list[int]) -> int:
        right = left
        while right < len(arr) - 1 and arr[right] == arr[right + 1]:
            right += 1
        res = right
        while left > 0 and right < len(arr) - 1 and arr[left - 1] == arr[right + 1]:
            left -= 1
            right += 1
        if right - left > sub_range[1] - sub_range[0]:
            sub_range[0] = left
            sub_range[1] = right
        return res
