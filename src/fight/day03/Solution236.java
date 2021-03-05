package fight.day03;

import commmon.TreeNode;

public class Solution236 {
    TreeNode treeNode = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        check(root, p, q);
        return treeNode;
    }

    private boolean[] check(TreeNode root, TreeNode p, TreeNode q) {
        boolean[] bs = new boolean[2];
        if (treeNode != null || root == null) {
            return bs;
        }
        boolean[] check1 = check(root.right, p, q);
        boolean[] check2 = check(root.left, p, q);
        bs[0] = check1[0] || check2[0] || root.val == p.val;
        bs[1] = check1[1] || check2[1] || root.val == q.val;
        if (bs[0] && bs[1] && treeNode != null) {
            treeNode = root;
        }
        return bs;
    }
}
