/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var reverseList = function (head) {
    let slow = null;
    let fast = head;
    while (fast) {
        const temp = fast.next;
        fast.next = slow;
        slow = fast;
        fast = temp;
    }
    return slow;
};
