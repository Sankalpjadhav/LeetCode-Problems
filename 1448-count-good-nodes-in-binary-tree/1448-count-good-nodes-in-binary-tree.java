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
    public int goodNodes(TreeNode root) {
        int [] count = new int[1];
        preorderTraversal(root, (int)-1e5, count);
        return count[0];
    }
    
    private void preorderTraversal(TreeNode root, int max, int [] count){
        if(root == null){
            return;
        }
        
        if(root.val >= max){
            count[0]++;
        }
        
        preorderTraversal(root.left, Math.max(max, root.val), count);
        preorderTraversal(root.right, Math.max(max, root.val), count);
    }
}