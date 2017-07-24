package com.carlosli.leetcode.linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by yulongli on 2016/11/17.
 */
public class MergeKSortedLists23 {

    private static Comparator<ListNode> comparator = new Comparator<ListNode>() {
        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
        }
    };

    /*
    不停的从许多数中拿出最小，再放进去一个，用堆
    该方法复杂度nlogK (K是链表的组数)
    若采用所有元素都放堆里，复杂度变为nlogN

    堆排序：
    堆排序是利用建堆、调整堆两个过程来进行的。首先是根据元素构建堆。
    然后将堆的根节点取出(一般是与最后一个节点进行交换)，将前面len-1个节点继续进行堆调整的过程，然后再将根节点取出，这样一直到所有节点都取出。

    堆排序过程的时间复杂度是O(nlgn)。
    因为建堆的时间复杂度是O(n)（调用一次）；
    调整堆的时间复杂度是lgn，调整堆的过程时间复杂度与堆的深度有关系，因为是沿着深度方向进行调整的。
    调用了n-1次，所以堆排序的时间复杂度是O(nlgn)

     */
    public static ListNode mergeKLists(ListNode[] lists) {
        // 用堆来存储每个链表的第一个值，堆内部会进行排序
        Queue<ListNode> heap = new PriorityQueue<>(lists.length, comparator);

        // 建堆
        for (int i = 0; i < lists.length; i++) {
            heap.add(lists[i]);
        }

        ListNode dummy = new ListNode(0);
        ListNode head = dummy;

        while (!heap.isEmpty()) {
            ListNode poll = heap.poll();
            if (poll != null) {
                head.next = poll;
                head = head.next;
                if (poll.next != null)
                    heap.add(poll.next);
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node4 = new ListNode(4);
        ListNode node9 = new ListNode(9);
        ListNode node10 = new ListNode(10);
        node1.next = node4;
        node4.next = node9;
        node9.next = node10;
        node10.next = null;

        ListNode node2 = new ListNode(2);
        ListNode node7 = new ListNode(7);
        ListNode node12 = new ListNode(12);
        node2.next = node7;
        node7.next = node12;
        node12.next = null;

        ListNode node3 = new ListNode(3);
        ListNode node8 = new ListNode(8);
        ListNode node11 = new ListNode(11);
        node3.next = node8;
        node8.next = node11;
        node11.next = null;


        ListNode[] lists = new ListNode[3];
        lists[0] = node1;
        lists[1] = node2;
        lists[2] = node3;

        ListNode listNode = mergeKLists(lists);

        ListNode.printList(listNode);
    }
}
