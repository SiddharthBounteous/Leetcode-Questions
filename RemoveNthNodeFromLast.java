/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
//approach 1
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count=0;

        ListNode curr=head;

        while(curr!=null){
            count++;
            curr=curr.next;
        }
        if(count==n){
            ListNode temp=head;
            temp=null;
            return head.next;
        }
        int travelFront=count-n;

        ListNode curr1=head;
        ListNode prev=null;

        while(travelFront!=0){
            prev=curr1;
            curr1=curr1.next;
            travelFront--;
        }

        prev.next=curr1.next;
        curr1=null;
        return head;
    }
}

//approach 2
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr=head;

        for(int i=1;i<=n;i++){
            curr=curr.next;
        }

        if(curr==null){
            return head.next;
        }

        ListNode prev=head;

        while(curr!=null && curr.next!=null){
            prev=prev.next;
            curr=curr.next;
        }

        prev.next=prev.next.next;
        return head;
    }
}
