package topic101_200;

import commmon.ListNode;
import commmon.TreeNode;

public class Solution109 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        } else if (head.next == null) {
            return new TreeNode(head.val);
        } else {
            ListNode show = head;
            ListNode fast = head.next;
            while (fast.next.next != null) {
                fast = fast.next;
                show = show.next;
            }
            ListNode next = fast.next;
            TreeNode treeNode = new TreeNode(next.val);
            treeNode.left = sortedListToBST(head);
            treeNode.right = sortedListToBST(next);
            return treeNode;
        }
    }
}
