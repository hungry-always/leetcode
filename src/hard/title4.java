package hard;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class title4 {
    public String countOfAtoms(String formula) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        boolean start = false;
        int i = 0;
        while (i < formula.length()) {

        }
        return null;
    }

    @Test
    public void test() {
        LFUCache lfuCache = new LFUCache(2);
        lfuCache.put(1, 1);
        lfuCache.put(2, 2);
        int i = lfuCache.get(1);
        lfuCache.put(3, 3);
        int i1 = lfuCache.get(2);
        int i2 = lfuCache.get(3);
        lfuCache.put(4, 4);
        int i3 = lfuCache.get(1);
        System.out.println("++++++++");
    }
}

class LFUCache {
    PriorityQueue<int[]> priorityQueue;
    Map<Integer, Integer> map;
    Map<Integer, Integer> countMap;
    Map<Integer,Integer> numMap;
    int capacity;
    int num;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.num = 0;
        priorityQueue = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            } else {
                return o1[1] - o2[1];
            }
        });
        map = new HashMap<>();
        countMap = new HashMap<>();
        numMap = new HashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        countMap.put(key, countMap.getOrDefault(key, 0) + 1);
        numMap.put(key, num++);
        return map.get(key);
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (map.containsKey(key)) {
            countMap.put(key, countMap.getOrDefault(key, 0) + 1);
            numMap.put(key, num++);
        } else {
            if (priorityQueue.size() == capacity) {
                while (true) {
                    int[] poll = priorityQueue.poll();
                    int i = poll[2];
                    if (countMap.containsKey(i) || numMap.containsKey(i)) {
                        if (countMap.containsKey(i)) {
                            poll[0] += countMap.get(i);
                            countMap.remove(i);
                        }
                        if (numMap.containsKey(i)) {
                            poll[1] = numMap.get(i);
                            numMap.remove(i);
                        }
                        priorityQueue.add(poll);
                    } else {
                        map.remove(poll[2]);
                        break;
                    }
                }
            }
            priorityQueue.add(new int[]{1, num++, key});
        }
        map.put(key, value);
    }
}