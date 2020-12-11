package topic0_100;

import commmon.ListNode;
import commmon.ListNodeUtil;
import org.junit.jupiter.api.Test;

public class Solution23 {
    ListNode head = new ListNode(0);

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return new ListNode();
        }
        ListNode list = lists[0];
        for (int i = 1; i < lists.length; i++) {
            list = linkTwoNode(list, lists[i]);
        }
        return list;
    }

    private ListNode linkTwoNode(ListNode poll1, ListNode poll2) {
        ListNode temp = head;
        while (poll1 != null || poll2 != null) {
            int val1 = (poll1 != null) ? poll1.val : Integer.MAX_VALUE;
            int val2 = (poll2 != null) ? poll2.val : Integer.MAX_VALUE;
            if (val1 < val2) {
                temp.next = poll1;
                poll1 = poll1.next;
            } else {
                temp.next = poll2;
                poll2 = poll2.next;
            }
            temp = temp.next;
        }
        return head.next;
    }

    @Test
    public void test() {
        ListNode generate1 = ListNodeUtil.generate(new int[]{1, 4, 5});
        ListNode generate2 = ListNodeUtil.generate(new int[]{1, 3, 4});
        ListNode generate3 = ListNodeUtil.generate(new int[]{2, 6});
        ListNode[] listNodes = {generate1, generate2, generate3};
        ListNode listNode = mergeKLists(listNodes);
        System.out.println(listNode);
    }
}
