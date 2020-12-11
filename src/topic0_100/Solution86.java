package topic0_100;

import commmon.ListNode;
import commmon.ListNodeUtil;
import org.junit.jupiter.api.Test;

public class Solution86 {
    public ListNode partition(ListNode head, int x) {
        ListNode head1 = new ListNode();
        ListNode temp1 = head1;
        ListNode head2 = new ListNode();
        ListNode temp2 = head2;
        while (head != null) {
            int val = head.val;
            if (val < x) {
                temp1.next = head;
                temp1 = temp1.next;
            } else {
                temp2.next = head;
                temp2 = temp2.next;
            }
            head = head.next;
        }
        temp1.next = head2.next;
        temp2.next = null;
        return head1.next;
    }

    @Test
    public void test() {
        ListNode generate = ListNodeUtil.generate(new int[]{1, 4, 3, 2, 5, 2});
        ListNode partition = partition(generate, 3);
    }
}
