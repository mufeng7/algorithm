package leetcode.greedy;

import java.util.*;

public class fivesix {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        LinkedList<int[]> list = new LinkedList<>();
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++){
            if (intervals[i][0] <= list.getLast()[1]){
                int start = list.getLast()[0];
                int end = Math.max(list.getLast()[1],intervals[i][1]);
                list.pollLast();
                list.addLast(new int[]{start,end});
            }else {
                list.addLast(intervals[i]);
            }
        }
        return list.toArray(new int[0][0]);
    }
}
