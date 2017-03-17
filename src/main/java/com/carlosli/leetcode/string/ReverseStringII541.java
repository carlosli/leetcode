package com.carlosli.leetcode.string;

import java.io.UnsupportedEncodingException;

/**
 * 给定一个字符串和一个整数k，每2k个字符翻转前k个字符。
 * 如果剩余字符不足k个，则全部翻转。
 * 如果剩余字符在k到2k之间，则翻转前k个字符，剩余字符保持原样。
 * <p>
 * Created by yulongli on 2017/3/15.
 */
public class ReverseStringII541 {

    public static String reverseStr(String s, int k) {
        StringBuffer newStringBuffer = new StringBuffer();

        int point = 0;
        while (point < s.length()) {
            String substring = "";
            if (point + k + k <= s.length()) {
                // 还剩的数量 >　2k
                substring = s.substring(point, point + k);
            } else if (point + k < s.length()) {
                // k　<　还剩的数量　<　2k
                substring = s.substring(point, point + k);
            } else {
                // 还剩的数量 < k
                substring = s.substring(point);
            }

            StringBuffer reverse = new StringBuffer(substring).reverse();

            if (point + k + k <= s.length()) {
                // 还剩的数量 >　2k
                newStringBuffer.append(reverse);
                newStringBuffer.append(s.substring(point + k, point + k + k));
            } else if (point + k < s.length()) {
                // k　<　还剩的数量　<　2k
                newStringBuffer.append(reverse);
                newStringBuffer.append(s.substring(point + k));
            } else {
                // 还剩的数量 < k
                newStringBuffer.append(reverse);
            }

            point = point + k + k;
        }
        return newStringBuffer.toString();
    }

    public static String reverseStr2(String s, int k) {
        StringBuffer ret = new StringBuffer();
        int start = 0;
        int end = start + 2 * k;
        int mid = start + k;
        // 先把前面能够符合最标准的转换了
        while (end <= s.length()) {
            StringBuffer temp = new StringBuffer(s.substring(start, mid));
            ret.append(temp.reverse());
            ret.append(s.substring(mid, end));
            start = end;
            end = start + 2 * k;
            mid = start + k;
        }
        // 考虑结尾的三种情况
        // 正好结束了
        if (start == s.length()) return ret.toString();
        // 剩下的小于k个，全部翻转
        if (mid >= s.length()) {
            StringBuffer temp = new StringBuffer(s.substring(start, s.length()));
            ret.append(temp.reverse());
            return ret.toString();
        }
        // k<剩下的<2k
        if (mid < s.length() && end >= s.length()) {
            StringBuffer temp = new StringBuffer(s.substring(start, mid));
            ret.append(temp.reverse());
            ret.append(s.substring(mid, s.length()));
            return ret.toString();
        }
        return null;
    }


    public static String reverseStr3(String s, int k) {
        StringBuilder sb = new StringBuilder();

        int i = 0, j = 0;
        while (i < s.length()) {
            // first k
            j = i + k <= s.length() ? i + k : s.length();
            sb.append((new StringBuilder(s.substring(i, j))).reverse().toString());

            if (j >= s.length()) break;

            // second k
            i = j;
            j = i + k <= s.length() ? i + k : s.length();
            sb.append(s.substring(i, j));

            i = j;
        }

        return sb.toString();
    }

    /*
    只管前k个，后面的k个完全不管 （按照规则，只要是前面的k个，都需要翻转）
     */
    public static String reverseStr4(String s, int k) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int i = 0;
        while (i < n) {
            int j = Math.min(i + k - 1, n - 1);
            swap(arr, i, j);
            i += 2 * k;
        }
        return String.valueOf(arr);
    }

    private static void swap(char[] arr, int l, int r) {
        while (l < r) {
            char temp = arr[l];
            arr[l++] = arr[r];
            arr[r--] = temp;
        }
    }


    public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.println(reverseStr("123456789", 2));
        System.out.println(reverseStr("12345678", 2));
        System.out.println(reverseStr("1234567", 2));
        System.out.println(reverseStr("123456", 2));
        System.out.println(reverseStr("12345678", 3));
        System.out.println("----------------");
        System.out.println(reverseStr2("123456789", 2));
        System.out.println(reverseStr2("12345678", 2));
        System.out.println(reverseStr2("1234567", 2));
        System.out.println(reverseStr2("123456", 2));
        System.out.println(reverseStr2("12345678", 3));
        System.out.println("----------------");
        System.out.println(reverseStr3("123456789", 2));
        System.out.println(reverseStr3("12345678", 2));
        System.out.println(reverseStr3("1234567", 2));
        System.out.println(reverseStr3("123456", 2));
        System.out.println(reverseStr3("12345678", 3));
        System.out.println("----------------");
        System.out.println(reverseStr4("123456789", 2));
        System.out.println(reverseStr4("12345678", 2));
        System.out.println(reverseStr4("1234567", 2));
        System.out.println(reverseStr4("123456", 2));
        System.out.println(reverseStr4("12345678", 3));
    }
}
