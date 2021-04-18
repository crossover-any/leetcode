package niuke;

import datatruct.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname printListFromTailToHead2
 * @Description TODO
 * @Date 2019/11/13 22:17
 * @Created by Tengxq
 */
public class printListFromTailToHead2 {
    private ArrayList<Integer> res ;
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        recursion(listNode,1);
        return res;
    }

    public void recursion(ListNode listNode,int n){
        if(listNode .next == null){
            res = new ArrayList(n );
            res.add(listNode.val);
            return ;
        }
        recursion(listNode.next,n+1);
        res.add(listNode.val);
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        printListFromTailToHead2 test = new printListFromTailToHead2();
        List<Integer> res = test.printListFromTailToHead(l1);
        System.out.println(res.toString());

    }
}
