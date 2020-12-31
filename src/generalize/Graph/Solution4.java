package generalize.Graph;

import org.junit.jupiter.api.Test;

import java.util.*;

public class Solution4 {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> result = new LinkedList<>();
        HashMap<String, Integer> countMap = new HashMap<>();
        HashMap<String, LinkedList<String>> map = new HashMap<>();
        for (List<String> ticket : tickets) {
            String s1 = ticket.get(0);
            String s2 = ticket.get(1);
            countMap.put(s1, countMap.getOrDefault(s1, 0) + 1);
            countMap.put(s2, countMap.getOrDefault(s2, 0) + 1);
            LinkedList<String> linkedList1 = map.getOrDefault(s1, new LinkedList<>());
            linkedList1.add(s2);
            map.put(s1, linkedList1);
            LinkedList<String> linkedList2 = map.getOrDefault(s2, new LinkedList<>());
            linkedList2.add(s1);
            map.put(s2, linkedList2);
        }
        for (LinkedList<String> value : map.values()) {
            Collections.sort(value);
        }
        String start = "JFK";
        result.add(start);
        while (countMap.keySet().size() != 0) {
            String end = getEnd(start, map,countMap);
            cutCount(start, countMap);
            cutCount(end, countMap);
            result.add(end);
            start = end;
        }
        return result;
    }

    private String getEnd(String start, HashMap<String, LinkedList<String>> map, HashMap<String, Integer> countMap) {
        LinkedList<String> linkedList = map.get(start);
        while (true) {
            String pop = linkedList.pop();
            if (countMap.containsKey(pop)) {
                return pop;
            }
        }
    }

    private void cutCount(String start, HashMap<String, Integer> countMap) {
        int count = countMap.get(start) - 1;
        if (count == 0) {
            countMap.remove(start);
        } else {
            countMap.put(start, count);
        }
    }

    @Test
    public void test() {
        List<List<String>> lists = new ArrayList<>();
        lists.add(Arrays.asList("JFK","SFO"));
        lists.add(Arrays.asList("JFK","ATL"));
        lists.add(Arrays.asList("SFO","ATL"));
        lists.add(Arrays.asList("ATL","JFK"));
        lists.add(Arrays.asList("ATL","SFO"));
        List<String> itinerary = findItinerary(lists);
        System.out.println(itinerary);
    }
}
