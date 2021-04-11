package hard;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class title3 {
}
class MedianFinder {
    int size;
    PriorityQueue<Integer> smallQueue;
    PriorityQueue<Integer> bigQueue;

    /** initialize your data structure here. */
    public MedianFinder() {
        smallQueue = new PriorityQueue<>(Comparator.reverseOrder());
        bigQueue = new PriorityQueue<>();
        size = 0;
    }

    public void addNum(int num) {
        size++;
        if (!smallQueue.isEmpty() && smallQueue.peek() < num) {
            bigQueue.add(num);
            smallQueue.add(bigQueue.poll());
        }else {
            smallQueue.add(num);
        }
        if (smallQueue.size() > (size + 1) / 2) {
            bigQueue.add(smallQueue.poll());
        }
    }

    public double findMedian() {
        return size % 2 != 0 ? smallQueue.peek() : (smallQueue.peek() + bigQueue.peek()) / 2.0;
    }

    @Test
    public void test() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        medianFinder.addNum(31);
        medianFinder.addNum(22);
        medianFinder.addNum(16);
    }
}
