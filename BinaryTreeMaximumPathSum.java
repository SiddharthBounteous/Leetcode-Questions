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
    int maxiSum;
    int solve(TreeNode root){
        if(root==null){
            return 0;
        }
        int l=solve(root.left);
        int r=solve(root.right);

        int got_ans_in_down=root.val+l+r;
        int any_one_sum=Math.max(l,r)+root.val;
        int only_root=root.val;

        maxiSum=Math.max(maxiSum,Math.max(got_ans_in_down,Math.max(any_one_sum,only_root)));

        return Math.max(any_one_sum,only_root);
    }
    public int maxPathSum(TreeNode root) {
        maxiSum=Integer.MIN_VALUE;
        solve(root);
        return maxiSum;
    }
}
