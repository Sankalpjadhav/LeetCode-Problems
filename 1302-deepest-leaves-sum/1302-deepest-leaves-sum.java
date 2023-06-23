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
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int deepestSum = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            int sum = 0;
            while(size-- > 0){
                TreeNode node = queue.poll();
                
                if(node.left == null && node.right == null){
                    sum += node.val;
                }
                
                if(node.left != null){
                    queue.add(node.left);
                }
                
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            if(sum > 0){
                deepestSum = sum;
            }
        }
        
        return deepestSum;
    }
}