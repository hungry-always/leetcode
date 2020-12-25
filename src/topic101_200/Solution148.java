package topic101_200;

import commmon.ListNode;
import commmon.ListNodeUtil;
import org.junit.jupiter.api.Test;

public class Solution148 {
    public ListNode sortList(ListNode head) {
        if (head == null && head.next == null) {
            return head;
        }
        ListNode root = head;
        int length = 0;
        while (root != null) {
            length++;
            root = root.next;
        }
        root = new ListNode(0);
        root.next = head;
        int subLength = 1;
        while (subLength <= length) {
            ListNode temp = root;
            int count = 0;
            while (length - count > subLength) {
                ListNode temp1 = temp;
                ListNode temp2 = temp;
                int count1 = subLength;
                while (count1 != 0) {
                    temp1 = temp1.next;
                    temp2 = temp2.next.next;
                    count1--;
                }
                ListNode next = temp1.next;
                ListNode next1 = temp2.next;
                temp1.next = null;
                temp = sortListNode(temp, temp.next, next);
                temp.next = next1;
            }
            subLength *= 2;
        }
        return root.next;
    }

    private ListNode sortListNode(ListNode head,ListNode node1, ListNode node2) {
        ListNode result = head;
        while (node1 != null && node2 != null) {
            if (node1 != null && node1.next == null) {
                result = node1;
            }
            if (node2 != null && node2.next == null) {
                result = node2;
            }
            int val1 = node1 == null ? Integer.MAX_VALUE : node1.val;
            int val2 = node2 == null ? Integer.MAX_VALUE : node2.val;
            if (val1 <= val2) {
                head.next = node1;
                node1 = node1.next;
            } else {
                head.next = node2;
                node2 = node2.next;
            }
        }
        return result;
    }

    @Test
    public void test() {
        ListNode generate = ListNodeUtil.generate(new int[]{4, 2, 3, 1});
        ListNode listNode = sortList(generate);
        System.out.println(listNode);
    }
}
