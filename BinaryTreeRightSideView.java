//approach 1
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
    public List<Integer> rightSideView(TreeNode root) {

        if(root==null){
            return new ArrayList<>();
        }

        Queue<TreeNode>qu=new LinkedList<>();
        List<Integer>result=new ArrayList<>();

        qu.add(root);

        while(!qu.isEmpty()){
            int n=qu.size();
            TreeNode node=null;

            while(n>0){
                node=qu.poll();

                if(node.left!=null){
                    qu.add(node.left);
                }
                if(node.right!=null){
                    qu.add(node.right);
                }
                n--;
            }
            result.add(node.val);
        }
        return result;
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
    public void preorder(TreeNode root,int level,List<Integer>result){
        if(root==null){
            return;
        }

        if(result.size()<level){
            result.add(root.val);
        }

        preorder(root.right,level+1,result);
        preorder(root.left,level+1,result);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer>result=new ArrayList<>();

        preorder(root,1,result);

        return result;
    }
}
