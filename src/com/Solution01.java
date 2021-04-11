package com;

import commmon.TreeNode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.time.Period;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution01 {
    public int storeWater(int[] bucket, int[] vat) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> getTime(o2, bucket, vat) - getTime(o1, bucket, vat));
        PriorityQueue<Integer> queue1 = new PriorityQueue<>(Comparator.comparingInt(o -> getTime(o, bucket, vat)));
        for (int i = 0; i < bucket.length; i++) {
            queue.add(i);
        }
        int add = 0;
        int time = add + getTime(queue.peek(), bucket, vat);
        if (time == 0) {
            return 0;
        }
        while (true) {
            int time1 = getTime(queue.peek(), bucket, vat);
            if (time1 <= 1) {
                break;
            }
            while (getTime(queue.peek(), bucket, vat) == time1 && time1 > 1) {
                Integer poll = queue.poll();
                bucket[poll]++;
                queue.add(poll);
                add++;
            }
            if (getTime(queue.peek(), bucket, vat) + add <= time) {
                time = getTime(queue.peek(), bucket, vat) + add;
//                System.out.println(1);
            } else {
                break;
            }
        }
        return time;
    }

    private int getTime(Integer index, int[] bucket, int[] vat) {
        if (vat[index] == 0) {
            return 0;
        }
        if (bucket[index] == 0) {
            return Integer.MAX_VALUE / 2;
        }
        int i = vat[index] / bucket[index];
        if (vat[index] % bucket[index] != 0) {
            i++;
        }
        return i;
    }

    @Test
    public void test() {
        int[] bucket = {0};
//        int[] bucket = {1, 3};
        int[] vat = {1};
//        int[] vat = {6, 8};
        int i = storeWater(bucket, vat);
        System.out.println(i);
    }
}
