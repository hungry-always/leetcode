package generalize.Dijkstra;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution787 {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        // 使用邻接矩阵表示有向图，0 表示不连通
        int[][] graph = new int[n][n];
        for (int[] flight : flights) {
            graph[flight[0]][flight[1]] = flight[2];
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        // 向集合添加一个记录（起点, 费用, 站数限制）的数组，K + 1 表示可以走过站点的个数
        minHeap.offer(new int[]{src, 0, K + 1});

        while (!minHeap.isEmpty()) {
            int[] front = minHeap.poll();
            int v = front[0];
            int price = front[1];
            int k = front[2];

            if (v == dst) {
                return price;
            }

            // 如果还可以中转一个站
            if (k > 0) {
                for (int i = 0; i < n; i++) {
                    // 并且存在一条有向边
                    if (graph[v][i] > 0) {
                        // 优先队列中存入：有向边指向的顶点 i、从起点 src 到 i 的总路径长度、还有多少站可以中转
                        minHeap.offer(new int[]{i, price + graph[v][i], k - 1});
                    }
                }
            }
        }
        return -1;
    }
}
