package com.study.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/2/24 </a>
 * @since <span>1.0</span>
 */
public class Demo {

    public static int energy(String s) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            char oc = s.charAt(i);
            if (oc == sb.charAt(sb.length() - 1)) {
                sb.append(oc);
            } else {
                list.add(sb.toString());
                sb.delete(0, sb.length());
                sb.append(oc);
                if (i == s.length() - 1) {
                    list.add(sb.toString());
                }
            }
        }

        System.out.println(list);
        int energy = 0;
        for (String s1 : list) {
            if (s1.length() > energy)
                energy = s1.length();
        }

        return energy;
    }

    public static void main(String[] args) {
        String s = "leeeeeeeeeeeetttt";
        System.out.println(energy(s));
    }
}
