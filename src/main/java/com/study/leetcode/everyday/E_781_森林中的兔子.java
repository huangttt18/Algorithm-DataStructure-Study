package com.study.leetcode.everyday;

import java.util.HashMap;
import java.util.Map;

/**
 * 781. 森林中的兔子
 *
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/4/4 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class E_781_森林中的兔子 {

    public static int numRabbits(int[] answers) {
        if (answers == null || answers.length == 0)
            return 0;

        int length = answers.length;
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            if (map.get(answers[i]) != null)
                map.put(answers[i], map.get(answers[i]) + 1);
            else
                map.put(answers[i], 1);
        }

        for (Integer key : map.keySet()) {
            int curKeyValue = map.get(key);
            int least = key + 1;
            if (key == 0)
                ans += curKeyValue;
            else if (map.get(key) % least == 0)
                ans += curKeyValue;
            else
                ans += (curKeyValue - curKeyValue % least + least);

        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
