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
    HashMap<Integer, Integer> levelSum;
    public TreeNode replaceValueInTree(TreeNode root) {
        levelSum = new HashMap<>();
        
        dfsToCalculateLevelSum(root, 0);
        calculateCousinSum(root, 0, 0);
        
        return root;
    }
    
    private void dfsToCalculateLevelSum(TreeNode root, int level){
        if(root == null){
            return;
        }
        
        levelSum.put(level, levelSum.getOrDefault(level, 0) + root.val);
        
        dfsToCalculateLevelSum(root.left, level+1);
        dfsToCalculateLevelSum(root.right, level+1);
    }
    
    private void calculateCousinSum(TreeNode root, int sameParentSiblingSum, int level){
        if(root == null){
            return;
        }
        
        int leftChildSum = root.left == null ? 0 : root.left.val;
        int rightChildSum = root.right == null ? 0 : root.right.val;
        
        calculateCousinSum(root.left, rightChildSum, level+1);
        calculateCousinSum(root.right, leftChildSum, level+1);
        
        root.val = levelSum.get(level) - root.val - sameParentSiblingSum;
    
    }
}