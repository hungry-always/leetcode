//package everyWeek.s14;
//
//import org.junit.jupiter.api.Test;
//
//public class Solution2 {
//    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
//        int result = 0;
//        for (int baseCost : baseCosts) {
//            int count = closestCost(toppingCosts, target - baseCost, 0, 0) + baseCost;
//            if (Math.abs(target - count) < Math.abs(target - result)) {
//                result = count;
//            }
//        }
//        return result;
//    }
//
//    private int closestCost(int[] toppingCosts, int target, int sum, int start) {
//        if (start >= toppingCosts.length||sum==target) {
//            return sum;
//        }
//        int toppingCost = toppingCosts[start];
//        int size = target / toppingCost;
//        int result = sum;
//        for (int i = 0; i <= size; i++) {
//            int sum1 = closestCost(toppingCosts, target, sum + i * toppingCost, start + 1);
//            if (Math.abs(target - sum) >= Math.abs(target - sum1)) {
//                if (Math.abs(target - sum) == Math.abs(target - sum1)&&sum) {
//
//                }
//                result = sum1;
//            }
//        }
//        if (Math.abs(target - sum - (size + 1) * toppingCost) < Math.abs(target - sum)) {
//            result = sum + (size + 1) * toppingCost;
//        }
//        return result;
//    }
//
//    @Test
//    public void test() {
//        int i = closestCost(new int[]{1, 7}, new int[]{3, 4}, 10);
//        System.out.println(i);
//    }
//}
