package everyWeek.s14;

import java.util.List;

public class Solution1 {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count = 0;
        for (List<String> item : items) {
            switch (ruleKey) {
                case "type":
                    if (item.get(0).equals(ruleValue)) {
                        count++;
                    }
                    break;
                case "color":
                    if (item.get(1).equals(ruleValue)) {
                        count++;
                    }
                    break;
                case "name":
                    if (item.get(2).equals(ruleValue)) {
                        count++;
                    }
                    break;
                default:
            }
        }
        return count;
    }
}
