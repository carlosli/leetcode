package com.carlosli.leetcode.string;

import java.util.HashMap;

/**
 * Created by yulongli on 2017/3/9.
 */
public class RansomNote383 {

    /*
    统计每个字符串中 字符出现的次数，前者出现的次数应当小于或等于后者出现的次数
     */
    public static boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> rHashMap = new HashMap<>();
        HashMap<Character, Integer> mHashMap = new HashMap<>();

        for (char c : ransomNote.toCharArray()) {
            if (rHashMap.get(c) == null) {
                rHashMap.put(c, 1);
            } else {
                rHashMap.put(c, rHashMap.get(c) + 1);
            }
        }
        for (char c : magazine.toCharArray()) {
            if (mHashMap.get(c) == null) {
                mHashMap.put(c, 1);
            } else {
                mHashMap.put(c, mHashMap.get(c) + 1);
            }
        }
        for (Character character : rHashMap.keySet()) {
            if (mHashMap.get(character) == null) return false;
            if (rHashMap.get(character) > mHashMap.get(character)) return false;
        }
        return true;
    }

    public static boolean canConstruct2(String ransomNote, String magazine) {
        int[] arr = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            arr[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (--arr[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean canConstruct3(String ransomNote, String magazine) {
        HashMap<Character, Integer> rHashMap = new HashMap<>();
        HashMap<Character, Integer> mHashMap = new HashMap<>();

        for (char c : magazine.toCharArray()) {
            if (mHashMap.get(c) == null) {
                mHashMap.put(c, 1);
            } else {
                mHashMap.put(c, mHashMap.get(c) + 1);
            }
        }

        for (char c : ransomNote.toCharArray()) {
            if (mHashMap.get(c) == null || mHashMap.get(c).equals(0)) return false;
            mHashMap.put(c, mHashMap.get(c) - 1);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct2("aa", "bb"));
        System.out.println(canConstruct2("aa", "aabb"));
        System.out.println(canConstruct2("aa", "ab"));
        System.out.println(canConstruct2("a", "b"));
        System.out.println(canConstruct2("a", "a"));
        System.out.println(canConstruct2("abc", "ajdfjasbjlkjccbjka"));
    }
}
