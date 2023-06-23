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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length-1);
    }
    
    private TreeNode construct(int [] nums, int startIndex, int endIndex){
        if(startIndex > endIndex){
            return null;
        }
        if(startIndex == endIndex){
            return new TreeNode(nums[startIndex]);
        }
        
        int maxValue = -1;
        int maxIndex = startIndex;
        
        for(int i=startIndex;i<=endIndex;i++){
            if(maxValue < nums[i]){
                maxValue = nums[i];
                maxIndex = i;
            }
        }
        
        TreeNode root = new TreeNode(maxValue);
        
        TreeNode leftNode = construct(nums, startIndex, maxIndex-1);
        TreeNode rightNode = construct(nums, maxIndex+1, endIndex);
        
        root.left = leftNode;
        root.right = rightNode;
        
        return root;
    }
}