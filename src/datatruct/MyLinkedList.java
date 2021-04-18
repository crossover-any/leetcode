package datatruct;

/**
 * @Classname MyLinkedList
 * @Description TODO
 * @Date 2019/11/8 23:50
 * @Created by Tengxq
 */
class MyLinkedList {

    private ListNode root;
    private ListNode foot;
    private int size;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        root = new ListNode(0);
        size = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index > -1 && index < size){
            int i = 0;
            ListNode p = root.next;
            while(i<index){
                i++;
                p = p.next;
            }
            return p.val;
        }else{
            return -1;
        }
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode node = new ListNode(val);
        node.next = root .next;
        root.next = node;
        if (node.next == null){
            foot = node;
        }
        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode node = new ListNode(val);
        if (foot == null){
            root.next = node;
            foot = node;
        }else{
            foot.next = node;
            foot = node;
        }
        size++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index >0 && index <size){
            int i = 0;
            ListNode p = root;
            while (i<index){
                p = p.next;
                i++;
            }
            ListNode node = new ListNode(val);
            node.next = p.next;
            p.next = node;
            size++;
        }else if(index<=0){
            addAtHead(val);
        }else if (index == size){
            addAtTail(val);
        }else{
            return ;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        /*删除的是第一个也是最后一个*/
        if (size > 0 && index > -1 && index < size){
            if(size == 1 ){
                root.next = null;
                foot = null;
                size--;
            }
            else {
                ListNode p = root;
                int i = 0;
                while (i < index ){
                    p = p.next;
                    i++;
                }
                /*证明是中间的元素*/
                if (p.next != null){
                    p.next = p.next.next;
                }
                if (p.next == null){
                    foot = p;
                }
                size--;
            }
        }
    }

    public static void main(String[] args) {
        int res = 0;
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1,2);
        res = linkedList.get(1);
    }
}
