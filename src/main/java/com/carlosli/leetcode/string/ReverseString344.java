package com.carlosli.leetcode.string;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**
 * Created by yulongli on 2017/3/10.
 */
public class ReverseString344 {

    public static String reverseString(String s) {
        char[] chars = s.toCharArray();
        int head = 0;
        int tail = chars.length - 1;

        while (head < tail) {
            char temp = chars[head];
            chars[head] = chars[tail];
            chars[tail] = temp;
            head++;
            tail--;
        }
        return new String(chars);
    }

    public static String reverseString2(String s) throws UnsupportedEncodingException {
        /*
        该方法可能会出现问题
        s.getBytes()方法是用平台（系统）默认的编码进行，
        当为utf8时，英文占用1byte，方法成立
        当为utf16时，英文占用2byte，方法便不成立，且还有前面2个byte作为字节顺序标记
        (utf16和unicode（其实是UCS-2编码方式，即直接用两个字节存入字符的Unicode码）都会有2个byte做顺序标记)
         */
        byte[] bytes = s.getBytes();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            byte temp = bytes[i];
            bytes[i] = bytes[j];
            bytes[j] = temp;
            i++;
            j--;
        }
        return new String(bytes);
    }

    public static String reverseString3(String s) {
        char[] word = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        /*
        运用异或的性质进行交换 异或：异1同0
        恒等律 A^0 = A
        归零律 A^A = 0
        */
        while (i < j) {
            word[i] = (char) (word[i] ^ word[j]); // A^B
            word[j] = (char) (word[i] ^ word[j]); // A^B ^B = A
            word[i] = (char) (word[i] ^ word[j]); // A^B ^A = B
            i++;
            j--;
        }
        return new String(word);
    }

    public static String reverseString4(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    /*
    O(NlogN)
     */
    public static String reverseString5(String s) {
        int length = s.length();
        if (length <= 1) return s;
        String leftStr = s.substring(0, length / 2);
        String rightStr = s.substring(length / 2, length);
        return reverseString(rightStr) + reverseString(leftStr);
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.println(reverseString("abcd"));
        System.out.println(reverseString("我们"));
        System.out.println(reverseString("abcd我们"));

        System.out.println(reverseString2("abcd"));
        System.out.println(reverseString2("我们"));
        System.out.println(reverseString("abcd我们"));

        System.out.println(reverseString3("abcd"));
        System.out.println(reverseString3("我们"));
        System.out.println(reverseString("abcd我们"));

        System.out.println(reverseString4("abcd"));
        System.out.println(reverseString4("我们"));
        System.out.println(reverseString("abcd我们"));

        System.out.println(reverseString5("abcd"));
        System.out.println(reverseString5("我们"));
        System.out.println(reverseString("abcd我们"));


//        System.out.println(Integer.MAX_VALUE);

        String name = "abcd";
//        String name = "中国a";
        // getBytes() 取的平台默认的值 Charset.defaultCharset()
        byte[] bytes = name.getBytes();
        System.out.println(bytes.length);
        byte[] bytes2 = name.getBytes("utf-8");
        System.out.println(bytes2.length);
        byte[] bytes3 = name.getBytes("utf-16");
        System.out.println(bytes3.length);

        /*---------------通过下面两个可以看出 unincode 开头两个byte是存放的顺序标志--------------*/

        byte[] bytes4 = name.getBytes("unicode");
        System.out.println(bytes4.length);
        byte[] bytes5 = name.getBytes("UnicodeLittle");
        System.out.println(bytes5.length);
        System.out.println("----------------");
        for (byte b : bytes4) System.out.println(b);
        System.out.println("----------------");
        for (byte b : bytes5) System.out.println(b);
        System.out.println("----------------");

        // 显示平台默认的字符编码
        String defaultCharsetName = Charset.defaultCharset().displayName();
        System.out.println("defaultCharsetName:" + defaultCharsetName);

    }
}
