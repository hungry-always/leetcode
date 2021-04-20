package topic401_500;

import commmon.TreeNode;
import org.junit.jupiter.api.Test;

public class Solution404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        TreeNode left = root.left;
        if (left != null && left.left == null && left.right != null) {
            sum += left.val;
        }
        if (root.left != null) {
            sum += sumOfLeftLeaves(root.left);
        }
        if (root.right != null) {
            sum += sumOfLeftLeaves(root.right);
        }
        return sum;
    }

    @Test
    public void test() {
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        System.out.println(sumOfLeftLeaves(treeNode));
    }
}
