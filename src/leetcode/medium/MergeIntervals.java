package leetcode.medium;

import java.lang.reflect.Array;
import java.util.*;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        intervals = new int[][]{{1, 4}, {5, 6}};
        for (int[] interval : solve(intervals)) {
            System.out.println(interval[0] + ", " + interval[1]);
        }
    }

    public static int[][] solve(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (end >= intervals[i][0]) {
                end = Math.max(end, intervals[i][1]);
            } else {
                list.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        list.add(new int[]{start, end});
        return list.toArray(new int[list.size()][]);
    }

//    public static int[][] solve(int[][] intervals) {
//        if (intervals.length == 1) return intervals;
//        Queue<int[]> queue = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
//        int len = intervals.length;
//        int idx = 0;
//
//        queue.offer(intervals[0]);
//        for (int i = 1; i < intervals.length; i++) {
//            int a = intervals[i - 1][1];
//            int b = intervals[i][0];
//            if (a >= b) {
//                queue.poll();
//                queue.offer(new int[]{Math.min(intervals[i - 1][0], intervals[i][0]), Math.max(intervals[i - 1][1], intervals[i][1])});
//            } else {
//                queue.offer(intervals[i]);
//            }
//        }
//
//        int[][] result = new int[queue.size()][2];
//        int i = 0;
//        while (!queue.isEmpty()) {
//            result[i++] = queue.poll();
//        }
//        return result;
//    }
}
