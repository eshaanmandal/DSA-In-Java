package org.example.linkedlist;

public class reverseinPairs {
    static ListNode th = null; // temporary head
    static ListNode tt = null; // temporary tail
    static int findListSize(ListNode node){
        int len = 0;
        while(node.next != null){
            len++;
            node = node.next;
        }

        return len;
    }

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
        ListNode oh = null;
        ListNode ot = null;

        ListNode curr = head;
        int length = findListSize(head);
        for(int i=length; i>=2; i-=2){
            int tempK = 2;
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

            tt = th = null;
        }

        ot.next = curr;

        while(oh != null){
            System.out.println(oh.data);
            oh = oh.next;
        }

    }
}
