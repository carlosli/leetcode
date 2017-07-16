package com.carlosli.leetcode.linkedlist;

public class RemoveDuplicatesFromSortedListII82 {
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        // 当前后面没有 或者 只有一个点，就不用再看了
        // 这里head其实充当重复的前一个点的角色
        while (head.next != null && head.next.next != null) {
            // 当后面有相同的时候进行判断1-1-2; 这种就不需要判断了1-2-3;
            if (head.next.val == head.next.next.val) {
                // 把相同的全部删除
                int temp = head.next.val;
                // 这里不判断空的话，结尾是两个相同的就会异常，结尾是单个数字就不会（根本就不会进到if里）
                while (head.next != null && temp == head.next.val)
                    head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        ListNode listNode = deleteDuplicates(node1);
        ListNode.printList(listNode);

    }
}
