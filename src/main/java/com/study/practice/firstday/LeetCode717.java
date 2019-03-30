package com.study.practice.firstday;

/**
 * @Author Created by Daniel
 */
public class LeetCode717 {

    public static void main(String[] args) {
        System.out.println(isOneBitCharacter1(new int[]{1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 0}));
    }

    /**
     * 我的思路：
     * 遍历数组，次数为bits.length - 2次，保留最后一个元素，因为它始终为0
     * 当bits[i] == 0, i + 1
     * 当bits[i] == 1, i + 2
     * 直到遍历完成，然后比较i和bits.length - 1的值
     * 如果相等，表示当前数组只剩下最后一个元素了，即0，那么必定为一比特字符
     * 如果大于bits.length - 1，那么表示遍历结束时，最后遍历到的那个元素的的值为1，
     * 又因为遍历结束前，所有的元素都是配好对的，所以最后一对数为1 ， 0，不是一比特字符
     * <p>
     * 大神思路：
     * 比较最后一位之前的所有连续为1的元素的个数
     * 如果为偶数个，那么最后一个字符必定为一比特字符
     * 否则为二比特字符
     * 因为，在连续n个1之前的0，不管是单个0还是和1组成了二比特字符，都是配对完成的
     */
    public static boolean isOneBitCharacter(int[] bits) {
        if (bits.length == 0 || bits == null) {
            return false;
        }

        int i;
        for (i = 0; i < bits.length - 1; ) {
            if (bits[i] == 1) {
                i += 2;
                continue;
            }

            if (bits[i] == 0) {
                i += 1;
                continue;
            }
        }

        if (i == bits.length - 1) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isOneBitCharacter1(int[] bits) {
        int count = 0;
        for (int i = bits.length - 2; ; i--) {
            if (bits[i] == 1) {
                count++;
            } else {
                break;
            }
        }

        return count % 2 == 0;
    }
}
