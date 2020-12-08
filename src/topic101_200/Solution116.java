package topic101_200;

import commmon.Node;
import org.junit.jupiter.api.Test;

/**
 * 完美二叉树：填充每个节点的下一个右侧节点指针
 */
public class Solution116 {
    public Node connect(Node root) {
        Node head = root;
        if (head.left != null) {
            while (head != null) {
                head.left.next = head.right;
                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                head = head.next;
            }
            connect(root.left);
        }
        return root;
    }

    @Test
    public void test() {
        Node node = Node.generateNode(new int[]{1, 2, 3, 4, 5, 6, 7});
        Node connect = connect(node);
        System.out.println(connect);
    }
}
