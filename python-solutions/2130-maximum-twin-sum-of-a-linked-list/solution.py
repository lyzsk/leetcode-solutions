from typing import Optional

from listnode import ListNode


class Solution:
    def pairSum(self, head: Optional[ListNode]) -> int:
        slow = head
        fast = head.next
        while fast.next:
            slow = slow.next
            fast = fast.next.next
        first = None
        last = slow.next
        while last:
            temp = last.next
            last.next = first
            first = last
            last = temp
        slow.next = first
        res = 0
        x = head
        y = slow.next
        while y:
            res = max(res, x.val + y.val)
            x = x.next
            y = y.next
        return res
