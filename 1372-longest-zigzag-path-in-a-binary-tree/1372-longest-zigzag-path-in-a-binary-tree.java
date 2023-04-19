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
    public int longestZigZag(TreeNode root) {
        int [] longestZigZagPath = {0};
        
        int direction = 1;
        /*
        1 represents right
        0 represents left
        */
        
        helper(root.left, direction, 1, longestZigZagPath);
        helper(root.right, 1 - direction, 1, longestZigZagPath);
        
        return longestZigZagPath[0];
    }
    
    private void helper(TreeNode root, int direction, int count, int [] longestZigZagPath){
        if(root == null){
            return;
        }
        
        longestZigZagPath[0] = Math.max(longestZigZagPath[0], count);
        
        if(direction == 0){
            helper(root.left, 1 - direction, count+1, longestZigZagPath);
            helper(root.right, direction, 1, longestZigZagPath);
        }
        else{
            helper(root.right, 1 - direction, count+1, longestZigZagPath);
            helper(root.left, direction, 1, longestZigZagPath);
        }
    }
}