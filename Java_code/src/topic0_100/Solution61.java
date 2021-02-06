package topic0_100;

import commmon.ListNode;
import commmon.ListNodeUtil;
import org.junit.jupiter.api.Test;

/**
 * 旋转链表
 */
public class Solution61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        int count = 1;
        ListNode connect = head;
        while (connect.next != null) {
            count++;
            connect = connect.next;
        }
        k = count - k % count;
        connect.next = head;
        while (k != 0) {
            k--;
            connect = connect.next;
        }
        ListNode next = connect.next;
        connect.next = null;
        return next;
    }

    @Test
    public void test() {
        ListNode generate = ListNodeUtil.generate(new int[]{0, 1, 2});
        ListNode listNode = rotateRight(generate, 4);
        System.out.println(listNode);
    }
}
