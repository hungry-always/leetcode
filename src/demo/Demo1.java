package demo;

import commmon.TreeNode;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Demo1 {
    public static void main(String[] args) {
        String path = "/Volumes/LINHAO";
        String str = "【 更多资源： 250java.cn】";
        Queue<String> queue = new LinkedList<>();
        queue.add(path);
        while (!queue.isEmpty()) {
            String poll = queue.poll();
            System.out.println(poll);
            File file = new File(poll);
            if (file.getName().contains(str)) {
                String replace = file.getAbsolutePath().replace(str, "");
                file.renameTo(new File(replace));
            }
            if (file != null && file.isDirectory()) {
                File[] files = file.listFiles();
                if (files != null) {
                    for (File file1 : files) {
                        queue.add(file1.getAbsolutePath());
                    }
                }
            }
        }
    }

    Map<String, Integer> map = new HashMap<>();
    public int maxValue(TreeNode root, int k) {
        return dp(root, k, k);
    }

    private int dp(TreeNode root, int n, int k) {
        String key = "" + root + n + k;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        if (root == null) {
            return 0;
        }
        int result = dp(root.right, k, k) + dp(root.left, k, k);
        if (n > 0) {
            int val = root.val;
            if (val > result) {
                result = val;
            }
            for (int i = 0; i <= n - 1; i++) {
                int value = dp(root.right, i, k) + dp(root.left, n - 1 - i, k);
                result = Math.max(result, value + val);
            }
        }
        map.put(key, result);
        return result;
    }

    @Test
    public void test() {
        TreeNode treeNode = new TreeNode(5);
        treeNode.right = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(2);
        treeNode.left = treeNode1;
        treeNode1.left = new TreeNode(4);
        int i = maxValue(treeNode, 2);
        System.out.println(i);
    }
}
