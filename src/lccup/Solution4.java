package lccup;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution4 {
    Map<String, Boolean> map = new HashMap<>();
    boolean temp = false, permanent = false;
    int i1, j1;
    int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public boolean escapeMaze(List<List<String>> maze) {
        boolean dfs = dfs(maze, 0, 0, 0);
        return dfs;
    }

    private boolean dfs(List<List<String>> maze, int index, int i, int j) {
        String key = "key" + index + i + j + temp + permanent + i1 + j1;
        if (map.get(key) != null) {
            return map.get(key);
        }
        int size = maze.size();
        int m = maze.get(0).size();
        int n = maze.get(0).get(0).length();
        if (index >= size || i < 0 || i >= m || j < 0 || j >= n) {
            return false;
        }
        if (i == m - 1 && j == n - 1 && ((check(maze, index, i, j)) || !temp || !permanent)) {
            return true;
        }
        boolean flag = false;
        for (int[] direction : directions) {
            int i2 = i + direction[0];
            int j2 = j + direction[1];
            if (check(maze, index, i, j)) {
                flag = flag || dfs(maze, index + 1, i2, j2);
            } else {
                if (!temp) {
                    temp = true;
                    flag = flag || dfs(maze, index + 1, i2, j2);
                    temp = false;
                }
                if (!permanent) {
                    permanent = true;
                    i1 = i;
                    j1 = j;
                    flag = flag || dfs(maze, index + 1, i2, j2);
                    permanent = false;
                }
            }
        }
        map.put(key, flag);
        return flag;
    }

    private boolean check(List<List<String>> maze, int time, int i, int j) {
        List<String> list = maze.get(time);
        return list.get(i).charAt(j) == '.' || (permanent && i1 == i && j1 == j);
    }

    @Test
    public void test() {
//        JSONArray jsonArray = JSONUtil.parseArray("[[\"...\",\"...\",\"...\"],[\".##\",\"###\",\"##.\"],[\".##\",\"###\",\"##.\"],[\".##\",\"###\",\"##.\"],[\".##\",\"###\",\"##.\"],[\".##\",\"###\",\"##.\"],[\".##\",\"###\",\"##.\"]]");
        JSONArray jsonArray = JSONUtil.parseArray("[[\"...\",\".##\",\"##.\",\"#.#\",\".##\",\"...\",\".#.\",\"##.\",\"##.\"],[\".##\",\"###\",\"##.\",\".##\",\".##\",\"##.\",\".#.\",\"###\",\"##.\"],[\".##\",\"###\",\"###\",\".##\",\"##.\",\"##.\",\"#.#\",\"###\",\".#.\"],[\".##\",\"#.#\",\".##\",\"#.#\",\"###\",\"#.#\",\"###\",\"...\",\".#.\"],[\"..#\",\"###\",\"#..\",\".##\",\".##\",\"..#\",\".#.\",\"###\",\".#.\"],[\"..#\",\".#.\",\"..#\",\".##\",\"###\",\"#.#\",\"#..\",\"###\",\"##.\"],[\".##\",\"..#\",\".##\",\".#.\",\"##.\",\"###\",\"##.\",\"###\",\"##.\"],[\".##\",\"..#\",\"#.#\",\".##\",\"###\",\".##\",\"##.\",\".##\",\"#..\"],[\"...\",\"##.\",\"#.#\",\"..#\",\"##.\",\"..#\",\".##\",\"#.#\",\"##.\"],[\".##\",\"###\",\"###\",\"#.#\",\".##\",\".##\",\"###\",\"###\",\"#..\"],[\"..#\",\"###\",\"..#\",\"#..\",\".#.\",\"###\",\"#.#\",\"###\",\".#.\"],[\"..#\",\"###\",\"##.\",\"##.\",\".#.\",\"#..\",\"###\",\"##.\",\".#.\"],[\".##\",\"#.#\",\".#.\",\".##\",\".#.\",\"###\",\".#.\",\"###\",\"##.\"],[\".#.\",\"#.#\",\".##\",\"#..\",\"#.#\",\"##.\",\"###\",\"###\",\"##.\"],[\"..#\",\"###\",\"###\",\"###\",\"##.\",\".#.\",\"##.\",\"###\",\"##.\"],[\"..#\",\"#..\",\".#.\",\"##.\",\"###\",\"...\",\".##\",\"#.#\",\".#.\"],[\".##\",\"###\",\".##\",\".##\",\"###\",\"#..\",\"###\",\"...\",\".#.\"],[\".##\",\".##\",\"##.\",\"#..\",\"###\",\"..#\",\"...\",\"###\",\"##.\"],[\".##\",\"#..\",\"###\",\"###\",\"##.\",\"#..\",\".##\",\"..#\",\"##.\"],[\"...\",\".#.\",\"###\",\"###\",\"###\",\"###\",\"##.\",\"#.#\",\".#.\"],[\".##\",\".#.\",\"#..\",\"#.#\",\"###\",\"##.\",\".#.\",\"###\",\".#.\"],[\"..#\",\"###\",\"###\",\"###\",\"#.#\",\"##.\",\"##.\",\"#.#\",\"#..\"],[\"...\",\"###\",\"###\",\"##.\",\"#.#\",\".#.\",\"#.#\",\"#..\",\".#.\"],[\".##\",\"..#\",\"##.\",\".##\",\"###\",\"#..\",\"#.#\",\"#.#\",\"##.\"],[\"..#\",\"###\",\"###\",\"##.\",\".##\",\".##\",\"#.#\",\"#..\",\".#.\"],[\"..#\",\"..#\",\"#..\",\"...\",\".##\",\"##.\",\"#.#\",\"##.\",\"##.\"],[\".#.\",\"##.\",\"#.#\",\"##.\",\"#.#\",\"##.\",\"###\",\".#.\",\"##.\"],[\".#.\",\"###\",\"..#\",\"###\",\".##\",\"..#\",\".#.\",\"###\",\"##.\"],[\".#.\",\"###\",\"###\",\"##.\",\"###\",\".##\",\"##.\",\"##.\",\".#.\"],[\".#.\",\".##\",\"###\",\".#.\",\".#.\",\".#.\",\"###\",\"###\",\"...\"],[\".##\",\"#.#\",\".##\",\"###\",\"###\",\".##\",\".##\",\".##\",\"##.\"],[\"..#\",\"##.\",\".#.\",\".##\",\"###\",\"###\",\"###\",\".##\",\"##.\"],[\".#.\",\".##\",\"##.\",\"#..\",\"###\",\".#.\",\".#.\",\"#.#\",\"##.\"],[\".#.\",\"###\",\"...\",\"###\",\"##.\",\".#.\",\"#.#\",\".##\",\"##.\"],[\"..#\",\"#..\",\"#.#\",\".##\",\"###\",\"##.\",\".#.\",\"##.\",\"##.\"],[\"..#\",\"##.\",\"###\",\"###\",\"#..\",\"##.\",\"##.\",\".##\",\"##.\"],[\"..#\",\"###\",\".##\",\"..#\",\".#.\",\".##\",\".##\",\"###\",\".#.\"],[\"..#\",\".#.\",\".##\",\".#.\",\".#.\",\".##\",\"#.#\",\"##.\",\"##.\"],[\"..#\",\"###\",\"#..\",\"...\",\"#..\",\".##\",\"..#\",\".##\",\"...\"],[\".##\",\"###\",\"#..\",\"###\",\"#.#\",\"##.\",\"#..\",\"###\",\"##.\"]]");
        List<List<String>> collect = jsonArray.stream()
                .map(s -> JSONUtil.parseArray(s).toList(String.class))
                .collect(Collectors.toList());
        System.out.println(collect);
        boolean b = escapeMaze(collect);
        System.out.println(b);
    }
}

class Solution {
    int len, row, col;
    List<List<String>> m;
    int[][] fs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}, {0, 0}};
    int xP, yP;
    Boolean[][][][][] memo;

    public boolean escapeMaze(List<List<String>> maze) {
        len = maze.size();
        row = maze.get(0).size();
        col = maze.get(0).get(0).length();
        m = maze;
        memo = new Boolean[len][row][col][2][2];
        return dfs(0, 0, 0, 0, 0);
    }

    private boolean dfs(int u, int i, int j, int use1, int use2) {
        if (i == row - 1 && j == col - 1) {
            return true;
        }
        if (u == len - 1) {
            return false;
        }
        if (memo[u][i][j][use1][use2] != null) {
            return memo[u][i][j][use1][use2];
        }
        for (int[] f : fs) {
            int x = i + f[0];
            int y = j + f[1];
            if (x >= 0 && x < row && y >= 0 && y < col) {
                if (m.get(u + 1).get(x).charAt(y) == '.' || x == xP && y == yP) {
                    if (dfs(u + 1, x, y, use1, use2)) {
                        return memo[u][i][j][use1][use2] = true;
                    }
                } else {
                    if (use1 == 0) {
                        if (dfs(u + 1, x, y, 1, use2)) {
                            return memo[u][i][j][use1][use2] = true;
                        }
                    }
                    if (use2 == 0) {
                        xP = x;
                        yP = y;
                        if (dfs(u + 1, x, y, use1, 1)) {
                            return memo[u][i][j][use1][use2] = true;
                        }
                    }
                }
            }
        }
        return memo[u][i][j][use1][use2] = false;
    }
}

