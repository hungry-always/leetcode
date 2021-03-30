package topic301_400;

import commmon.ListNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Solution341 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode root = new ListNode(101);
        root.next = head;
        ListNode temp = root;
        boolean flag = false;
        while (temp.next.next != null) {
            if (temp.next.val == temp.next.next.val) {
                temp.next = temp.next.next;
                flag = true;
            } else {
                if (flag) {
                    temp.next = temp.next.next;
                    flag = false;
                }
            }
        }
        if (flag) {
            temp.next = null;
        }
        return root.next;
    }

    @Test
    public void test() {
        NestedIterator nestedIterator = new NestedIterator(List.of(new NestedInteger(1), new NestedInteger(List.of(new NestedInteger(23), new NestedInteger(3)))));
        while (nestedIterator.hasNext()) {
            System.out.println(nestedIterator.next());
        }
    }
}


class NestedIterator implements Iterator<Integer> {
    int index = 0;
    List<Integer> list;

    public NestedIterator(List<NestedInteger> nestedList) {
        list = new ArrayList<>();
        addIntToList(nestedList);
    }

    private void addIntToList(List<NestedInteger> nestedList) {
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                list.add(nestedInteger.getInteger());
            } else {
                addIntToList(nestedInteger.getList());
            }
        }
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            return -1;
        }
        Integer integer = list.get(index);
        index++;
        return integer;
    }

    @Override
    public boolean hasNext() {
        return index <= list.size() - 1;
    }
}

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
class NestedInteger {
    Integer anInt = null;
    List<NestedInteger> list = null;

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger() {
        return anInt != null;
    }

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger() {
        return anInt;
    }

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList() {
        return list;
    }

    public NestedInteger(Integer anInt) {
        this.anInt = anInt;
    }

    public NestedInteger(List<NestedInteger> list) {
        this.list = list;
    }
}


