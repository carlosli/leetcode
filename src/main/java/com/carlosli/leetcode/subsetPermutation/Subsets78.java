package com.carlosli.leetcode.subsetPermutation;

import java.util.ArrayList;
import java.util.Arrays;

public class Subsets78 {


    public static void main(String[] args) {
        Subsets78 subsets78 = new Subsets78();
        subsets78.subsets(new int[]{1, 2, 3});
    }

    /**
     * 回溯
     * 相当于构建了一个树
     * --------{}
     * ----1    2   3
     * --12 13  23
     * 123
     *
     * @param nums
     */
    public void subsets(int[] nums) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Arrays.sort(nums);
        subsetHelper(arrayList, nums, 0);
    }

    public void subsetHelper(ArrayList<Integer> arrayList, int[] nums, int position) {
        System.out.println(Arrays.toString(arrayList.toArray()));

        for (int i = position; i < nums.length; i++) {
            arrayList.add(nums[i]);
            subsetHelper(arrayList, nums, i + 1);
            arrayList.remove(arrayList.size() - 1);
        }

    }


}
