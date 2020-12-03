package everyWeek;

import commmon.ListNode;
import org.junit.jupiter.api.Test;

public class Solution2 {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode head = new ListNode();
        head.next = list1;
        ListNode temp = head;
        int count = 0;
        while (count != a) {
            temp = temp.next;
            count++;
        }
        ListNode remove1 = temp;
        while (count != b + 1) {
            temp = temp.next;
            count++;
        }
        ListNode remove2 = temp;
        remove1.next = list2;
        ListNode temp3 = list2;
        while (temp3.next != null) {
            temp3 = temp3.next;
        }
        temp3.next = remove2;
        return head.next;
    }

    @Test
    public void test() {
        ListNode node0 = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode node10 = new ListNode(10);
        ListNode node11 = new ListNode(11);
        ListNode node12 = new ListNode(12);
        node10.next = node11;
        node11.next = node12;
        mergeInBetween(node0, 3, 4, node10);
    }
}
