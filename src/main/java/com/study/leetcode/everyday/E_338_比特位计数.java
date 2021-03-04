package com.study.leetcode.everyday;

import com.study.common.util.CommonUtils;

/**
 * 338. 比特位计数
 * 给定一个非负整数num。对于0 ≤ i ≤ num 范围中的每个数字i，计算其二进制数中的 1 的数目并将它们作为数组返回。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2
 * 输出: [0,1,1]
 * 示例2:
 * <p>
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 * 进阶:
 * <p>
 * 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
 * 要求算法的空间复杂度为O(n)。
 * 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的__builtin_popcount）来执行此操作。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/counting-bits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/3/3 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class E_338_比特位计数 {

    public static int[] countBits(int num) {
        int[] ans = new int[num + 1];
        ans[0] = 0;
        for (int i = 1; i <= num; i++) {
            // 对于一个正整数来说
            // 如果这个正整数是奇数，则它的二进制1的个数 = 它右移1位之后的数的二进制1的个数+1 => bit(x) = bit(x >> 1) + 1
            // 如果这个正整数是偶数，则它的二进制1的个数 = 它右移1位之后的数的二进制1的个数 => bit(x) = bit(x >> 1)
            // 那么可以推出 => 奇偶数之间的1的差别为1
            // 那么我们只需要将该数对2取余即可，即bit(x) = bix(x >> 1) + (x & 1) => (x & 1)可以计算出该数对2取余的余数
            ans[i] = ans[i >> 1] + (i & 1);
        }

        return ans;
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

    public static int count1_(int x) {
        int count1 = 0;
        while (x > 0) {
            // 对于任意整数 x, 令 x=x&(x-1)，该运算将 x 的二进制表示的最后一个 1 变成 0
            // 例如x = 4，对应的二进制为 100
            // 将x &= x - 1，100 & 11，可得x = 100 & 11，x = 0
            x &= (x - 1);
            // 每执行一次后count1++即可
            count1++;
        }

        return count1;
    }

    public static void main(String[] args) {
        CommonUtils.printArray(countBits(2));
        CommonUtils.printArray(countBits(5));
    }
}
