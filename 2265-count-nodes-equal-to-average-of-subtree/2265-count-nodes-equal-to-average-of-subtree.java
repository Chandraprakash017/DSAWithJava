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
    int count=0;//number of matching rows track rakhne ke liye.
    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return count; 
    }
    private int[] dfs(TreeNode node){
        if(node == null){
            return new int[]{0,0};
        }
        int[] left=dfs(node.left);
        int[] right=dfs(node.right);
        int currsum=left[0]+right[0] + node.val;
        int currnodecount=left[1]+right[1]+1;
        if(currsum/currnodecount == node.val){
            count++;
        }
        return new int[]{currsum,currnodecount};
    }
}