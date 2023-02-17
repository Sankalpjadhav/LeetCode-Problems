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
    private TreeNode prev;
    public int minDiffInBST(TreeNode root) {
        prev = null;
        int [] min = {Integer.MAX_VALUE};
        traverse(root, min);
        
        return min[0];
    }
    
    private void traverse(TreeNode root, int [] min){
        if(root == null){
            return;
        }
        traverse(root.left, min);
        if(prev != null){
            min[0] = Math.min(min[0], root.val - prev.val);
        }
        prev = root;
        traverse(root.right, min);
    }
}