package topic101_200;

import commmon.TreeNode;

public class Solution129 {
    int count = 0;
    public int sumNumbers(TreeNode root) {
        calculate(0, root);
        return count;
    }

    private void calculate(int product, TreeNode root) {
        if (root == null) {
            return;
        }
        product = product * 10 + root.val;
        if (root.left == null && root.right == null) {
            count += product;
        } else {
            calculate(product, root.left);
            calculate(product, root.right);
        }
    }

    public static void main(String[] args) {
        int a = 10;
        a *= 11 + 23;
        System.out.println(a);
    }
}
