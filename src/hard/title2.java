package hard;

import commmon.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class title2 {
    int index = 0;
    String nullStr = "null";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> list = new ArrayList<>();
        addList(root, list);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i != list.size() - 1) {
                sb.append("-");
            }
        }
        return sb.toString();
    }

    private void addList(TreeNode root, List<String> list) {
        if (root == null) {
            list.add(nullStr);
        } else {
            list.add(root.val)
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> list = Arrays.stream(data.split("-")).collect(Collectors.toList());
        if (list.isEmpty() || list.get(0).equals(nullStr)) {
            return null;
        } else {
            TreeNode listNode = new TreeNode(Integer.parseInt(list.get(0)));
            int index = 1;
            fillList(listNode.left, list);
            return listNode;
        }
    }

    private void fillList(TreeNode treeNode, List<String> list) {
        if (index < list.size()) {
            String s1 = list.get(index++);
            treeNode.left = new TreeNode(Integer.parseInt(s1));
            fillList(treeNode.left, list);
        }
        if (index < list.size()) {
            String s2 = list.get(index++);
            treeNode.right = new TreeNode(Integer.parseInt(s2));
            fillList(treeNode.right, list);
        }
    }
}
