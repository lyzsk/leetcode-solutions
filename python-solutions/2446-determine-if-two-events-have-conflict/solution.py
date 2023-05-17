from typing import List


class Solution:
    def haveConflict(self, event1: List[str], event2: List[str]) -> bool:
        return not (event1[1] < event2[0] or event2[1] < event1[0])
