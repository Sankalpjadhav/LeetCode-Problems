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
    public int maxPathSum(TreeNode root) {
    
        int [] maxPathSum = {Integer.MIN_VALUE};
        dfs(root, maxPathSum);
        return maxPathSum[0];
    }

    private int dfs(TreeNode root, int [] maxPathSum){
        if(root == null) return 0;

        int leftSum = Math.max(0, dfs(root.left, maxPathSum));
        int rightSum = Math.max(0, dfs(root.right, maxPathSum));

        maxPathSum[0] = Math.max(maxPathSum[0], root.val + leftSum + rightSum);

        return Math.max(leftSum, rightSum) + root.val;
    }
}

/*
public int maxPathSum(TreeNode root) {
        // Brute Force: From every node we will calculate the path sum to its leaf nodes for both left and right nodes
        // We will make sure to return 0 if the path sum to their leaf nodes is negative since negative value makes the path sum smaller.
        int [] maxPathSum = {Integer.MIN_VALUE};
        dfs(root, maxPathSum);
        return maxPathSum[0];
    }

    private void dfs(TreeNode root, int [] maxPathSum){
        if(root == null) return;

        dfs(root.left, maxPathSum);
        dfs(root.right, maxPathSum);

        int leftPathSum = calculatePathSumToLeaf(root.left);
        int rightPathSum = calculatePathSumToLeaf(root.right);

        maxPathSum[0] = Math.max(maxPathSum[0], root.val + leftPathSum + rightPathSum);
    }

    private int calculatePathSumToLeaf(TreeNode root){
        if(root == null) return 0;
        if(root.left == null && root.right == null){
            return Math.max(0, root.val);
        }

        int leftPathSum = Math.max(0, calculatePathSumToLeaf(root.left));
        int rightPathSum = Math.max(0, calculatePathSumToLeaf(root.right));

        return Math.max(0, root.val + Math.max(leftPathSum, rightPathSum)); // checking with 0 bcoz current root value can also be < 0 (-ve)
    }
*/