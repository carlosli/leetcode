package com.carlosli.leetcode.array;

import java.util.Arrays;

/**
 * Created by yulongli on 2016/10/27.
 */
public class RotateArray189 {

    /*
    会进行k次置换
     */
    public static void rotate(int[] nums, int k) {
        int temp = 0;
        while (k-- > 0) {
            temp = nums[nums.length - 1];
            for (int i = nums.length - 1; i > 0; i--) {
                nums[i] = nums[i - 1];
            }
            nums[0] = temp;
        }
    }

    /*
    直接计算出新的位置，然后放到一个新的数组中的对应位置
     */
    public static void rotate2(int[] nums, int k) {
        int[] newNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            // 移动k步后，除以原来的长度，取模，得出新的位置
            newNums[(i + k) % nums.length] = nums[i];
        }

        // 从新数组中转存回来
        for (int i = 0; i < nums.length; i++) {
            nums[i] = newNums[i];
        }
    }

    /**
     * 当nums的长度 n%k=0，  n、k 有公因数，当挪动会分成公因数组，如 (1)23(4)56(7)89
     * 按照下面的方法进行替换，会回到原始位置(停止条件为start=current,见下代码)，故并不是所有位置的都替换了,
     * 一共需要替换k次？？
     * <p>
     * 如
     * 123456 k=3,一圈过后  (4)23(1)56   所以需要经过三轮替换，才能完全换完
     * <p>
     * 在替换过程中，进行计数，达到总数后即可
     *
     * @param nums
     * @param k
     */
    public static void rotate3(int[] nums, int k) {
        k = k % nums.length; // 避免挪动位置太多（已经大于了原数组的长度），直接计算出挪动后的新位置
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }

    /*
    * 三步翻转法
    * 思路是先把前n-k个数字翻转一下，再把后k个数字翻转一下，最后再把整个数组翻转一下：
    * 例如：1234567  k=3
            1 2 3 4  5 6 7
            4 3 2 1  5 6 7
            4 3 2 1  7 6 5
            5 6 7 1  2 3 4
    */
    public static void rotate4(int[] nums, int k) {
        if (nums.length == 0 || (k % nums.length) == 0) return;
        int n = nums.length;
        reverse(nums, 0, n - k - 1);
        reverse(nums, n - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
//        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        rotate(nums, 3);
//        rotate2(nums, 3);
//        rotate3(nums, 2);
        rotate4(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}
