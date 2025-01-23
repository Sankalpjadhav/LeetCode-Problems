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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) return (root == subRoot);
        return traverse(root, subRoot);
    }

    private boolean traverse(TreeNode root, TreeNode subRoot){
        if(root == null){
            return false;
        }

        boolean isItSubTree = checkSameTree(root, subRoot);
        if(isItSubTree) return true;

        boolean left = traverse(root.left, subRoot);
        boolean right = traverse(root.right, subRoot);
        
        

        return left || right;
    }

    private boolean checkSameTree(TreeNode p, TreeNode q){
        if(p == null || q == null){
            return (p == q);
        }

        return (p.val == q.val) && checkSameTree(p.left, q.left) && checkSameTree(p.right, q.right);
    }
}