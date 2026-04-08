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
    public List<TreeNode> solve(int n) {
        if (n % 2 == 0) {
            return new ArrayList<>();
        }
        if (n == 1) {
            TreeNode root = new TreeNode(0);
            List<TreeNode> temp = new ArrayList<>();
            temp.add(root);
            return temp;
        }

        List<TreeNode> result = new ArrayList<>();

        for (int i = 1; i < n; i += 2) {
            List<TreeNode> leftAllFBT = solve(i);
            List<TreeNode> rightAllFBT = solve(n - i - 1);

            for (TreeNode li : leftAllFBT) {
                for (TreeNode ri : rightAllFBT) {
                    TreeNode root = new TreeNode(0);
                    root.left = li;
                    root.right = ri;
                    result.add(root);
                }
            }
        }

        return result;
    }

    public List<TreeNode> allPossibleFBT(int n) {
        return solve(n);
    }
}
