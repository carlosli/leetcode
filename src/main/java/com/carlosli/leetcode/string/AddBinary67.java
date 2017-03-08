package com.carlosli.leetcode.string;

/**
 * Created by yulongli on 2017/3/3.
 */
public class AddBinary67 {

    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;

        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) sum += b.charAt(j--) - '0'; // 取最后一位，通过-‘0’，计算出数值
            if (i >= 0) sum += a.charAt(i--) - '0'; // 通过sum+= 计算出 前面进位过来的+当前位的两个值
            sb.append(sum % 2); // 取进位后余下的值
            carry = sum / 2; // 取出进位值
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }

    public static String addBinary2(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;

        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = ((i < 0) ? 0 : (a.charAt(i--) - '0')) +
                    ((j < 0) ? 0 : (b.charAt(j--) - '0')) +
                    carry;

            sb.append(Integer.toString(sum & 1)); // 取二进制中最后一位，即进位后余下的值
            carry = (sum >> 1) & 1; // 二进制向右移动一位，然后取最后一位，即要进位的数字
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
//        System.out.println(addBinary("111","11"));
        System.out.println(2 & 1);
        System.out.println(6 & 1);
        System.out.println(7 & 1);
        System.out.println(addBinary2("11", "1"));
    }
}
