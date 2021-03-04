package com.study.leetcode.strings;

import java.util.List;

/**
 * 1773. 统计匹配检索规则的物品数量
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/3/3 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class L_1773_统计匹配检索规则的物品数量 {

    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int index = ruleKey.equals("type") ? 0 : ruleKey.equals("color") ? 1 : 2;
        int ans = 0;
        for (List<String> itemList : items)
            if (itemList.get(index).equals(ruleValue))
                ans++;

        return ans;
    }

    public static void main(String[] args) {
    }
}
