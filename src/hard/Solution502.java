package hard;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution502 {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        // to speed up: if all projects are available
        boolean speedUp = true;
        for (int c : Capital) {
            if (W < c) {
                speedUp = false;
            }
        }
        if (speedUp) {
            PriorityQueue<Integer> heap = new PriorityQueue<>();
            for (int p : Profits) {
                heap.add(p);
                if (heap.size() > k) {
                    heap.poll();
                }
            }
            for (int h : heap) {
                W += h;
            }
            return W;
        }

        int n = Profits.length;
        // sort the projects
        // the most available (= the smallest capital) is the head of the heap
        PriorityQueue<int[]> projects = new PriorityQueue<>(Comparator.comparingInt(x -> x[0]));
        for (int i = 0; i < n; i++) {
            projects.add(new int[]{Capital[i], Profits[i]});
        }

        // max heap
        PriorityQueue<Integer> available = new PriorityQueue<>((x, y) -> (y - x));
        while (k > 0) {
            // update available projects
            while (!projects.isEmpty() && projects.peek()[0] <= W) {
                available.add(projects.poll()[1]);
            }

            // if there are available projects,
            // pick the most profitable one
            if (!available.isEmpty()) {
                W += available.poll();
            }
            // not enough capital to start any project
            else {
                break;
            }
            --k;
        }
        return W;
    }

    @Test
    public void test() {
        int maximizedCapital = findMaximizedCapital(2, 0, new int[]{1, 2, 3}, new int[]{0, 1, 1});
        System.out.println(maximizedCapital);
    }
}
