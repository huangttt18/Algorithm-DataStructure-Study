package com.study.leetcode.binarysearch;

import java.util.Arrays;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/4/26 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class L_34_在排序数组中查找元素的第一个和最后一个位置 {

    public static int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        int length = nums.length;
        int left = 0, right = length - 1;
        if (length == 0)
            return ans;
        while (left < right) {
            int mid = left + right >> 1;
            if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid;
        }

        if (nums[left] != target)
            return ans;
        ans[0] = left;
        left = 0;
        right = length - 1;

        while (left < right) {
            int mid = left + right + 1 >> 1;
            if (nums[mid] > target)
                right = mid - 1;
            else
                left = mid;
        }
        ans[1] = left;
        return ans;
    }

    public static int[] searchRange3(int[] nums, int target) {
        int[] ans = {-1, -1};
//        int length = nums.length;
//        int left = 0, right = length - 1;
//        if (length == 0)
//            return ans;
//        while (left < right) {
//            int mid = left + right >> 1;
//            if (nums[mid] < target)
//                left = mid + 1;
//            else
//                right = mid;
//        }
//
//        if (nums[left] != target)
//            return ans;
//        ans[0] = left;
//        int tmp = left;
//        while (nums[tmp] == target)
//            tmp++;
//        ans[1] = tmp - 1;
        return ans;
    }

    public static int[] searchRange2(int[] nums, int target) {
        int[] ans = {-1, -1};
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i] && ans[0] == -1)
                ans[0] = i;
            else if (target == nums[i] && ans[0] != -1)
                ans[1] = i;
        }
        if (ans[0] != -1 && ans[1] == -1)
            ans[1] = ans[0];
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        int[] nums2 = {5,7,7,8,8,10};
        int target2 = 6;
        int[] nums3 = {1};
        int target3 = 1;
        int[] nums4 = {};
        int target4 = 0;
//        Arrays.stream(searchRange2(nums, target)).forEach(System.out::println);
//        Arrays.stream(searchRange2(nums2, target2)).forEach(System.out::println);
//        Arrays.stream(searchRange2(nums3, target3)).forEach(System.out::println);
//        Arrays.stream(searchRange2(nums4, target4)).forEach(System.out::println);
//        Arrays.stream(searchRange(nums, target)).forEach(System.out::println);
//        Arrays.stream(searchRange(nums2, target2)).forEach(System.out::println);
//        Arrays.stream(searchRange(nums3, target3)).forEach(System.out::println);
//        Arrays.stream(searchRange(nums4, target4)).forEach(System.out::println);
        Arrays.stream(searchRange3(nums, target)).forEach(System.out::println);
        Arrays.stream(searchRange3(nums2, target2)).forEach(System.out::println);
        Arrays.stream(searchRange3(nums3, target3)).forEach(System.out::println);
        Arrays.stream(searchRange3(nums4, target4)).forEach(System.out::println);
    }
}
