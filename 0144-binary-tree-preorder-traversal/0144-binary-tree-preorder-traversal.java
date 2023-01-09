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
    // ITERATIVE METHOD
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        if(root == null){
            return preorder;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        
        while(!stack.isEmpty()){
            TreeNode curNode = stack.pop();
            
            preorder.add(curNode.val);
            
            if(curNode.right!=null){
                stack.add(curNode.right);
            }
            
            if(curNode.left!=null){
                stack.add(curNode.left);
            }
        }
        
        return preorder;
    }

}


/*
RECURSION:

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        dfs(root, preorder);
        return preorder;
    }
    
    private void dfs(TreeNode root, List<Integer> preorder){
        if(root == null){
            return ;
        }
        
        preorder.add(root.val);
        dfs(root.left, preorder);
        dfs(root.right, preorder);
    }

*/
