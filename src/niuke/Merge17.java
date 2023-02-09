package niuke;

import datatruct.ListNode;

/**
 * @Classname Merge17
 * @Description 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * @Date 2019/12/5 21:30
 * @Created by Tengxq
 */
public class Merge17 {
    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = dummyHead;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                p.next = list1;
                list1 = list1.next;
            } else {
                p.next = list2;
                list2 = list2.next;
            }
            p = p.next;
        }
        p.next = list1 == null ? list2 : list1;
        return dummyHead.next;
    }
}
