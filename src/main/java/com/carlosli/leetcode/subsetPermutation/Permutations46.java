package com.carlosli.leetcode.subsetPermutation;

import java.util.ArrayList;
import java.util.Arrays;

public class Permutations46 {
    public static void main(String[] args) {
        Permutations46 permutations46 = new Permutations46();
        permutations46.permute(new int[]{1, 2, 3});
    }

    public void permute(int[] nums) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        permutationHelper(arrayList, nums);
    }


    public void permutationHelper(ArrayList<Integer> arrayList, int[] nums) {
        // 不需要每次打印出来，只有在树的最底层才打印
        if (arrayList.size() == nums.length) {
            System.out.println(Arrays.toString(arrayList.toArray()));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 若list中已经包含当前要加的数字了，就不再加了
            if (arrayList.contains(nums[i])) continue;

            arrayList.add(nums[i]);
            permutationHelper(arrayList, nums);
            arrayList.remove(arrayList.size() - 1);
        }
    }

}
