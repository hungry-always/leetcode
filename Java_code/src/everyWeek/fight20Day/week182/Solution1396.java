package everyWeek.fight20Day.week182;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Solution1396 {
}

class UndergroundSystem {
    // 用户信息存放
    Map<Integer, StartStation> stationMap;
    Map<Process, Time> processTimeMap;

    public UndergroundSystem() {
        stationMap = new HashMap<>();
        processTimeMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        stationMap.put(id, new StartStation(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        StartStation startStation = stationMap.get(id);
        Process key = new Process(startStation.stationName, stationName);
        Time time = processTimeMap.getOrDefault(key, new Time());
        time.count++;
        time.total += (t - startStation.startTime);
        processTimeMap.put(key, time);
    }

    public double getAverageTime(String startStation, String endStation) {
        Process process = new Process(startStation, endStation);
        Time time = processTimeMap.get(process);
        return time.total / time.count;
    }

    class Time {
        int count;
        double total;
    }

    class StartStation {
        String stationName;
        int startTime;

        public StartStation(String stationName, int startTime) {
            this.stationName = stationName;
            this.startTime = startTime;
        }
    }

    class Process {
        String startName;
        String endName;

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Process)) {
                return false;
            }
            Process process = (Process) o;
            return startName.equals(process.startName) && endName.equals(process.endName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(startName, endName);
        }

        public Process(String startName, String endName) {
            this.startName = startName;
            this.endName = endName;
        }
    }
}
