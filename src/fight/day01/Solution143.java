package fight.day01;

import commmon.ListNode;
import org.junit.jupiter.api.Test;

public class Solution143 {
    public void reorderList(ListNode head) {
        if(head == null){
            return;
        }
        ListNode temp = head;
        int n = 0;
        // 计算链表的长度
        while (temp != null) {
            n++;
            temp = temp.next;
        }
        int count = 0;
        temp = head;
        while (true) {
            count++;
            // n+1为了奇数前面列表多余后面的
            if(count == (n + 1) / 2){
                ListNode temp2 = temp.next;
                temp.next = null;
                temp = temp2;
                break;
            }else{
                temp = temp.next;
            }
        }
        temp = swapListNode(temp);
        ListNode root = new ListNode();
        ListNode result = root;
        while (temp != null || head != null) {
            ListNode next = head.next;
            head.next = null;
            root.next = head;
            root = root.next;
            head = next;
            if(temp!=null){
                next = temp.next;
                temp.next = null;
                root.next = temp;
                root = root.next;
                temp = next;
            }
        }
        head = result.next;
    }

    // 倒序链表
    private ListNode swapListNode(ListNode listNode) {
        if (listNode == null || listNode.next == null) {
            return listNode;
        }
        ListNode temp = null;
        while (listNode != null) {
            ListNode next = listNode.next;
            listNode.next = temp;
            temp = listNode;
            listNode = next;
        }
        return temp;
    }

    @Test
    public void test() {
        ListNode listNode = new ListNode(1);
        reorderList(listNode);
    }
}
