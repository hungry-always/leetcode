package topic101_200;

import commmon.TreeNode;

public class Solution110 {
    public boolean isBalanced(TreeNode root) {
        try {
            getTreeHeight(root);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private int getTreeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int rHeight = getTreeHeight(root.right);
        int lHeight = getTreeHeight(root.left);
        if (Math.abs(rHeight - lHeight) > 1) {
            throw new RuntimeException("已经不是平衡数了");
        }
        return Math.max(rHeight, lHeight) + 1;
    }
}
