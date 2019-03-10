package leetcode.java.array;

import java.util.TreeMap;

public class P729MyCalendarI {

    private TreeMap<Integer, Integer> map;

    public P729MyCalendarI() {
        map = new TreeMap<Integer, Integer>();
    }

    public boolean book(int start, int end) {
        Integer prev = map.floorKey(start), next = map.ceilingKey(start);
        if ((prev == null || map.get(prev) <= start) && (next == null || end <= next)) {
            map.put(start, end);
            return true;
        }
        return false;
    }

}

