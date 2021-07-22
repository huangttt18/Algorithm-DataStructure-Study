package com.study.leetcode.everyday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 面试题 10.02. 变位词组
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel - 2021/7/18</a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class E_面试题_10_02_变位词组 {

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        // 对每个字符串进行排序然后作为key，然后将对应的未排序的字符串存入map
        for (String s : strs) {
            char[] array = s.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> value = map.getOrDefault(key, new ArrayList<>());
            value.add(s);
            map.put(key, value);
        }
        List<List<String>> ans = new ArrayList<>();
        for (List<String> v : map.values()) {
            ans.add(v);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("tae".hashCode() == "ate".hashCode());
    }

}
