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
    public int maxAncestorDiff(TreeNode root) {
        int [] ans = new int[1];

        dfs(root, root.val, root.val, ans);
        return ans[0];
    }

    private void dfs(TreeNode root, int min, int max, int [] res){
        if(root == null){
            return;
        }

        min = Math.min(min, root.val);
        max = Math.max(max, root.val);
        res[0] = Math.max(res[0], Math.abs(min-max));

        dfs(root.left, min, max, res);
        dfs(root.right, min, max, res);
    }


}