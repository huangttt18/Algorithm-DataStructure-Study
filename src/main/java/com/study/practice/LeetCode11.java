package com.study.practice;

/**
 * 盛最多水的容器
 *
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点i,ai) 。在坐标内画 n 条垂直线，垂直线 i的两个端点分别为i,ai) 和 (i, 0) 。找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2020/11/18 </a>
 * @since <span>1.0</span>
 */
public class LeetCode11 {


    /**
     * 双指针法：定义两个指针分别指向数组的头部和尾部，然后比较两个元素的大小，小的一侧++，同时计算当前面积大小
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public static int maxArea(int[] height) {
        int maxArea = 0;
        int length = height.length;
        for (int i = 0, j = length - 1; i < j; ) {
            int minHeight = height[i] > height[j] ? height[j--] : height[i++];
            int area = minHeight * (j - i + 1);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    /**
     * 暴力解法：双层循环遍历并取面积最大的值
     *
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     */
    public static int maxArea2(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = 1; j < height.length; j++) {
                // 外层循环[0, height - 1)，内层循环[1, height - 1]，保证了内外循环的元素永远不重复
                int minHeight = Math.min(height[i], height[j]);
                int area = minHeight * (j - i);
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = new int[] {1,8,6,2,5,4,8,3,9};
        System.out.println(maxArea(height));
        System.out.println(maxArea2(height));
    }
}
