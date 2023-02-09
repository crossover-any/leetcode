package leetcode.oneperday._20210327rotateRight;


import datatruct.ListNode;

import java.util.List;

/**
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * 解决方案一： 主要是对头结点、尾节点的处理（链表长度len、实际移动 k%l = m,）
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (null == head) {
            return head;
        }
        int len = 1;
        int m = 0;
        ListNode p = head;
        ListNode q = null;
        while (null != p.next) {
            len++;
            p = p.next;
        }
        q = p;
        p = head;
        m = k % len;
        if (m > 0) {
            q.next = head;
            //如果向右移m位，那么新的尾结点是 len-m;头节点是 len - m + 1
            for (int i = 1; i < len - m; i++) {
                p = p.next;
            }
            head = p.next;
            p.next = null;
        }
        return head;
    }
}

/**
 * xxx
 *
 * @author: tengxq
 * @since: 2021-03-27 21:52
 */
public class rotateRightDemo {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        Solution solution = new Solution();
        ListNode listNode = solution.rotateRight(n1, 8);
        while (null != listNode) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
