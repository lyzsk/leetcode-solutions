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

function ListNode(val) {
    this.val = val;
    this.next = null;
}
