package other;

import commmon.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class Solution1609 {
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        if (root.val % 2 == 0) {
            return false;
        }
        boolean isEven = false;
        while (!queue.isEmpty()) {
            TreeNode poll = null;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                if (poll == null) {
                    poll = queue.poll();
                    if (isEven) {
                        if (poll.val % 2 != 0) {
                            return false;
                        }
                    } else {
                        if (poll.val % 2 != 1) {
                            return false;
                        }
                    }
                } else {
                    TreeNode poll1 = queue.poll();
                    int val = poll1.val;
                    if (isEven) {
                        if (val >= poll.val || val % 2 != 0) {
                            return false;
                        }
                    } else {
                        if (val <= poll.val || val % 2 != 1) {
                            return false;
                        }
                    }
                    poll = poll1;
                }
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            isEven = !isEven;
        }
        return true;
    }

    @Test
    public void test() {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(10);
        TreeNode treeNode2 = new TreeNode(4);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode1.left = new TreeNode(3);
        treeNode1.right = new TreeNode(5);
        treeNode2.left = new TreeNode(7);
        treeNode2.right = new TreeNode(9);
        System.out.println(isEvenOddTree(treeNode));
    }
}
