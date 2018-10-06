package com.carlosli.leetcode.linkedlist;

/**
 * Created by yulongli on 2016/11/21.
 */
public class ReverseLinkedList206 {

    /*
    (n+1)n/2
    复杂度n^2
     */
    public static ListNode reverseList(ListNode head) {

        if (head == null) return null;
        if (head.next == null) return head;

        // 计算长度
        ListNode lengthNode = head;
        int length = 0;
        while (lengthNode.next != null) {
            lengthNode = lengthNode.next;
            length++;
        }
        length++;

        // 临时变量，指定list头
        ListNode gummy = new ListNode(Integer.MIN_VALUE);
        gummy.next = head;

        // 第一次把第一位挪到最后，第二次把第二位挪到倒数第二，第三次把第三位挪到倒数第三。。。。。
        for (int i = length; i - 1 > 0; i--) {
            ListNode innerHead = gummy;
            for (int j = 0; j < i - 1; j++) { // 有点类似冒泡
                ListNode innerFirst = innerHead;
                ListNode innerSecond = innerHead.next;
                ListNode innerThird = innerHead.next.next;
                ListNode innerFour = innerHead.next.next.next;
                innerFirst.next = innerThird;
                innerThird.next = innerSecond;
                innerSecond.next = innerFour;
                innerHead = innerHead.next;
                ListNode.printList(innerHead);
            }
        }
        return gummy.next;
    }

    // 1>2>3>4>5  变为  1<2<3<4<5
    public static ListNode reverseList2(ListNode head) {
        ListNode pre = null;
        ListNode foot = head;
        while (foot != null) {
            ListNode nextFoot = foot.next;
            foot.next = pre;
            pre = foot;
            foot = nextFoot;
        }
        return pre;
    }

    /*
    递归询问终止节点p再哪里，同时将关联关系进行转换
    如 1>2>3>4<5<6
     */
    public static ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) return head;
        // 这个p是为了能传递回最后的元素作为新的第一个元素
        ListNode p = reverseList3(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public static void main(String[] args) {
        ListNode.printList(reverseList(ListNode.makeANormalList()));
        System.out.println("\n----------------");
        ListNode.printList(reverseList2(ListNode.makeANormalList()));
        System.out.println("\n----------------");
        ListNode.printList(reverseList3(ListNode.makeANormalList()));
    }
}
