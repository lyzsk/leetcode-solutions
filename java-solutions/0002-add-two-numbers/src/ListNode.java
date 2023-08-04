/**
 * @author sichu
 * @date 2022/08/16
 **/
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public int print() {
        return val;
    }

    @Override
    public String toString() {
        String res = val + "";
        if (next != null) {
            res += "," + next.toString();
        }
        return res;
    }
}
