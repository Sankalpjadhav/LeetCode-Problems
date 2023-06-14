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
    private int prevNode;
    private int min;
    
    public int getMinimumDifference(TreeNode root) {
        prevNode = (int) 1e6;
        min = Integer.MAX_VALUE;
        inorderTraversal(root); 
        return min;
    }
    
    private void inorderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        
        inorderTraversal(root.left);
        min = Math.min(min, Math.abs(prevNode - root.val));
        prevNode = root.val;
        inorderTraversal(root.right);
    }
}