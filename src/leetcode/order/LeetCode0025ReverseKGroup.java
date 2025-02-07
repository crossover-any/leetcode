package leetcode.order;

import datatruct.ListNode;

import java.util.List;

public class LeetCode0025ReverseKGroup {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        LeetCode0025ReverseKGroup leetCode0025ReverseKGroup = new LeetCode0025ReverseKGroup();
        leetCode0025ReverseKGroup.reverseKGroup(node1, 2);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        int cnt = 0;

        ListNode dummy = new ListNode(0);
        ListNode p = head;
        ListNode front = head;
        ListNode tail = null;
        ListNode pre = dummy;
        while (p != null) {
            cnt++;
            if (cnt == 1) {
                // 记录头结点位置
                front = p;
            }
            if (cnt == k) {
                tail = p;
                // 将p向后移动一步
                p = p.next;
                // 翻转 front到tail节点 连接前后节点
                pre.next = reverseNode(front, tail);
                front.next = p;
                pre = front;
                // 计数器重置
                cnt = 0;
            } else {
                p = p.next;
            }
        }

        return dummy.next;
    }

    /**
     * 翻转 head----tail
     *
     * @param head 头结点
     * @param tail 尾节点
     * @return tail -> head
     */
    public ListNode reverseNode(ListNode head, ListNode tail) {
        if (head == null || head.next == null || head == tail) {
            // 终止
            return head;
        }
        ListNode nextNode = reverseNode(head.next, tail);
        head.next.next = head;
        head.next = null;
        return nextNode;
    }
}
