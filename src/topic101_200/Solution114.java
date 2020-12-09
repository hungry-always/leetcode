package topic101_200;

import commmon.TreeNode;
import org.junit.jupiter.api.Test;

public class Solution114 {
    TreeNode head = new TreeNode(1);

    public void flatten(TreeNode root) {
        addNode(root);
    }

    public void addNode(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = null;
        head.right = root;
        head = root;
        addNode(left);
        addNode(right);
    }

    @Test
    public void test() {
//        TreeNode treeNode1 = new TreeNode(1);
//        TreeNode treeNode2 = new TreeNode(2);
//        TreeNode treeNode3 = new TreeNode(3);
//        TreeNode treeNode4 = new TreeNode(4);
//        TreeNode treeNode5 = new TreeNode(5);
//        TreeNode treeNode6 = new TreeNode(6);
//        treeNode1.left = treeNode2;
//        treeNode1.right = treeNode5;
//        treeNode5.right = treeNode6;
//        treeNode2.left = treeNode3;
//        treeNode2.right = treeNode4;
        TreeNode treeNode = new TreeNode(0);
        flatten(treeNode);
        System.out.println(treeNode);
    }
}
