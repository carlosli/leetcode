package com.carlosli.leetcode.string;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yulongli on 2017/3/15.
 */
public class ReverseVowelsOfAString345 {

    /*
    两个指针，遇到元音换

    Given s = "hello", return "holle".
    Given s = "leetcode", return "leotcede".

     */
    public static String reverseVowels(String s) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');

        char[] chars = s.toCharArray();
        int pre = 0;
        int after = chars.length - 1;

        while (pre < after) {
            if (set.contains(chars[pre]) && set.contains(chars[after])) {
                char temp = chars[pre];
                chars[pre] = chars[after];
                chars[after] = temp;
                pre++;
                after--;
            } else if (!set.contains(chars[pre])) {
                pre++;
            } else if (!set.contains(chars[after])) {
                after--;
            }
        }
        return new String(chars);

    }

    public static String reverseVowels2(String s) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');

        char[] chars = s.toCharArray();
        int pre = 0;
        int after = chars.length - 1;

        while (pre < after) {
            if (set.contains(chars[pre]) && set.contains(chars[after])) {
                chars[pre] = (char) (chars[pre] ^ chars[after]);
                chars[after] = (char) (chars[pre] ^ chars[after]);
                chars[pre] = (char) (chars[pre] ^ chars[after]);
                pre++;
                after--;
            } else if (!set.contains(chars[pre])) {
                pre++;
            } else if (!set.contains(chars[after])) {
                after--;
            }
        }
        return new String(chars);

    }

    public static String reverseVowels3(String s) {
        String vowels = "aeiouAEIOU";

        char[] chars = s.toCharArray();
        int pre = 0;
        int after = chars.length - 1;

        while (pre < after) {

            while (!vowels.contains(chars[pre] + "") && pre < after) {
                pre++;
            }
            while (!vowels.contains(chars[after] + "") && pre < after) {
                after--;
            }

            // 这里置换不能用位运算置换，因最后指针会指向同一个字符，
            // 最后会出现空的情况 "hello" 变为 "hol e"
            char temp = chars[pre];
            chars[pre] = chars[after];
            chars[after] = temp;
            pre++;
            after--;
        }
        return new String(chars);

    }

    public static void main(String[] args) {
        System.out.println(reverseVowels("leetcode"));
        System.out.println(reverseVowels("hello"));
        System.out.println(reverseVowels("aA"));
        System.out.println("----------------");
        System.out.println(reverseVowels2("leetcode"));
        System.out.println(reverseVowels2("hello"));
        System.out.println(reverseVowels2("aA"));
        System.out.println("----------------");
        System.out.println(reverseVowels3("leetcode"));
        System.out.println(reverseVowels3("hello"));
        System.out.println(reverseVowels3("aA"));
        System.out.println("----------------");
    }
}
