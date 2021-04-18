package niuke;

import datatruct.ListNode;

/**
 * @Classname FindKthToTail15
 * @Description TODO
 * @Date 2019/12/5 20:47
 * @Created by Tengxq
 */
public class FindKthToTail15 {
    private ListNode kNode = null;
    public ListNode FindKthToTail(ListNode head,int k) {
        FindNode(head,k);
        return kNode;
    }

    public int FindNode(ListNode node,int k){
        int index =0;
        if(node == null){
            return index;
        }
        index = FindNode(node.next,k)+1;
        if(k == index){
            kNode = node;
        }
        return index;

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
        FindKthToTail15 test = new FindKthToTail15();
        ListNode res = test.FindKthToTail(l1,6);
        System.out.println(res.val);
    }
}
