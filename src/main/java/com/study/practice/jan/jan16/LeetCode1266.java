package com.study.practice.jan.jan16;

/**
 * 访问所有点的最小时间
 *
 * @author Daniel 2020/1/16
 */
public class LeetCode1266 {

    public static int minTimeToVisitAllPoints(int[][] points) {
        int[] firstPoint = points[0];
        int fx = firstPoint[0];
        int fy = firstPoint[1];
        int totalCost = 0;
        for (int i = 1; i < points.length; i++) {
            int sx = points[i][0];
            int sy = points[i][1];
            int distanceX = Math.abs(fx - sx);
            int distanceY = Math.abs(fy - sy);
            if (distanceX == distanceY) {
                totalCost += distanceX;
            } else if (distanceX < distanceY) {
                int diff = distanceY - distanceX;
                totalCost += (diff + distanceX);
            } else {
                int diff = distanceX - distanceY;
                totalCost += (diff + distanceY);
            }
            fx = sx;
            fy = sy;
        }

        return totalCost;
    }

    public static void main(String[] args) {
//        int[][] points = new int[][] {
//                {1, 1}, {3, 4}, {-1, 0}
//        };
        int[][] points = new int[][] {
                {3, 2}, {-2, 2}
        };

//        for (int[] point : points) {
//            System.out.print("[");
//            for (int i = 0; i < point.length; i++) {
//                if (i == point.length - 1) {
//                    System.out.print(point[i]);
//                } else {
//                    System.out.print(point[i] + ",");
//                }
//            }
//            System.out.print("] -> ");
//        }
//        System.out.print("null\n");
        System.out.println(minTimeToVisitAllPoints(points));
    }
}
