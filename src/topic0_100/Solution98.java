//package topic0_100;
//
//import commmon.TreeNode;
//
//import java.util.LinkedList;
//import java.util.Queue;
//
//public class Solution98 {
//    Queue<Integer> queue = new LinkedList<>();
//    public boolean isValidBST(TreeNode root) {
//
//        return true;
//    }
//
//    private boolean traverse(TreeNode root) {
//        if (root != null) {
//            traverse(root.left);
//            queue.add(root.val);
//            traverse(root.right);
//        }
//    }
//}
