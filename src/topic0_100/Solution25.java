package topic0_100;

import commmon.ListNode;
import commmon.ListNodeUtil;
import org.junit.jupiter.api.Test;

public class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode result = new ListNode(0);
        ListNode root = result;
        while (true) {
            // 检验是否还剩k个数
            int count = 0;
            ListNode temp = head;
            while (count != k && temp != null) {
                count++;
                temp = temp.next;
            }
            if (count != k) {
                break;
            }
            while (count != 0) {
                count--;
                ListNode headNext = head.next;
                ListNode rootNext = root.next;
                root.next = head;
                head.next = rootNext;
                head = headNext;
            }
            while (count != k) {
                count++;
                root = root.next;
            }
        }
        root.next = head;
        return result.next;
    }

    @Test
    public void test() {
        ListNode generate = ListNodeUtil.generate(new int[]{1, 2, 3, 4, 5});
        ListNode listNode = reverseKGroup(generate, 2);
        System.out.println(listNode);
    }
}
