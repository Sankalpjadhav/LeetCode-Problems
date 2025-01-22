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
    class NodeValues {
        boolean isBST;
        int sum;        // Sum of the subtree
        int minValue;   // Minimum value in the subtree
        int maxValue;   // Maximum value in the subtree
        
        NodeValues(boolean _isBST, int _sum, int _minValue, int _maxValue) {
            isBST = _isBST;
            sum = _sum;
            minValue = _minValue;
            maxValue = _maxValue;
        }
    }

    public int maxSumBST(TreeNode root) {
        int[] maxSum = {0}; // Track the maximum sum globally
        traverseTree(root, maxSum);
        return maxSum[0];
    }

    private NodeValues traverseTree(TreeNode root, int[] maxSum) {
        if (root == null) {
            // An empty tree is a BST with sum = 0 and min/max set to extremes
            return new NodeValues(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        NodeValues left = traverseTree(root.left, maxSum);
        NodeValues right = traverseTree(root.right, maxSum);

        if (left.isBST && right.isBST && root.val > left.maxValue && root.val < right.minValue) {
            // The current tree is a BST
            int currentSum = root.val + left.sum + right.sum;
            maxSum[0] = Math.max(maxSum[0], currentSum);
            return new NodeValues(true, currentSum, Math.min(root.val, left.minValue), Math.max(root.val, right.maxValue));
        } else {
            // The current tree is not a BST
            return new NodeValues(false, 0, 0, 0);
        }
    }
}

/*
 public int maxSumBST(TreeNode root) {
        int [] maxSum = {Integer.MIN_VALUE};
        traverseBinaryTree(root, maxSum);
        return maxSum[0] < 0 ? 0 : maxSum[0];
    }

    private void traverseBinaryTree(TreeNode root, int [] maxSum){
        if(root == null) return;


        traverseBinaryTree(root.left, maxSum);
        traverseBinaryTree(root.right, maxSum);

        if(validateBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)){
            maxSum[0] = Math.max(maxSum[0], calculateSum(root));
        }
    }

    private boolean validateBST(TreeNode node, int min, int max){
        if(node == null) return true;

        if(min > node.val || node.val > max){
            return false;
        }

        return validateBST(node.left, min, node.val) && validateBST(node.right, node.val, max);
    }

    private int calculateSum(TreeNode node){
        if(node == null) return 0;

        return node.val + calculateSum(node.left) + calculateSum(node.right);
    }
*/