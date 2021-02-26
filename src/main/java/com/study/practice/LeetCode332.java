package com.study.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * 322. 零钱兑换
 *
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回-1。
 *
 * 你可以认为每种硬币的数量是无限的。
 *
 * 
 *
 * 示例1：
 *
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 *
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 *
 * 输入：coins = [1], amount = 0
 * 输出：0
 * 示例 4：
 *
 * 输入：coins = [1], amount = 1
 * 输出：1
 * 示例 5：
 *
 * 输入：coins = [1], amount = 2
 * 输出：2
 * 
 *
 * 提示：
 *
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/2/22 </a>
 * @since <span>1.0</span>
 */
public class LeetCode332 {

    static int res = Integer.MAX_VALUE;

    static int coinChange2(int[] coins, int amount) {
        if (coins.length == 0)
            return -1;

        List<Integer> dp = new ArrayList<>(amount + 1);

        for (int i = 0; i < amount + 1; i++) {
            dp.add(amount + 1);
        }


        for (int i = 0; i < dp.size(); i++) {
            for (int coin : coins) {
                if (i - coin < 0)
                    continue;
                dp.set(i, Math.min(dp.get(i), 1 + dp.get(i - coin)));
            }
        }

        return dp.get(amount) == amount + 1 ? -1 : dp.get(amount);
    }

    static int coinChange(int[] coins, int amount) {
        if (coins.length == 0)
            return -1;

        dp(coins, amount, 0);

        if (res == Integer.MAX_VALUE)
            return -1;
        return res;
    }

    static void dp(int[] coins, int amount, int count) {
        if (amount < 0)
            // 小于0表示无解
            return;
        if (amount == 0)
            res = Math.min(res, count);

        for (int coin : coins) {
            dp(coins, amount - coin, count + 1);
        }
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(coinChange2(coins, amount));
    }
}
