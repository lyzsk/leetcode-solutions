/**
 * @author sichu
 * @date 2022/10/13
 **/
public class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
