package leetcode.oneperday._20210325deleteDuplicates;

import datatruct.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    /**
     * 总计可以分为两种情况，头部重复，和中间或尾部重复
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dommyHead = new ListNode(Integer.MAX_VALUE);
        if (null != head) {
            ListNode p = head;
            ListNode q = dommyHead;
            while (null != p.next) {
                if (p.val == p.next.val) {
                    p = deleteDuplicates(p,p.val);
                } else {
                    q.next = p;
                    q = q.next;
                    p = p.next;
                }
                if (null == p || p.next == null){
                    q.next = p;
                    break;
                }
            }
        }
        return dommyHead.next;
    }

    public ListNode deleteDuplicates(ListNode head, int repeatValue) {
        if (null != head && repeatValue == head.val) {
            return deleteDuplicates(head.next,repeatValue);
        }
        return head;
    }
}

/**
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * 示例 1:
 *
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 *
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 */
public class deleteDuplicatesDemo {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(1);
        ListNode n6 = new ListNode(1);
        ListNode n7 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        Solution solution = new Solution();
        ListNode listNode = solution.deleteDuplicates(n1);
        while (null != listNode){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
