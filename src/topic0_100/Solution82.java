package topic0_100;

import commmon.ListNode;
import commmon.ListNodeUtil;
import org.junit.jupiter.api.Test;

public class Solution82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode temp = root;
        int dupCount = 1;
        while (root.next.next != null) {
            int val = root.next.next.val;
            if (val == root.next.val) {
                root.next.next = root.next.next.next;
                dupCount++;
                if (root.next.next == null) {
                    root.next = null;
                    break;
                }
            } else {
                if (dupCount >= 2) {
                    root.next = root.next.next;
                } else {
                    root = root.next;
                }
                dupCount = 1;
            }
        }
        return temp.next;
    }

    @Test
    public void test() {
        ListNode generate = ListNodeUtil.generate(new int[]{1, 1});
        ListNode listNode = deleteDuplicates(generate);
        System.out.println(listNode);
    }
}
