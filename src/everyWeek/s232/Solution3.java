package everyWeek.s232;

import commmon.ArraysUtils;
import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

public class Solution3 {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<StClass> queue = new PriorityQueue<>((o1, o2) -> o1.marginal <= o2.marginal ? 1 : -1);
        for (int[] aClass : classes) {
            queue.add(new StClass(aClass[1], aClass[0]));
        }
        while (extraStudents >= 1) {
            assert queue.peek() != null;
            queue.peek().add();
            extraStudents--;
        }
        double total = 0;
        for (StClass stClass : queue) {
            total += (stClass.pass * 1.00000 / stClass.total);
        }
        return total / queue.size();
    }
    class StClass{
        int total;
        int pass;
        double marginal;

        public StClass(int total, int pass) {
            this.total = total;
            this.pass = pass;
            setBj();
        }

        public void add() {
            this.total += 1;
            this.pass += 1;
            setBj();
        }

        void setBj() {
            double v = pass;
            double u = total;
            this.marginal = (v + 1) / (u + 1) - v / u;
        }
    }

    @Test
    public void test() {
        int[][] ints = ArraysUtils.generateTwo("[[1,2],[3,5],[2,2]]");
        double v = maxAverageRatio(ints, 2);
        System.out.println(v);
    }
}
