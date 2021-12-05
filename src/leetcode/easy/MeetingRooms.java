package leetcode.easy;

import java.util.Arrays;

public class MeetingRooms {
    public static void main(String[] args) {
        System.out.println(solve(new int[][]{{1, 3}, {3, 7}}));
    }

    public static boolean solve(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        boolean isCorrect = false;
        for (int i = 1; i < intervals.length; i++) {
            int[] a = intervals[i - 1];
            int[] b = intervals[i];
            isCorrect = b[0] > a[1];
            if (!isCorrect) break;
        }
        return isCorrect;
    }


}
