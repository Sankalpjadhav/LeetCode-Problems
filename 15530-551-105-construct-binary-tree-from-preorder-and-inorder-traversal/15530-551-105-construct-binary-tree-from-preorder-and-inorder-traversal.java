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
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            indexMap.put(inorder[i], i);
        }

        return constructBinaryTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, indexMap);
    }

    private TreeNode constructBinaryTree(int [] preorder, int preStart, int preEnd, int [] inorder, 
    int inStart, int inEnd, HashMap<Integer, Integer> indexMap){
        if(preStart > preEnd || inStart > inEnd){
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        int rootIndexInInorder = indexMap.get(root.val);
        int numsOnLeft = rootIndexInInorder - inStart;

        root.left = constructBinaryTree(preorder, preStart + 1, preStart + numsOnLeft, inorder, inStart, rootIndexInInorder-1, indexMap);
        root.right = constructBinaryTree(preorder, preStart + numsOnLeft + 1, preEnd, inorder, rootIndexInInorder + 1, inEnd, indexMap);

        return root;
    }
}