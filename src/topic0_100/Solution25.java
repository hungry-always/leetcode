package topic0_100;

import commmon.ListNode;

public class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode temp = head;
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        while (length >= k) {
            length -= k;
        }
        return null;
    }
}
