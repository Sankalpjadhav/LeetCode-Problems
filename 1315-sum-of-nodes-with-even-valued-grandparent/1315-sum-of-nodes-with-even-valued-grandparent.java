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
    public int sumEvenGrandparent(TreeNode root) {
        int [] result = new int[1];
        dfs(root, result);
        
        return result[0];
    }
    
    private void dfs(TreeNode root, int [] result){
        if(root == null){
            return;
        }
        
        if(root.val % 2 == 0){
            travelToGrandChildren(root, result, 2);
        }
        dfs(root.left, result);
        dfs(root.right, result);
    }
    
    private void travelToGrandChildren(TreeNode root, int [] result, int travelDistance){
        if(root == null){
            return;
        }
        
        if(travelDistance == 0){
            result[0] += root.val;
            return;
        }
        
        travelToGrandChildren(root.left, result, travelDistance-1);
        travelToGrandChildren(root.right, result, travelDistance-1);
    }
}