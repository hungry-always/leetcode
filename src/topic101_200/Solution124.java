package topic101_200;

import commmon.TreeNode;
import org.junit.jupiter.api.Test;

public class Solution124 {
    int maxVal = Integer.MIN_VALUE;
    int result = 0;
    public int maxPathSum(TreeNode root) {
        maxPathSum1(root);
        if (result == 0) {
            return maxVal;
        } else {
            return result;
        }
    }
    public int maxPathSum1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int right = maxPathSum1(root.right);
        int left = maxPathSum1(root.left);
        int val = root.val;
        maxVal = Math.max(val, maxVal);
        int max = getMax(right + val, left + val, right + left + val, val, right, left);
        result = Math.max(max, result);
        return getMax(right + val, left + val, left + right + val);
    }

    int getMax(int... ints) {
        if (ints.length <= 0) {
            return Integer.MIN_VALUE;
        } else {
            int max = ints[0];
            for (int i = 0; i < ints.length; i++) {
                max = Math.max(max, ints[i]);
            }
            return max;
        }
    }

    @Test
    public void test() {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(-2);
        treeNode.right = new TreeNode(3);
        System.out.println(maxPathSum(treeNode));
    }
}
