package fight.day01;

import commmon.ListNode;

import java.util.Stack;

public class Solution445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        ListNode l3 = l1, l4 = l2;
        while (l1 != null) {
            stack1.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.add(l2.val);
            l2 = l2.next;
        }
        boolean flag = false;
        ListNode temp = null;
        while (flag || !stack1.isEmpty() || !stack2.isEmpty()) {
            int sum = (stack1.isEmpty() ? 0 : stack1.pop()) + (stack2.isEmpty() ? 0 : stack2.pop()) + ((flag) ? 1 : 0);
            flag = false;
            if (sum >= 10) {
                sum -= 10;
                flag = true;
            }
            ListNode listNode = new ListNode(sum);
            listNode.next = temp;
            temp = listNode;
        }
        return temp;
    }
}
