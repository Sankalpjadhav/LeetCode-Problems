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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i], i);
        }
        
        return constructBinaryTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, map);
    }
    
    private TreeNode constructBinaryTree(int [] preorder, int preStart, int preEnd, int [] inorder, int inStart, int inEnd, HashMap<Integer, Integer> map){
        if(preStart > preEnd || inStart > inEnd){
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[preStart]);
        int inCurr = map.get(root.val);
        int length = inCurr - inStart;
        
        root.left = constructBinaryTree(preorder, preStart+1, preStart+length, inorder, inStart, inCurr-1, map);
        
        root.right = constructBinaryTree(preorder, preStart+length+1, preEnd, inorder, inCurr+1, inEnd, map);
        
        return root;
    }
}