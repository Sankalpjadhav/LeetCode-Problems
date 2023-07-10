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
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        int leftLength = minDepth(root.left);
        int rightLength = minDepth(root.right);
        
        if(leftLength == 0){
            return rightLength + 1;
        }
        
        if(rightLength == 0){
            return leftLength + 1;
        }
        
        return Math.min(leftLength, rightLength) + 1;
    }
}