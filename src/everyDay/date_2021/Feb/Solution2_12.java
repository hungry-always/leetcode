package everyDay.date_2021.Feb;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

public class Solution2_12 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        switch (rowIndex) {
            case 0:
                break;
            case 1:
                list.add(1);
                break;
            default:
                List<Integer> rowList = getRow(rowIndex - 1);
                for (int i = 0; i < rowList.size()-1; i++) {
                    list.add(rowList.get(i) + rowList.get(i + 1));
                }
                list.add(1);
                break;
        }
        return list;
    }

    @Test
    public void test() {
        List<Integer> row = getRow(3);
        System.out.println(row);
    }
}
