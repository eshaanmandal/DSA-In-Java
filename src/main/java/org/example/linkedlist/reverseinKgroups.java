package org.example.linkedlist;

public class reverseinKgroups {
    static ListNode th;
    static ListNode tt;
    static int countNodes(ListNode node){
        int count = 0;
        while(node != null){
            count++;
            node = node.next;
        }
        return count;
    }
    static void addFirst(ListNode node){
        if(th == null){
            th = tt = node;
        }
        else{
            node.next = th;
            th = node;
        }
    }
    public static ListNode reverse(ListNode head, int groupSize){
        if(groupSize < 1)
            return null;
        ListNode curr = head, oh=null, ot=null;
        int count = countNodes(curr);

        for(int i=count; i>=groupSize; i-=groupSize){
            int tempK = groupSize;
            while(tempK-- > 0){
                ListNode fwd = curr.next;
                curr.next = null;
                addFirst(curr);

                curr = fwd;
            }
            if(oh == null){
                oh = th;
                ot = tt;
            }
            else{
                ot.next = th;
                ot = tt;
            }
            th = tt = null;
        }
        ot.next = curr;
        return oh;
    }
    public static void main(String[] args){
        th = tt = null;
        ListNode root = new ListNode(1);
        root.next = new ListNode(5);
        root.next.next = new ListNode(7);
        root.next.next.next = new ListNode(9);
        root.next.next.next.next = new ListNode(15);
        root.next.next.next.next.next = new ListNode(25);
        root.next.next.next.next.next.next = new ListNode(36);
        root.next.next.next.next.next.next.next = new ListNode(38);

        ListNode new_head = reverse(root, 3);

        while(new_head != null){
            System.out.println(new_head.data);
            new_head = new_head.next;
        }

    }
}
