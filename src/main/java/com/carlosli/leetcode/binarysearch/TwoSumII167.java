package com.carlosli.leetcode.binarysearch;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yulongli on 2017/2/23.
 */
public class TwoSumII167 {

    public static int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement) + 1, i + 1};
            }
            map.put(numbers[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /*
    两个指针，同时往中间聚拢，O(n)
     */
    public static int[] twoSum2(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            } else if (sum == target) {
                return new int[]{left + 1, right + 1};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{2, 3, 4, 6, 7};

        int[] ints = TwoSumII167.twoSum2(numbers, 10);
        System.out.println(ints[0] + ":" + ints[1]);

    }
}
