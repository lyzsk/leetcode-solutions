function ListNode(val, next) {
    this.val = val === undefined ? 0 : val;
    this.next = next === undefined ? null : next;
}

/**
 * @param {ListNode} head
 * @return {number}
 */
var pairSum = function (head) {
    let slow = head;
    let fast = head.next;
    while (fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    let first = null;
    let last = slow.next;
    while (last != null) {
        let temp = last.next;
        last.next = first;
        first = last;
        last = temp;
    }
    slow.next = first;
    let res = 0;
    let x = head;
    let y = slow.next;
    while (y != null) {
        res = Math.max(res, x.val + y.val);
        x = x.next;
        y = y.next;
    }
    return res;
};

// Create a linked list from the input array [5,4,2,1]
const head = new ListNode(5, new ListNode(4, new ListNode(2, new ListNode(1))));

console.log(pairSum(head));
