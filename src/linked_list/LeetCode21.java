package linked_list;

import base.ListNode;

/**
 * @author hanrong on 2017/8/10.
 */
public class LeetCode21 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
//        l1.next = new ListNode(3);
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        LeetCode21 leetCode21 = new LeetCode21();
        ListNode listNode = leetCode21.mergeTwoLists(l1, l2);
        while (listNode != null) {
            System.out.print(listNode.val + "\t");
            listNode = listNode.next;
        }
        System.out.println();
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode nodeHead;
        ListNode curNode;
        if (l1.val <= l2.val) {
            nodeHead = l1;
            curNode = l1;
            l1 = l1.next;
        } else {
            nodeHead = l2;
            curNode = l2;
            l2 = l2.next;
        }
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curNode.next = l1;
                curNode = l1;
                l1 = l1.next;
            } else {
                curNode.next = l2;
                curNode = l2;
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            curNode.next = l1;
        }

        if (l2 != null) {
            curNode.next = l2;
        }
        return nodeHead;
    }
}
