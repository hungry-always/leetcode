//package topic0_100;
//
//import commmon.TreeNode;
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.stream.Collectors;
//import java.util.stream.IntStream;
//
//public class Solution95 {
//    public List<TreeNode> generateTrees(int n) {
//        List<Integer> list = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toList());
//        return generateTrees(list);
//    }
//    private List<TreeNode> generateTrees(List<Integer> list) {
//        List<TreeNode> resultList = new ArrayList<>();
//        if (list == null) {
//            resultList.add(null);
//        } else {
//            for (int i = 0; i < list.size(); i++) {
//                List<TreeNode> leftList = generateTrees(copyList(0, i - 1, list));
//                List<TreeNode> rightList = generateTrees(copyList(i + 1, list.size() - 1, list));
//                for (TreeNode left : leftList) {
//                    for (TreeNode right : rightList) {
//                        resultList.add(new TreeNode(list.get(i), left, right));
//                    }
//                }
//            }
//        }
//        return resultList;
//    }
//
//    List<Integer> copyList(int start, int end, List<Integer> list) {
//        if (start > end) {
//            return null;
//        }
//        List<Integer> integerList = new LinkedList<>();
//        for (int i = start; i <=end; i++) {
//            integerList.add(list.get(i));
//        }
//        return integerList;
//    }
//
//    @Test
//    public void test() {
//        List<TreeNode> x = generateTrees(3);
//        System.out.println(x);
//    }
//}
