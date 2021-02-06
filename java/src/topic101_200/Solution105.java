package topic101_200;

import commmon.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * 从前序与中序遍历序列构造二叉树
 */
public class Solution105 {
    HashMap<Integer, Integer> inMap = new HashMap<>();

    // 前序遍历：节点+左+右  中序遍历：左+节点+右
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int start1, int end1, int start2, int end2) {
        if (start1 > end1) {
            return null;
        } else if (start1 == end1) {
            return new TreeNode(preorder[start1]);
        } else {
            int val = preorder[start1];
            TreeNode treeNode = new TreeNode(val);
            Integer index = inMap.get(val);
            int length = index - start2;
            treeNode.left = buildTree(preorder, inorder, start1 + 1, start1 + length, start2, index - 1);
            treeNode.right = buildTree(preorder, inorder, start1 + length + 1, end1, index + 1, end2);
            return treeNode;
        }
    }

    @Test
    public void test() {
        int[] pre = {3, 9, 20, 15, 7};
        int[] in = {9, 3, 15, 20, 7};
        TreeNode treeNode = buildTree(pre, in);
        System.out.println(treeNode);
    }
}
