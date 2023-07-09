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
        if(root == null){
            return 0;
        }
        
        int [] longestZigZagPath = {0};
        /*
        1 represents right
        0 represents left
        */
        preorderTraversal(root.left, 1, 1, longestZigZagPath);
        preorderTraversal(root.right, 1, 0, longestZigZagPath);
        return longestZigZagPath[0];
    }
    
    private void preorderTraversal(TreeNode root, int count, int direction, int [] longestZigZagPath){
        if(root == null){
            return;
        }
        
        longestZigZagPath[0] = Math.max(longestZigZagPath[0], count);
        
        if(direction  == 0){
            preorderTraversal(root.left, count+1, 1 - direction, longestZigZagPath);
            preorderTraversal(root.right, 1, direction, longestZigZagPath);
        }
        else{
            preorderTraversal(root.right, count+1, 1 - direction, longestZigZagPath);
            preorderTraversal(root.left, 1, direction, longestZigZagPath);
        }
    }
}