//approach 1
class Solution {
    ListNode reverseLinkedList(ListNode head){
        if(head==null || head.next==null){
            return head;
        }

        ListNode last=reverseLinkedList(head.next);
        head.next.next=head;
        head.next=null;
        return last;
    }
    
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null){
            return true;
        }
        ListNode slow=head;
        ListNode fast=head;
        ListNode prev=null;

        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            prev=slow;
            slow=slow.next;
        }
        
        ListNode tail=reverseLinkedList(slow);
        prev.next=null;

        while(tail!=null && head!=null){
            if(tail.val!=head.val){
                return false;
            }
            tail=tail.next;
            head=head.next;
        }
        return true;
    }
}

//approach 2
class Solution {
    ListNode curr;
    private boolean solve(ListNode head){
        if(head==null){
            return true;
        }
        boolean ans=solve(head.next);
        if(head.val!=curr.val){
            return false;
        }
        curr=curr.next;

        return ans;
    }
    public boolean isPalindrome(ListNode head) {
        curr=head;
        return solve(head);
    }
}
