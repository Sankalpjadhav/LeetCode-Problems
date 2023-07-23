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
    public List<TreeNode> allPossibleFBT(int n) {
        
        return helper(n);
    }

    private List<TreeNode> helper(int n){
        List<TreeNode> res = new ArrayList<>();
        if(n == 1){
            res.add(new TreeNode(0));
            return res;
        }

        for(int i=1; i<n;i+=2){
            List<TreeNode> leftTree = helper(i);
            List<TreeNode> rightTree = helper(n-i-1);
            for(TreeNode left: leftTree){
                for(TreeNode right:rightTree){
                    TreeNode root = new TreeNode(0);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}