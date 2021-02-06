package topic101_200;

import commmon.TreeNode;

import java.util.HashMap;

public class Solution106 {
    HashMap<Integer, Integer> inMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int length = inorder.length;
        for (int i = 0; i < length; i++) {
            inMap.put(inorder[i], i);
        }
        return buildTree(postorder, 0, 0, length - 1);
    }

    private TreeNode buildTree(int[] postorder, int start1, int start2, int end2) {
        if (start2 > end2) {
            return null;
        } else if (start2 == end2) {
            return new TreeNode(postorder[end2]);
        } else {
            int val = postorder[end2];
            TreeNode treeNode = new TreeNode(val);
            Integer index = inMap.get(val);
            int length = index - start1;
            treeNode.left = buildTree(postorder, start1, start2, start2 + length - 1);
            treeNode.right = buildTree(postorder, index + 1, start2 + length, end2 - 1);
            return treeNode;
        }
    }
}
