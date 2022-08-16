package org.example.linkedlist;

class ListNode{
    int data;
    ListNode next;
    ListNode(int data){
        this.data = data;
        this.next = null;
    }
}
public class reverseLinkedList {
    static ListNode th = null;
    static ListNode tt = null;
    public static void addFirst(ListNode node){
        if(th == null){
            th = tt = node;
        }
        else{
            node.next = th;
            th = node;
        }
    }
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(10);
        head.next.next.next.next = new ListNode(14);

        ListNode curr = head;
//        while(curr != null){
//            System.out.println(curr.data);
//            curr = curr.next;
//        }

        while(curr != null){
            ListNode fwd = curr.next;
            curr.next = null;
            addFirst(curr);

            curr = fwd;

        }

        while(th != null){
            System.out.println(th.data);
            th = th.next;
        }


    }
}
