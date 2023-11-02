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
    public int averageOfSubtree(TreeNode root) {
        int [] count = new int[1];
        dfs(root, count);
        return count[0];
    }

    private int [] dfs(TreeNode root, int [] count){
        if(root == null){
            return new int[]{0,0};
        }

        int [] left = dfs(root.left, count);
        int [] right = dfs(root.right, count);

        int currentVal = left[0] + right[0] + root.val;
        int currentCount = left[1] + right[1] + 1;

        if(currentVal / currentCount == root.val){
            count[0]++;
        }

        return new int[]{currentVal, currentCount};
    }
}