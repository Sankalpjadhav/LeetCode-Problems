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
    public List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }

    private List<TreeNode> helper(int low, int high){
        List<TreeNode> result = new ArrayList<>();
        if(low > high){
            result.add(null);
            return result;
        }

        for(int node=low;node<=high;node++){
            List<TreeNode> left = helper(low, node-1);
            List<TreeNode> right = helper(node+1, high);

            for(TreeNode l: left){
                for(TreeNode r: right){
                    TreeNode root = new TreeNode(node);
                    root.left = l;
                    root.right = r;
                    result.add(root);
                }
            }
        }

        return result;
    }
}