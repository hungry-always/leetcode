package topic101_200;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LRUCache {
    Map<Integer, Integer> minMap;
    Map<Integer, Integer> valueMap;
    Queue<Integer> queue;
    int cap;

    public LRUCache(int capacity) {
        minMap = new HashMap<>();
        valueMap = new HashMap<>();
        queue = new LinkedList<>();
        cap = capacity;
    }

    public int get(int key) {
        Integer value = valueMap.get(key);
        if (minMap.containsKey(key)) {
            queue.add(key);
            minMap.put(key, minMap.get(key) + 1);
        }
        return value == null ? -1 : value;
    }

    public void put(int key, int value) {
        queue.add(key);
        minMap.put(key, minMap.getOrDefault(key, 0) + 1);
        if (!valueMap.containsKey(key)) {
            if (valueMap.size() == cap) {
                while (!queue.isEmpty()) {
                    Integer poll = queue.poll();
                    if (minMap.get(poll) != 1) {
                        minMap.put(poll, minMap.get(poll) - 1);
                    } else {
                        minMap.remove(poll);
                        valueMap.remove(poll);
                        break;
                    }
                }
            }
        }
        valueMap.put(key, value);
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        int i = lRUCache.get(1);// 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        int i1 = lRUCache.get(2);// 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        int i2 = lRUCache.get(1);// 返回 -1 (未找到)
        int i3 = lRUCache.get(3);// 返回 3
        int i4 = lRUCache.get(4);// 返回 4
    }
}
