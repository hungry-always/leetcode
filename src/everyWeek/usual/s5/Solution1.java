package everyWeek.usual.s5;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution1 {
    public int countStudents(int[] students, int[] sandwiches) {
        Stack<Integer> stack = new Stack<>();
//        for (int sandwich : sandwiches) {
//            stack.push(sandwich);
//        }
        for (int length = sandwiches.length - 1; length >= 0; length--) {
            stack.push(sandwiches[length]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int student : students) {
            queue.add(student);
        }
//        for (int length = students.length - 1; length >= 0; length--) {
//            queue.add(students[length]);
//        }
        int count = 0;
        while (!stack.isEmpty()) {
            Integer pop = stack.peek();
            Integer poll = queue.poll();
            if (pop.equals(poll)) {
                count = 0;
                stack.pop();
            } else {
                count++;
                queue.add(poll);
                if (count == queue.size()) {
                    break;
                }
            }
        }
        return queue.size();
    }

    @Test
    public void test() {
        int[] ints = {1, 1, 1, 0, 0, 1};
        int[] ints1 = {1, 0, 0, 0, 1, 1};
        int i = countStudents(ints, ints1);
        System.out.println(i);
    }
}
