package topic101_200;

public class Solution121 {
    public int maxProfit(int[] prices) {
        int minNumber = prices[0];
        int dis = 0;
        for (int price : prices) {
            dis = Math.max(dis, price - minNumber);
            minNumber = Math.min(minNumber, price);
        }
        return dis;
    }
}
