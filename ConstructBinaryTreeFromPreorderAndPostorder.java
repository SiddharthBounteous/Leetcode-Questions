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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preIdx[]=new int[1];
        preIdx[0]=0;

        return solve(preorder,inorder,0,inorder.length-1,preIdx);
    }

    private int search(int []preorder,int []inorder,int []preIdx,int left,int right){
        for(int i=left;i<=right;i++){
            if(inorder[i]==preorder[preIdx[0]]){
                return i;
            }
        }

        return -1;
    }

    private TreeNode solve(int[] preorder, int[] inorder,int left ,int right,int [] preIdx){

        if(left>right){
            return null;
        }

        TreeNode root=new TreeNode(preorder[preIdx[0]]);

        int inorderIdx=search(preorder,inorder,preIdx,left,right);
        preIdx[0]++;

        root.left=solve(preorder,inorder,left,inorderIdx-1,preIdx);
        root.right=solve(preorder,inorder,inorderIdx+1,right,preIdx);

        return root;
    }
}
