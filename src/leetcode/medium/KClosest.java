package leetcode.medium;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KClosest {
    public static void main(String[] args) {
        int[][] points = {{2, 2}, {1, 3}, {1, 3}};
        int k = 1;
        int[][] result = solve(points, k);
        for (int[] rst : result) {
            System.out.println(rst[0] + ", " + rst[1]);
        }
    }

    public static int[][] solve(int[][] points, int k) {
//        Queue<int[]> queue = new PriorityQueue<>((a, b) -> (a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1]));
//        Queue<int[]> queue = new PriorityQueue<>((a, b) -> (a[0] * a[0] + a[1] * a[1]) >= (b[0] * b[0] + b[1] * b[1]) ? 1 : -1);
        Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] * a[0] + a[1] * a[1] -b[0] * b[0] + b[1] * b[1];
            }
        });

        for (int i = 0; i < points.length; i++) {
            queue.offer(points[i]);
        }

        points = new int[k][2];
        for (int i = 0; i < k; i++) {
            points[i] = queue.poll();
        }
        return points;
    }
}
