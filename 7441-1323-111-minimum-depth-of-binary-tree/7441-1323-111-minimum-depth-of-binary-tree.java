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
    public int minDepth(TreeNode root) {
        // We will solve this using both BFS and DFS
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int height = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            height++;
            while(size-- > 0){
                TreeNode currentNode = queue.poll();
                if(currentNode.left != null){
                    queue.add(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.add(currentNode.right);
                }

                if(currentNode.left == null && currentNode.right == null) return height;
            }
        }

        return height;
    }

/*
    private int dfs(TreeNode root){
        if(root == null) return 0;
        
        int leftHeight = dfs(root.left);
        int rightHeight = dfs(root.right);

        if(leftHeight == 0 || rightHeight == 0) return leftHeight + rightHeight + 1;

        return 1 + Math.min(leftHeight, rightHeight);
    }

*/
}