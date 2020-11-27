//package topic0_100;
//
//import commmon.ListNode;
//
///**
// * 反转链表
//// */
//public class Solution92 {
//    public ListNode reverseBetween(ListNode head, int m, int n) {
//        int pointer = 1;
//        ListNode temp = head;
//        if (pointer >= m - 1) {
//            temp = temp.next;
//        }
//        ListNode before = temp;
//        temp = temp.next;
//        ListNode next1 = null;
//        while (pointer++ < n-2) {
//            next1 = temp.next;
//            ListNode next2 = next1.next;
//            // temp-2 next1-3 next2-4
//            temp.next = null;
//            next1.next = temp;
//            temp = next2;
//        }
//        ListNode last = temp.next;
//        before.next = temp;
//        temp.next= next1;
//        next1
//    }
//}
