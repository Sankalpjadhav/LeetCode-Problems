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
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return 0;
        }
        int [] count = {0};
        preorderTraversal(root, targetSum, count);
        return count[0];
    }
    
    private void preorderTraversal(TreeNode root, long targetSum, int [] count){
        if(root == null){
            return;
        }
        
        calculatePathSum(root, targetSum, count);
        preorderTraversal(root.left, targetSum, count);
        preorderTraversal(root.right, targetSum, count);
    }
    
    private void calculatePathSum(TreeNode node, long targetSum, int [] count){
        if(node == null){
            return;
        }
        
        if(targetSum  - node.val == 0){
            count[0]++;
        }
        
        calculatePathSum(node.left, targetSum - node.val, count);
        calculatePathSum(node.right, targetSum - node.val, count);
    }
}