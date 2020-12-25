package topic101_200;

import commmon.ListNode;
import commmon.ListNodeUtil;
import commmon.TreeNode;
import org.junit.jupiter.api.Test;

public class Solution109 {
    int count = 0;
    ListNode gl = null;

    public TreeNode sortedListToBST(ListNode head) {
        ListNode temp = head;
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        gl = head;
        return generateTree(length-1);
    }

    private TreeNode generateTree(int end) {
        if (end < count) {
            return null;
        } else if (end == count) {
            count++;
            TreeNode treeNode = new TreeNode(gl.val);
            gl = gl.next;
            return treeNode;
        } else {
            int mid = (count + end + 1) / 2;
            TreeNode fir = generateTree(mid-1);
            count++;
            TreeNode treeNode = new TreeNode(gl.val);
            gl = gl.next;
            treeNode.left = fir;
            TreeNode las = generateTree(end);
            treeNode.right = las;
            return treeNode;
        }
    }

    @Test
    public void test() {
        int[] ints = {-10, -3, 0, 5, 9};
        ListNode generate = ListNodeUtil.generate(ints);
        TreeNode treeNode = sortedListToBST(generate);
        System.out.println(treeNode);
    }
}
