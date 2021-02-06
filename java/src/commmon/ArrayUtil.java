package commmon;

public class ArrayUtil {
    static int floor = 0;
    static void printArray(Object object) {
        if (object instanceof Object[]) {
            Object[] objects = (Object[]) object;
            printArray(objects);
        }
        System.out.print("数据解析的层数为" + (floor++) + object);
    }

    public static void main(String[] args) {
        int[] ints = {1, 2, 3};
        printArray(ints);
    }
}
