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
    public int pairSum(ListNode head) {
        Stack<Integer>st=new Stack<>();

        ListNode curr=head;
        while(curr!=null){
            st.push(curr.val);
            curr=curr.next;
        }

        int n=st.size();
        int count=1;
        curr=head;
        int result=0;

        while(count<=n/2){
            result=Math.max(result,curr.val+st.pop());
            curr=curr.next;
            count++;
        }
        return result;
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
    private ListNode reverseLinkedList(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode last=reverseLinkedList(head.next);
        head.next.next=head;
        head.next=null;
        return last;
    }
    public int pairSum(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode mid=slow;

        ListNode sec=reverseLinkedList(mid);

        int result=0;
        ListNode curr=head;

        while(sec!=null){
            result=Math.max(result,curr.val+sec.val);
            curr=curr.next;
            sec=sec.next;
        }

        return result;
    }
}
