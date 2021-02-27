package com.study.leetcode.sort;

import com.study.common.util.CommonUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1356. 根据数字二进制下 1 的数目排序
 * <p>
 * 给你一个整数数组arr。请你将数组中的元素按照其二进制表示中数字 1 的数目升序排序。
 * <p>
 * 如果存在多个数字二进制中1的数目相同，则必须将它们按照数值大小升序排列。
 * <p>
 * 请你返回排序后的数组。
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [0,1,2,3,4,5,6,7,8]
 * 输出：[0,1,2,4,8,3,5,6,7]
 * 解释：[0] 是唯一一个有 0 个 1 的数。
 * [1,2,4,8] 都有 1 个 1 。
 * [3,5,6] 有 2 个 1 。
 * [7] 有 3 个 1 。
 * 按照 1 的个数排序得到的结果数组为 [0,1,2,4,8,3,5,6,7]
 * 示例 2：
 * <p>
 * 输入：arr = [1024,512,256,128,64,32,16,8,4,2,1]
 * 输出：[1,2,4,8,16,32,64,128,256,512,1024]
 * 解释：数组中所有整数二进制下都只有 1 个 1 ，所以你需要按照数值大小将它们排序。
 * 示例 3：
 * <p>
 * 输入：arr = [10000,10000]
 * 输出：[10000,10000]
 * 示例 4：
 * <p>
 * 输入：arr = [2,3,5,7,11,13,17,19]
 * 输出：[2,3,5,17,7,11,13,19]
 * 示例 5：
 * <p>
 * 输入：arr = [10,100,1000,10000]
 * 输出：[10,100,10000,1000]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 500
 * 0 <= arr[i] <= 10^4
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-integers-by-the-number-of-1-bits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/2/26 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class LeetCode1356 {

    /**
     * 按照二进制1的数量排序
     * 如果二进制1的数量相等，那么按照值排序
     *
     * @param arr
     * @return
     */
    /**
     * 插入排序解法
     * @param arr
     * @return
     */
    public static int[] sortByBits(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (count1(arr[j]) < count1(arr[j - 1]))
                    exchange(arr, j, j - 1);
                else if (count1(arr[j]) == count1(arr[j - 1]))
                    if (arr[j] < arr[j - 1])
                        exchange(arr, j, j - 1);
            }
        }
        return arr;
    }

    /**
     * 插入排序改进解法
     * @param arr
     * @return
     */
    public static int[] sortByBits1(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int v = arr[i];
            int count1V = count1(v);
            int j;
            int tmp = 0;
            for (j = i; j > 0; j--) {
                int count1PreJ = count1(arr[j - 1]);
                if (count1V < count1PreJ) {
                    arr[j] = arr[j - 1];
                    tmp = j - 1;
                } else if (count1V == count1PreJ)
                    if (v < arr[j - 1]) {
                        arr[j] = arr[j - 1];
                        tmp = j - 1;
                    }
            }
            if (count1V < count1(arr[tmp]))
                arr[tmp] = v;
            else if (count1V == count1(arr[tmp]))
                if (v < arr[tmp])
                    arr[tmp] = v;
        }

        return arr;
    }

    /**
     * 选择排序解法
     * @param arr
     * @return
     */
    public static int[] sortByBits2(int[] arr) {
        int[] bit = new int[10001];
        for (int i = 0; i < arr.length; i++) {
            bit[arr[i]] = count1(arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (bit[arr[j]] < bit[arr[min]])
                    min = j;
                else if (bit[arr[j]] == bit[arr[min]])
                    if (arr[j] < arr[min])
                        min = j;
            }

            if (min != i)
                exchange(arr, i, min);
        }

        return arr;
    }

    /**
     * 将元素对应的二进制1的数量存入到临时数组中，接着通过sort排序元素组
     * @param arr
     * @return
     */
    public static int[] sortByBits3(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int[] bit = new int[10001];
        for (int i : arr) {
            list.add(i);
            bit[i] = count1(i);
        }

        Collections.sort(list, (l1, l2) -> {
            if (bit[l1] != bit[l2])
                return bit[l1] - bit[l2];
            else
                return l1 - l2;
        });

        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }

        return arr;
    }

    /**
     * 修改获取二进制方法
     * @param arr
     * @return
     */
    public static int[] sortByBits4(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i : arr) {
            list.add(i);
        }

        int[] bit = new int[10001];
        for (int i = 1; i < 10001; i++) {
            // 获取某个十进制值的二进制
            bit[i] = bit[i >> 1] + (i & 1);
        }


        Collections.sort(list, (l1, l2) -> {
            if (bit[l1] != bit[l2])
                return bit[l1] - bit[l2];
            else
                return l1 - l2;
        });

        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }

        return arr;
    }

    public static void exchange(int[] arr, int l, int r) {
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }

    public static int count1(int a) {
        int count1 = 0;
        while (a > 0) {
            if (a % 2 == 1)
                count1++;
            a /= 2;
        }
        return count1;
    }

    public static void main(String[] args) {
        System.out.println(count1(5));
//        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        int[] arr = {1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1};
//        int[] arr = {2, 3, 5, 7, 11, 13, 17, 19};
//        int[] arr = {10, 100, 1000, 10000};
//        sortByBits(arr);
        sortByBits4(arr);
        CommonUtils.printArray(arr);
    }
}
