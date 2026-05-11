class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null || k==0){
            return head;
        }
        
        int L=1;
        ListNode tail=head;

        while(tail.next!=null){
            tail=tail.next;
            L++;
        }
        k=k%L;

        if(k==0){
            return head;
        }

        tail.next=head;  //tail will point to head
        //k-l
        int rem=L-k;
        ListNode newTail=head;

        for(int count=1;count<rem;count++){
            newTail=newTail.next;
        }
        ListNode newHead=newTail.next;
        newTail.next=null;
        return newHead;
    }
}
