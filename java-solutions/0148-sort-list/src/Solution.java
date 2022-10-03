import java.util.Arrays;

/**
 * @author sichu
 * @date 2022/10/03
 **/
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode ptr = head;
        int cnt = 0;
        while (ptr != null) {
            ++cnt;
            ptr = ptr.next;
        }
        ptr = head;
        int[] arr = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            arr[i] = ptr.val;
            ptr = ptr.next;
        }
        Arrays.sort(arr);
        ptr = head;
        for (int i = 0; i < cnt; i++) {
            ptr.val = arr[i];
            ptr = ptr.next;
        }
        return head;
    }
}
