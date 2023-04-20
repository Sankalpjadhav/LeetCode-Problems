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
    public int widthOfBinaryTree(TreeNode root) {
        int width = 0;
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        
        while(!queue.isEmpty()){
            int queueSize = queue.size();
            int minIndexAtThatLevel = queue.peek().getValue();
            int firstIndex = 0, lastIndex = 0;
            for(int i=0;i<queueSize;i++){
                int currentIndex = queue.peek().getValue() - minIndexAtThatLevel;
                TreeNode currentNode = queue.peek().getKey();
                queue.poll();
                if(i == 0){
                    firstIndex = currentIndex;
                }
                
                if(i == queueSize - 1){
                    lastIndex = currentIndex;
                }
                
                if(currentNode.left != null){
                    queue.add(new Pair(currentNode.left, 2 * currentIndex + 1));
                }
                
                if(currentNode.right != null){
                    queue.add(new Pair(currentNode.right, 2 * currentIndex + 2));
                }
            }
            
            width = Math.max(width, lastIndex - firstIndex + 1);
        }
        
        return width;
    }
}