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
        int [] maxDiameter = {0};
        calculateHeight(root, maxDiameter);
        return maxDiameter[0];
    }

    private int calculateHeight(TreeNode node, int [] maxDiameter){
        if(node == null) return 0;

        int leftHeight = calculateHeight(node.left, maxDiameter);
        int rightHeight = calculateHeight(node.right, maxDiameter);

        maxDiameter[0] = Math.max(maxDiameter[0], leftHeight + rightHeight);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}

/*

TC: O(n^2)

public int diameterOfBinaryTree(TreeNode root) {
        // Brute Force: From every node find the left node and right node height and store their diameter (leftHeight + rightHeight) in some reference max variable
        int [] maxDiameter = {0};
        dfs(root, maxDiameter);
        return maxDiameter[0];
    }

    private void dfs(TreeNode root, int [] maxDiameter){
        if(root == null) return;

        int leftHeight = calculateHeight(root.left);
        int rightHeight = calculateHeight(root.right);

        maxDiameter[0] = Math.max(maxDiameter[0], leftHeight + rightHeight);

        dfs(root.left, maxDiameter);
        dfs(root.right, maxDiameter);
    }

    private int calculateHeight(TreeNode node){
        if(node == null) return 0;

        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

*/