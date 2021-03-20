package everyDay.date_2021.Mar;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution3_13 {
}

class MyHashSet {
    private final int size = 1 << 20;

    List<Integer>[] setArr = new List[size];

    public MyHashSet() {
    }

    public void add(int key) {
        init(key);
        int hash = hash(key);
        if (!setArr[hash].contains(key)) {
            setArr[hash].add(key);
        }
    }

    public void remove(int key) {
        init(key);
        int hash = hash(key);
        List<Integer> list = setArr[hash];
        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == key) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            list.remove(index);
        }
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        init(key);
        return setArr[hash(key)].contains(key);
    }

    private int hash(int key) {
        return key & (size - 1);
    }

    private void init(int key) {
        int hash = hash(key);
        if (setArr[hash] == null) {
            setArr[hash] = new ArrayList<>();
        }
    }

    @Test
    public void test() {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);
        System.out.println(myHashSet.contains(1));
        System.out.println(myHashSet.contains(2));
    }
}
class MyHashMap {
    public MyHashMap() {
    }

    public void put(int key, int value) {
    }

    public int get(int key) {
        return 0;
    }

    public void remove(int key) {
    }
}
