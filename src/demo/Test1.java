package demo;

import java.util.ArrayList;
import java.util.List;

public class Test1 {
}

class MyHashMap {
    private final int size = 1 << 22;
    List<Hash>[] array = new List[size];

    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        init(key);
        List<Hash> hashList = array[hash(key)];
        for (int i = 0; i < hashList.size(); i++) {
            Hash hash = hashList.get(i);
            if (hash.key == key) {
                hash.value = value;
                return;
            }
        }
        hashList.add(new Hash(key, value));
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        init(key);
        List<Hash> hashList = array[hash(key)];
        for (int i = 0; i < hashList.size(); i++) {
            Hash hash = hashList.get(i);
            if (hash.key == key) {
                return hash.value;
            }
        }
        return -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        init(key);
        List<Hash> list = array[hash(key)];
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).key == key) {
                list.remove(i);
                break;
            }
        }
    }

    public int hash(int key) {
        return key & (size - 1);
    }

    public void init(int key) {
        int hash = hash(key);
        if (array[hash] == null) {
            array[hash] = new ArrayList<>();
        }
    }

    public Hash getHashByKey(int key) {
        init(key);
        List<Hash> hashes = array[hash(key)];
        for (int i = 0; i < hashes.size(); i++) {
            if (hashes.get(i).key == key) {
                return hashes.get(i);
            }
        }
        return null;
    }

    class Hash {
        int key;
        int value;

        public Hash(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
