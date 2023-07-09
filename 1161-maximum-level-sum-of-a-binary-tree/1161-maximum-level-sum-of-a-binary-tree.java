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
        long maxSum = Integer.MIN_VALUE;
        int level = -1;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 1));
        
        while(!queue.isEmpty()){
            int size = queue.size();
            long sum = 0;
            int newLevel = 0;
            while(size-- > 0){
                Pair pair = queue.poll();
                newLevel = pair.level;
                sum += pair.node.val;
                
                if(pair.node.left != null){
                    queue.add(new Pair(pair.node.left, pair.level + 1));
                }
                
                if(pair.node.right != null){
                    queue.add(new Pair(pair.node.right, pair.level + 1));
                }
            }
            if(sum > maxSum){
                maxSum = sum;
                level = newLevel;
            }
        }
        
        return level;
    }
    
    class Pair{
        TreeNode node;
        int level;
        
        public Pair(TreeNode node, int level){
            this.node = node;
            this.level = level;
        }
    }
}