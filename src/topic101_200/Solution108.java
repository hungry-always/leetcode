package topic101_200;

import commmon.TreeNode;

public class Solution108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return null;
        }
        return sortedArrayToBST(nums, 0, length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = sortedArrayToBST(nums, start, mid - 1);
        treeNode.right = sortedArrayToBST(nums, mid + 1, end);
        return treeNode;
    }
}
