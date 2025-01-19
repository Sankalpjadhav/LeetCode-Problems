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
        int n = postorder.length;
        return constructBinaryTree(postorder, 0, n-1, inorder, 0, n-1, map); 
    }

    private TreeNode constructBinaryTree(int [] postorder, int postStart, int postEnd, int [] inorder, 
    int inStart, int inEnd, HashMap<Integer, Integer> map){
        if(postStart > postEnd || inStart > inEnd){
            return null;
        }

        TreeNode root = new TreeNode(postorder[postEnd]);
        int rootIndexInInorder = map.get(postorder[postEnd]);
        int numsLeft = rootIndexInInorder - inStart;

        root.left =  constructBinaryTree(postorder, postStart, postStart + numsLeft - 1, inorder, inStart, rootIndexInInorder-1, map);
        root.right = constructBinaryTree(postorder, postStart + numsLeft, postEnd - 1, inorder, rootIndexInInorder + 1, inEnd, map);
        

        return root;
    }
}