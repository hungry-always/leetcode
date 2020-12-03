package everyWeek;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class FrontMiddleBackQueue {
    public ArrayList<Integer> list;

    public FrontMiddleBackQueue() {
        list = new ArrayList<>();
    }

    public void pushFront(int val) {
        list.add(0, val);
    }

    public void pushMiddle(int val) {
        int mid = list.size() / 2;
        list.add(mid, val);
    }

    public void pushBack(int val) {
        list.add(val);
    }

    public int popFront() {
        if (list.isEmpty()) {
            return -1;
        } else {
            Integer integer = list.get(0);
            list.remove(0);
            return integer;
        }
    }

    public int popMiddle() {
        if (list.isEmpty()) {
            return -1;
        } else {
            int mid = list.size() / 2;
            if (list.size() % 2 == 0) {
                mid -= 1;
            }
            Integer integer = list.get(mid);
            list.remove(mid);
            return integer;
        }
    }

    public int popBack() {
        if (list.isEmpty()) {
            return -1;
        } else {
            int i = list.size() - 1;
            Integer integer = list.get(i);
            list.remove(i);
            return integer;
        }
    }

    @Test
    public void test() {
        FrontMiddleBackQueue q = new FrontMiddleBackQueue();
        q.pushFront(1);   // [1]
        q.pushBack(2);    // [1, 2]
        q.pushMiddle(3);  // [1, 3, 2]
        q.pushMiddle(4);  // [1, 4, 3, 2]
        System.out.print(q.popFront());
        System.out.print(q.popMiddle());
        System.out.print(q.popMiddle());
        System.out.print(q.popBack());
        System.out.println(q.popFront());
    }
}
