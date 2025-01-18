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
    private TreeNode lca;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Optimal approach: Traverse the binary tree while returning back from recursion
        // Check if we encounter a node which is either p or q
        // If yes, return true or else return false
        // If at given node if left and right return true then the current Node is the lowest common ancestor.

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


    
}

/*
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Brute force approach: Find out path from root to p and q
        // Traverse through the paths and find out index at which they don't match, prev index node would be the ancestor.
        // TC: O(2N) + O(log N) -> O(2N) for traversing binary two times. O(logN) for traversing through the path which has
        // has max height of the tree number of elements.
        List<TreeNode> path1 = new ArrayList<>();
        List<TreeNode> path2 = new ArrayList<>();
        
        findPath(root, p, path1);
        findPath(root, q, path2);

        int minLength = Math.min(path1.size(), path2.size());

        for(int i=0;i<minLength;i++){
            if(path1.get(i) != path2.get(i)){
                return path1.get(i-1);
            }
        }

        return path1.get(minLength-1);
    }


    private boolean findPath(TreeNode root, TreeNode node, List<TreeNode> path){
        if(root == null) return false;

        path.add(root);

        if(root.val == node.val){
            return true;
        }

        if(findPath(root.left, node, path) || findPath(root.right, node, path)){
            return true;
        }

        path.remove(path.size()-1);
        return false;
    }
*/