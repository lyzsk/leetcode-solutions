from typing import Optional

from listnode import ListNode


class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        slow = None
        fast = head
        while fast is not None:
            temp = fast.next
            fast.next = slow
            slow = fast
            fast = temp
        return slow
   