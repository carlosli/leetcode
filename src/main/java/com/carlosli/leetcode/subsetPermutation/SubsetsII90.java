package com.carlosli.leetcode.subsetPermutation;

import java.util.ArrayList;
import java.util.Arrays;

public class SubsetsII90 {


    public static void main(String[] args) {
        SubsetsII90 subsets78 = new SubsetsII90();
        subsets78.subsets(new int[]{1, 2, 2});
    }

    /**
     * 回溯
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
            // 下面这种不行，忽略了【122】 这种子集形式
//            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {

            // 非连续的 相同数字 不再添加（比如122，在2位组合时，已经有了12，再添加第二个2组成12时，不再添加了）
            if (i != position && nums[i] != nums[i - 1]) continue;

            arrayList.add(nums[i]);
            subsetHelper(arrayList, nums, i + 1);
            arrayList.remove(arrayList.size() - 1);
        }

    }


}
