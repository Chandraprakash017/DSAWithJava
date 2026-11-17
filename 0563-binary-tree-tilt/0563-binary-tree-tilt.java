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
    private int totaltilt=0;
    public int findTilt(TreeNode root) {
         subtreeSum(root);
         return totaltilt;
        

        
    }
    private int subtreeSum(TreeNode node){
        if(node==null){
            return 0;
        }
        int leftsum=subtreeSum(node.left);
        int rightsum=subtreeSum(node.right);
        totaltilt+=Math.abs(leftsum-rightsum);
        return leftsum+rightsum+node.val;
    }
}