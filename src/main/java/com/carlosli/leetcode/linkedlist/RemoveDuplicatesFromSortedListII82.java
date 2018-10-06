package com.carlosli.leetcode.linkedlist;

public class RemoveDuplicatesFromSortedListII82 {
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        // 当前后面没有 或者 只有一个点，就不用再看了
        // 这里head其实充当重复的前一个点的角色
        while (head.next != null && head.next.next != null) {
            // 当后面有相同的时候，则进行删除；一直删除到不同为止；
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
        ListNode listNode = deleteDuplicates(ListNode.makeADuplicatesList());
        ListNode.printList(listNode);

    }
}
