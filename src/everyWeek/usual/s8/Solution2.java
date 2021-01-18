package everyWeek.usual.s8;

import commmon.ListNode;
import commmon.ListNodeUtil;
import org.junit.jupiter.api.Test;

public class Solution2 {
    public ListNode swapNodes(ListNode head, int k) {
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        int k2 = count - k;
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode listNode1 = null, listNode2 = null;
        ListNode listNode3 = null, listNode4 = null;
        count = 0;
        temp = root;
        while (temp != null) {
            if (count == k - 1) {
                listNode1 = temp;
            }
            if (count == k) {
                listNode2 = temp;
            }
            if (count == k2) {
                listNode3 = temp;
            }
            if (count == k2 + 1) {
                listNode4 = temp;
            }
            temp = temp.next;
            count++;
        }
        if (listNode2 == listNode4) {
            ListNode next = listNode1.next;
            ListNode next1 = next.next;
            next.next = next1.next;
            next1.next = next;
            listNode1.next = next1;
            return root.next;
        }
        ListNode next = listNode4.next;
        listNode1.next = listNode4;
        listNode4.next = listNode2.next;
        listNode3.next = listNode2;
        listNode2.next = next;
        return root.next;
    }

    @Test
    public void test() {
        ListNode generate = ListNodeUtil.generate(new int[]{100, 90});
        ListNode listNode = swapNodes(generate, 2);
        System.out.println(listNode);
    }
}
