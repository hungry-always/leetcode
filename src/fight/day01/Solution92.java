package fight.day01;

import commmon.ListNode;

public class Solution92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode root = new ListNode();
        root.next = head;
        ListNode result = root;
        int count = 0;
        while (root.next != null) {
            count++;
            if (count == left) {
                ListNode next = root.next;
                ListNode temp = null;
                ListNode subNext = null;
                while (count <= right) {
                    subNext = next.next;
                    next.next = temp;
                    temp = next;
                    next = subNext;
                    count++;
                }
                root.next = temp;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = subNext;
                return result.next;
            } else {
                count++;
            }
        }
        return null;
    }
}
