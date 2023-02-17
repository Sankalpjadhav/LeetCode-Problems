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
    public int getMinimumDifference(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        inorderTraversal(root, values);
        
        //System.out.println(values);
        
        int min = Integer.MAX_VALUE;
        
        for(int i=0;i<values.size()-1;i++){
            min = Math.min(min, values.get(i+1) - values.get(i));
        }
        
        return min;
    }
    
    private void inorderTraversal(TreeNode root, List<Integer> values){
        if(root == null){
            return;
        }
        
        inorderTraversal(root.left, values);
        values.add(root.val);
        inorderTraversal(root.right, values);
    }
}