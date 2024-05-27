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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        int [] maxDiameter = new int[1];
        calculateDiameter(root, maxDiameter);
        return maxDiameter[0]-1;
    }
    
    private int calculateDiameter(TreeNode root, int [] maxDiameter){
        if(root == null){
            return 0;
        }
        
        int leftHeight = calculateDiameter(root.left, maxDiameter);
        int rightHeight = calculateDiameter(root.right, maxDiameter);
        
        maxDiameter[0] = Math.max(maxDiameter[0], 1 + leftHeight + rightHeight);
        
        return 1 + Math.max(leftHeight, rightHeight);
    }
}