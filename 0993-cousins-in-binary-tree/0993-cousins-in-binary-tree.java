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
    
    HashMap<Integer, Pair> parents = new HashMap<>();
    
    public boolean isCousins(TreeNode root, int x, int y) {
        parents.put(root.val, new Pair(-1, 0));
        
        findParentAndLevel(root, 0);
        
        Pair parent1 = parents.get(x);
        Pair parent2 = parents.get(y);
        
        
        if(parent1.getKey() != parent2.getKey() && parent1.getValue() == parent2.getValue()){
            return true;
        }
        
        return false;
    }
    
    private void findParentAndLevel(TreeNode root, int level){
        if(root == null){
            return;
        }
        
        if(root.left != null){
            parents.put(root.left.val, new Pair(root.val, level+1));
        }
        
        if(root.right != null){
            parents.put(root.right.val, new Pair(root.val, level+1));
        }
        
        findParentAndLevel(root.left, level+1);
        findParentAndLevel(root.right, level+1);
    }
}
