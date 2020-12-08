package topic101_200;

import commmon.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的右视图
 */
public class Solution199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean isAdd = false;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (!isAdd && poll != null) {
                    list.add(poll.val);
                    isAdd = true;
                }
                if (poll != null) {
                    if (poll.right != null) {
                        queue.add(poll.right);
                    }
                    if (poll.left != null) {
                        queue.add(poll.left);
                    }
                }
            }
        }
        return list;
    }

    @Test
    public void test() {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        List<Integer> list = rightSideView(treeNode1);
        System.out.println(list);
    }
}
