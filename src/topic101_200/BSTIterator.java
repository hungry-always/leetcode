package topic101_200;

import commmon.TreeNode;

import java.util.Stack;

public class BSTIterator {
    Stack<Integer> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        addStack(root);
    }

    public int next() {
        return stack.pop();
    }

    public boolean hasNext() {
        return stack.isEmpty();
    }

    void addStack(TreeNode root) {
        if (root != null) {
            addStack(root.left);
            stack.add(root.val);
            addStack(root.right);
        }
    }
}
