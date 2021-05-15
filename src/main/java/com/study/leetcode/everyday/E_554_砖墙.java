package com.study.leetcode.everyday;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 554. 砖墙
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/5/2 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class E_554_砖墙 {

    /**
     * 砖块与砖块之间存在缝隙，统计缝隙最多的位置，最后通过墙的总长度减去缝隙最多的就可以得到穿过砖块最少的
     */
    public static int leastBricks(List<List<Integer>> wall) {
        // cnt：key -> 某一位置的宽度，value -> 该位置对应的缝隙数量
        // 如果有n块砖的长度等于m，那么cnt(m, cnt.getOrDefault(m, 0) + 1);
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        for (List<Integer> widths : wall) {
            int n = widths.size();
            int sum = 0;
            for (int i = 0; i < n - 1; i++) {
                sum += widths.get(i);
                cnt.put(sum, cnt.getOrDefault(sum, 0) + 1);
            }
        }
        int maxCnt = 0;
        for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
            maxCnt = Math.max(maxCnt, entry.getValue());
        }
        return wall.size() - maxCnt;
    }

    public static void main(String[] args) {

    }
}
