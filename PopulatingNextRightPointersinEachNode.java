/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {

        if(root==null || root.left==null){
            return root;
        }

        Queue<Node>qu=new LinkedList<>();
        qu.add(root);
        qu.add(null);

        Node prev=null;

        while(!qu.isEmpty()){
            Node curr=qu.poll();

            if(curr==null){
                if(qu.size()==0){
                    break;
                }
                qu.add(null);
            }
            else{
                if(curr.left!=null){
                    qu.add(curr.left);
                }
                if(curr.right!=null){
                    qu.add(curr.right);
                }

                if(prev!=null){
                    prev.next=curr;
                }
                
            }
            prev=curr;
        }

        return root;
    }
}
