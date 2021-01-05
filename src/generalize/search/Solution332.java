package generalize.search;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class Solution332 {
    Map<String, PriorityQueue<String>> map = new HashMap<>();
    List<String> itinerary = new LinkedList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            String key = ticket.get(0);
            if (!map.containsKey(key)) {
                map.put(key, new PriorityQueue<>());
            }
            map.get(key).offer(ticket.get(1));
        }
        dfs("JFK");
        Collections.reverse(itinerary);
        return itinerary;
    }

    private void dfs(String curr) {
        while (map.containsKey(curr) && !map.get(curr).isEmpty()) {
            String poll = map.get(curr).poll();
            dfs(poll);
        }
        itinerary.add(curr);
    }

    @Test
    public void test() {
        JSONArray objects = JSONUtil.parseArray("[[\"JFK\",\"SFO\"],[\"JFK\",\"ATL\"],[\"SFO\",\"ATL\"],[\"ATL\",\"JFK\"],[\"ATL\",\"SFO\"]]");
        List<List<String>> collect = objects.stream().map(a -> JSONUtil.parseArray(a).toList(String.class)).collect(Collectors.toList());
        System.out.println(findItinerary(collect));
    }
}
