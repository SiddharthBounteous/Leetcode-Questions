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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode dummy=new ListNode(0);
        dummy.next=head;

        ListNode curr=head;
        ListNode prev=dummy;


        while(curr!=null){
            //if current node is duplicate node
            if(curr.next!=null && curr.val==curr.next.val){

                //move to last duplicate node

                while(curr.next!=null && curr.val==curr.next.val){
                    curr=curr.next;
                }

                //shift to directly next unique element
                prev.next=curr.next;
            }
            else{
                //next unique node
                prev=prev.next;
            }
            curr=curr.next;
        }
        return dummy.next;
    }
}
