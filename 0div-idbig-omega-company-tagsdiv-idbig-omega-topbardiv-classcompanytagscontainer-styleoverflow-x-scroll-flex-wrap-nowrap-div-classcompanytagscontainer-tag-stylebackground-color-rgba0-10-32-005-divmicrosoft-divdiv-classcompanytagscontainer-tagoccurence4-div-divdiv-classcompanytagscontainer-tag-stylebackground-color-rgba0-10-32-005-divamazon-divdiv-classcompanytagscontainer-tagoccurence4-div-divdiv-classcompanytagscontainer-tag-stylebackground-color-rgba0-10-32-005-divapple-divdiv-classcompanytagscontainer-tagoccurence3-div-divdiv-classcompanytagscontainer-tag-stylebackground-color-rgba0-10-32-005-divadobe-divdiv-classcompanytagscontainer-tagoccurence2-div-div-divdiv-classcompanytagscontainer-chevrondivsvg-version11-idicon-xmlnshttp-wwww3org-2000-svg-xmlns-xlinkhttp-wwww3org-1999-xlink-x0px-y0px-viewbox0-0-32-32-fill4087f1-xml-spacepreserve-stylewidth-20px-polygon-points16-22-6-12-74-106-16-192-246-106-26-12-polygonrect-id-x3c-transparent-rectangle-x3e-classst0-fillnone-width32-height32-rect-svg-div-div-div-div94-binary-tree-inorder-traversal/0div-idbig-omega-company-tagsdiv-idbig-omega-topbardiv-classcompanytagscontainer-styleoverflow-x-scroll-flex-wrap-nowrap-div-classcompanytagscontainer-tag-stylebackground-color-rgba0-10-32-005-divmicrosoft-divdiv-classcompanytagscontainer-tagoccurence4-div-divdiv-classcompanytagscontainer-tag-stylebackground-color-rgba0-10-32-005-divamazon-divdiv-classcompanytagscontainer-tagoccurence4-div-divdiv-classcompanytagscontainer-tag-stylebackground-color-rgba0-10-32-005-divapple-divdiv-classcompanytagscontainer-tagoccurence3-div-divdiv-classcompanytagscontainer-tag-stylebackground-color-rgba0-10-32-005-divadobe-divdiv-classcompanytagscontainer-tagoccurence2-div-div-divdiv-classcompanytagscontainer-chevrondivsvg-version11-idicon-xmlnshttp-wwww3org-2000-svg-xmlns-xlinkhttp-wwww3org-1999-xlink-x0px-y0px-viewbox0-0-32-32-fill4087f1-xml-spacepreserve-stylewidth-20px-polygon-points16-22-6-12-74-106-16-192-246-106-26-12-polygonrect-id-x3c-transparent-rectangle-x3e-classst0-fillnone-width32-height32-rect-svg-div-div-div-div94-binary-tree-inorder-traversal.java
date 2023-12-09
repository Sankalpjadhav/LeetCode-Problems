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
    // Using Morris Traversal
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        morrisTraversal(root, inorder);
        return inorder;
    }
    
    private void morrisTraversal(TreeNode root, List<Integer> inorder){
        TreeNode currentNode = root;
        
        while(currentNode != null){
            if(currentNode.left == null){
                inorder.add(currentNode.val);
                currentNode = currentNode.right;
            }
            else{
                TreeNode previousNode = currentNode.left;
                
                while(previousNode.right!=null && previousNode.right!=currentNode){
                    previousNode = previousNode.right;
                }
                
                if(previousNode.right == null){
                    previousNode.right = currentNode;
                    currentNode = currentNode.left;
                }
                else{
                    // previousNode.right == currentNode
                    previousNode.right = null;
                    inorder.add(currentNode.val);
                    currentNode = currentNode.right;
                }
            }
        }
    
    }
}