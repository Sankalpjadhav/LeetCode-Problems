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
    public int maxLevelSum(TreeNode root) {
        int level = 1;
        int maxSum = root.val;
        
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair(root, 1));
        
        while(!queue.isEmpty()){
            int size = queue.size();
            int sum = 0;
            int currentLevel = 0;
            while(size-- > 0){
                Pair pair = queue.poll();
                TreeNode node = (TreeNode) pair.getKey();
                currentLevel = (Integer) pair.getValue();
                sum += node.val;
                
                if(node.left != null){
                    queue.add(new Pair(node.left, currentLevel + 1));
                }
                if(node.right != null){
                    queue.add(new Pair(node.right, currentLevel + 1));
                }
            }
            
            if(sum > maxSum){
                maxSum = sum;
                level = currentLevel;
            }
        }
        
        return level;
    }
}