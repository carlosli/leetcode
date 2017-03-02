package com.carlosli.leetcode.binarysearch;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by yulongli on 2017/2/28.
 */
public class Heaters475 {

    /*
    将暖气放到set中，然后对每个房子从范围0到范围最大进行-j+j范围的判断，看看暖气是否能够够得到，若能够到，则更新距离值
    将所有房子统计完成后，最大的距离即为答案
     */
    public static int findRadius(int[] houses, int[] heaters) {
        HashSet<Integer> heatersSet = new HashSet<>();
        for (int heater : heaters) {
            heatersSet.add(heater);
        }

        int max = 0;
        // 循环每一个房子
        for (int i = 0; i <= houses.length - 1; i++) {
            // 对每一个房子进行暖气覆盖范围查找
            // 房子或暖气最大的值
            int largeLength = houses[houses.length - 1] > heaters[heaters.length - 1] ? houses[houses.length - 1] : heaters[heaters.length - 1];
            for (int j = 0; j < largeLength; j++) {
                boolean contains = heatersSet.contains(houses[i] + j);
                boolean contains2 = heatersSet.contains(houses[i] - j);
                if (contains || contains2) {
                    if (max < j) {
                        max = j;
                    }
                    break; // 若有暖气能够覆盖到房子，开始判断下一个房子
                }
            }
        }
        return max;
    }

    /*
    将每个房子与暖气中较近的两个进行比较（通过折半查找，找到合适的位置），取小的值，
    再将每个房子的最小值中取出最大的就是结果
     */
    public static int findRadius2(int[] houses, int[] heaters) {
        /*
        Arrays.binarySearch(array,key)
        如果key包含在数组中，则返回搜索键的索引； (索引从0开始)
        否则返回 -(插入点) 。（索引从1开始）
        array需要是顺序存储的
         */
        Arrays.sort(heaters);
        int max = 0; // 暂存最短的距离
        for (int houseIndex = 0; houseIndex < houses.length; houseIndex++) {
            int house = houses[houseIndex];
            int index = Arrays.binarySearch(heaters, house);
            if (index < 0) {
                // 没有查到，计算出应当插入的位置，索引调整为从0开始
                index = -index - 1;
                int distance1 = Integer.MAX_VALUE;
                if (index < heaters.length) {
                    distance1 = heaters[index] - house;
                }
                int distance2 = Integer.MAX_VALUE;
                if (index - 1 >= 0) {
                    distance2 = house - heaters[index - 1];
                }
                // 比较两个距离中少的那个
                int distance = distance1 < distance2 ? distance1 : distance2;
                // 与max比较，存储为新的较长的距离
                max = max > distance ? max : distance;
            }
        }
        return max;
    }

    public static int findRadius3(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int result = Integer.MIN_VALUE;

        for (int house : houses) {
            int index = Arrays.binarySearch(heaters, house);
            if (index < 0) {
                // 要插入的坐标
                index = -(index + 1);
            }
            int dist1 = index - 1 >= 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
            int dist2 = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;

            result = Math.max(result, Math.min(dist1, dist2));
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(findRadius(new int[]{1, 2, 3, 4, 5}, new int[]{2, 3}));
        /*---------------这两个例子，当方法内距离判断j的最大值需要为房子或暖气的最大值，否则会出现问题--------------*/
        System.out.println(findRadius(new int[]{1, 5}, new int[]{2}));
        System.out.println(findRadius(new int[]{1, 5}, new int[]{10}));


        System.out.println(findRadius3(new int[]{1, 2, 3, 4, 5}, new int[]{2, 3}));
        System.out.println(findRadius3(new int[]{1, 5}, new int[]{2}));
        System.out.println(findRadius3(new int[]{1, 5}, new int[]{10}));
    }
}
