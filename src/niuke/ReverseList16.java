package niuke;

import datatruct.ListNode;

/**
 * @Classname ReverseList16
 * @Description 输入一个链表，反转链表后，输出新链表的表头。
 * @Date 2019/12/5 21:16
 * @Created by Tengxq
 */
public class ReverseList16 {
    public ListNode ReverseList(ListNode head) {
        if(head.next == null){
            return head;
        }
        ListNode temp = ReverseList(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }

}
