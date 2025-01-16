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
    public int maxDepth(TreeNode root) {
        // We can solve this using DFS as well as BFS. BFS in worst case might take up SC of O(n) by storing all the nodes
        // However DFS will take auxillary space of O(logn) i.e. Height of the tree.
        return dfs(root);
    }

    private int dfs(TreeNode root){
        if(root == null) return 0;
        
        int leftHeight = dfs(root.left);
        int rightHeight = dfs(root.right);

        return 1 + Math.max(leftHeight, rightHeight); // Here 1 is for the current element which contributes to the height
    }
}