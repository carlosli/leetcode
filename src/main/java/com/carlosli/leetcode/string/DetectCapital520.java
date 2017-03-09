package com.carlosli.leetcode.string;

/**
 * Created by yulongli on 2017/3/9.
 */
public class DetectCapital520 {
    /*
    三种情况
    第一个字母大写： 1 后面都小写  2  后面都大写
    第一个字母小写，后面都小写
     */
    public static boolean detectCapitalUse(String word) {
        // 第一个字母小写，后面都小写
        if (Character.isLowerCase(word.charAt(0))) {
            for (int i = 1; i < word.length(); i++) {
                if (!Character.isLowerCase(word.charAt(i))) return false;
            }
            return true;
        }
        // 第一个字是大写
        else {
            if (word.length() == 1) return true;
            // 后面都是小写
            if (Character.isLowerCase(word.charAt(1))) {
                for (int i = 2; i < word.length(); i++) {
                    if (!Character.isLowerCase(word.charAt(i))) return false;
                }
                return true;
            } else { // 后面都是大写
                for (int i = 2; i < word.length(); i++) {
                    if (Character.isLowerCase(word.charAt(i))) return false;
                }
                return true;
            }
        }
    }

    /*
    char 对应的ascii值
    A 65    a  97

    通过如下方式强制转换
    int cock=(int)'a';
    char cock=(char)65;
     */
    public static boolean detectCapitalUse2(String word) {
        int cnt = 0;
        // 判断有几个大写字母
        for (char c : word.toCharArray()) if ('Z' - c >= 0) cnt++;
        // 都是小写字母，都是大写字母，第一个是大写剩下的是小写
        return ((cnt == 0 || cnt == word.length()) || (cnt == 1 && 'Z' - word.charAt(0) >= 0));
    }

    public static boolean detectCapitalUse3(String word) {
        return word.matches("[A-Z]+|[a-z]+|[A-Z][a-z]+");
    }


    public static void main(String[] args) {
        // Google USA leetcode
        System.out.println(detectCapitalUse2("Google"));
        System.out.println(detectCapitalUse2("GooGle"));
        System.out.println(detectCapitalUse2("GSDFDS"));
        System.out.println(detectCapitalUse2("google"));

    }
}
