package com.carlosli.leetcode.subsetPermutation;

import java.util.ArrayList;
import java.util.Arrays;

public class PermutationsII47 {
    public static void main(String[] args) {
        PermutationsII47 permutations47 = new PermutationsII47();
        permutations47.permute(new int[]{1, 2,1});
    }

    public void permute(int[] nums) {
        Arrays.sort(nums);
        ArrayList<Integer> arrayList = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        permutationHelper(arrayList, nums, visited);
    }


    public void permutationHelper(ArrayList<Integer> arrayList, int[] nums, boolean[] visited) {
        // 不需要每次打印出来，只有在树的最底层才打印
        if (arrayList.size() == nums.length) {
        System.out.println(Arrays.toString(arrayList.toArray()));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // visited[i] 过滤下一层别把自己又添加进去
            // 最上面已经排序了，所以这里只考虑 前一个与当前是否相同，且前一个是否被用了。若没用则说明是重复的，直接跳过
            if (visited[i] || i != 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            visited[i] = true;
            arrayList.add(nums[i]);
            permutationHelper(arrayList, nums, visited);
            arrayList.remove(arrayList.size() - 1);
            visited[i] = false;
        }
    }

}
