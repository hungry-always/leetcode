package commmon;

import java.util.LinkedList;
import java.util.Queue;

public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

    public static Node generateNode(int[] nums) {
        if (nums.length <= 0) {
            return null;
        }
        int index = 0;
        Node root = new Node(nums[0]);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty() && index < nums.length-1) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                Node left = new Node(nums[++index]);
                Node right = new Node(nums[++index]);
                poll.left = left;
                poll.right = right;
                queue.add(left);
                queue.add(right);
            }
        }
        return root;
    }
}
