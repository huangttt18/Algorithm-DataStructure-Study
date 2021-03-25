package com.study.leetcode.everyday;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 341. 扁平化嵌套列表迭代器
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/3/23 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class E_341_扁平化嵌套列表迭代器 {

    public static void main(String[] args) {

    }


    private static interface NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    static class NestedIterator implements Iterator<Integer> {

        List<Integer> list;
        int size;
        int cur;

        public NestedIterator(List<NestedInteger> nestedList) {
            list = new ArrayList<>();
            this.cur = 0;
            helper(nestedList);
        }

        @Override
        public Integer next() {
            return list.get(cur++);
        }

        public void helper(List<NestedInteger> in) {
            for (NestedInteger nestedInteger : in) {
                if (nestedInteger.isInteger()) {
                    size++;
                    list.add(nestedInteger.getInteger());
                } else {
                    helper(nestedInteger.getList());
                }
            }
        }

        @Override
        public boolean hasNext() {
            return cur < size;
        }
    }
}
