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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i], i);
        }
        
        return buildBinaryTree(0, inorder.length-1, inorder, 0, postorder.length-1, postorder, map);
    }
    
    private TreeNode buildBinaryTree(int inorderStart, int inorderEnd, int [] inorder, int postorderStart, int postorderEnd, int [] postorder, HashMap<Integer, Integer> map){
        if(inorderStart > inorderEnd || postorderStart > postorderEnd){
            return null;
        }
        
        TreeNode root = new TreeNode(postorder[postorderEnd]);
        int inorderRootIndex = map.get(postorder[postorderEnd]);
        int numberOfElementsAtLeft = inorderRootIndex - inorderStart;
        
        root.left = buildBinaryTree(inorderStart, inorderRootIndex-1, inorder, postorderStart, postorderStart + numberOfElementsAtLeft - 1, postorder, map);
        root.right = buildBinaryTree(inorderRootIndex + 1, inorderEnd, inorder, postorderStart + numberOfElementsAtLeft, postorderEnd-1, postorder, map);
        
        return root;
    }
}