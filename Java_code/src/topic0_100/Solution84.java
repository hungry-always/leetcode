//package topic0_100;
//
//import org.junit.jupiter.api.Test;
//
//import java.util.Stack;
//
//public class Solution84 {
//    public int largestRectangleArea(int[] heights) {
//        int n = heights.length;
//        int[] left = new int[n];
//        int[] right = new int[n];
//        Stack<Integer> mono_stack = new Stack<>();
//        for (int i = 0; i < n; i++) {
//            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
//                mono_stack.pop();
//            }
//        }
//    }
//
//    @Test
//    public void test() {
//    }
//}
