package com.study.leetcode.strings;

/**
 * 1108. IP 地址无效化
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/2/27 </a>
 * @since <span>1.0</span>
 */
public class LeetCode1108 {

    public static String defangIPaddr(String address) {
        return address.replaceAll("\\.", "[.]");
    }

    public static void main(String[] args) {
        String address = "1.1.1.1";
        System.out.println("1[.]1[.]1[.]1".equals(defangIPaddr(address)));
    }
}
