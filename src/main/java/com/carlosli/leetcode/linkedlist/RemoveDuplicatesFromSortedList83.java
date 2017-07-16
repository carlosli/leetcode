package com.carlosli.leetcode.linkedlist;

/**
 * Created by yulongli on 2016/11/21.
 */
public class RemoveDuplicatesFromSortedList83 {
    public static ListNode deleteDuplicates(ListNode head) {
        /**
         * 这里与
         * @see RemoveDuplicatesFromSortedListII82
         * 不同的地方在于dummy直接指向了head，而不是dummy.next指向了head
         * 原因是相同的点并不会完全删除，总会保留一点，故而不会使dummy指向错误的list开头
         * 但最好改为与82题相同的方式，避免错误
         */
        ListNode dummy = head;
        while (head != null && head.next != null) {
            // 判断后面两个是否相同
            if (head.next.val == head.val) {
                // 删除第一个
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return dummy;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode listNode = deleteDuplicates(node1);
        ListNode.printList(listNode);

        System.out.println("----------------");

        ListNode node10 = new ListNode(1);
        ListNode.printList(deleteDuplicates(node10));

        System.out.println("----------------");

        ListNode node20 = new ListNode(1);
        ListNode node21 = new ListNode(1);
        ListNode node22 = new ListNode(1);
        node20.next = node21;
        node21.next = node22;
        ListNode.printList(deleteDuplicates(node20));
    }
}
