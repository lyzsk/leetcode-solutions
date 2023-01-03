/**
 * @param {ListNode} head
 * @param {number} k
 * @return {ListNode}
 */
var getKthFromEnd = function (head, k) {
    if (!head) {
        return undefined;
    }
    let slow = head;
    let fast = head;
    while (fast && k > 0) {
        fast = fast.next;
        --k;
    }
    while (fast) {
        slow = slow.next;
        fast = fast.next;
    }
    return slow;
};

function ListNode(val) {
    this.val = val;
    this.next = null;
}
