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
    public int pseudoPalindromicPaths (TreeNode root) {
        int [] count = new int[1];
        int [] numbers = new int[10];
        countPalindromicPaths(root, count, numbers);
        return count[0];

    }
    
    private void countPalindromicPaths(TreeNode root, int [] count, int [] numbers){
        if(root==null){
            return;
        }
        
        numbers[root.val]++;
        
        if(root.left == null && root.right == null){
            if(validPalindrome(numbers)){
                count[0]++;
            }
        }
        countPalindromicPaths(root.left, count, numbers);
        countPalindromicPaths(root.right, count, numbers);
        numbers[root.val]--;
    }
    
    private boolean validPalindrome(int [] map){
        int miss = 0;
        
        for(int i=0;i<map.length;i++){
            if(map[i]%2!=0){
                miss++;
            }
            if(miss>1){
                return false;
            }
        }
        
        return true;
    }
}