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
    public int maxDepth(TreeNode root) {
        // Using BFS
        // Time complexity: O(N)
        // Space complexity: O(N)
        int count = 0;
        if(root == null) return count;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            count++;
            while(size-- > 0){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
        }
        return count;
    }

    
}

/*
Using DFS: 
Time complexity: O(N) -> Traversing all the nodes
Space complexity: O(log N) -> Height of the tree
public int maxDepth(TreeNode root) {
        // Using DFS
        return traverse(root);
    }

    private int traverse(TreeNode root){
        if(root == null) return 0;

        int leftHeight = traverse(root.left);
        int rightHeight = traverse(root.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }
*/
