package topic101_200;

import org.junit.jupiter.api.Test;

import java.util.*;

public class Solution133 {
    public Node cloneGraph(Node node) {
        int count = 0;
        Map<Node,Integer> map = new HashMap<>();
        Map<Integer,Node> copyMap = new HashMap<>();
        Node copyNode = new Node(node.val);
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        count++;
        map.put(node, count);
        copyMap.put(count, copyNode);
        Queue<Node> copyQueue = new LinkedList<>();
        copyQueue.add(copyNode);
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            Node copyPoll = copyQueue.poll();
            List<Node> neighbors = poll.neighbors;
            for (Node neighbor : neighbors) {
                Node node1;
                if (map.containsKey(neighbor)) {
                    Integer key = map.get(neighbor);
                    node1 = copyMap.get(key);
                } else {
                    node1 = new Node(neighbor.val);
                    queue.add(neighbor);
                    copyQueue.add(node1);
                    count++;
                    map.put(neighbor, count);
                    copyMap.put(count, node1);
                }
                copyPoll.neighbors.add(node1);
            }
        }
        return copyNode;
    }

    @Test
    public void test() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);
        Node node = cloneGraph(node1);
        System.out.println(node);
    }
}
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
