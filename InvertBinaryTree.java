//approach 1

public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
 
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }

        TreeNode left=invertTree(root.left);
        TreeNode right=invertTree(root.right);

        root.left=right;
        root.right=left;

        return root;
    }
}

//approach 2
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }

        Queue<TreeNode>qu=new LinkedList<>();

        qu.add(root);
        while(!qu.isEmpty()){
            TreeNode node=qu.poll();

            TreeNode temp=node.left;
            node.left=node.right;
            node.right=temp;

            if(node.left!=null){
                qu.add(node.left);
            }
            if(node.right!=null){
                qu.add(node.right);
            }
        }


        return root;
    }
}
