/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;

        if(root.val < p.val && root.val < q.val){ // Both p and q lies to the right
            return lowestCommonAncestor(root.right, p, q);
        }

        if(root.val > p.val && root.val > q.val){ // Both p and q lies to the left
            return lowestCommonAncestor(root.left, p, q);
        }

        return root; // This implies current node is the lca as one node lies to the left and one node lies to the right
    }

    
}

/*

Brute force: Below is the same code for Binary tree. Here it taken O(n) as time complexity.

TreeNode lca;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lca = null;
        exploreTree(root, p, q);
        return lca;
    }

    private boolean exploreTree(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return false;

        boolean left = exploreTree(root.left, p, q);
        boolean right = exploreTree(root.right, p, q);

        boolean current = (root == p) || (root == q);

        if((left && right) || (left && current) || (right && current)){
            lca = root;
        }

        return left || right || current;
    }
*/