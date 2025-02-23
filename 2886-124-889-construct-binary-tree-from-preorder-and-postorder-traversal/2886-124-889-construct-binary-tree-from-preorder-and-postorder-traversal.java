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
    private HashMap<Integer, Integer> postorderMap;
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = preorder.length;
        postorderMap = new HashMap<>();
        for(int i=0;i<n;i++){
            postorderMap.put(postorder[i], i);
        }

        return constructBinaryTree(preorder, 0, n-1, postorder, 0, n-1);
    }

    private TreeNode constructBinaryTree(int [] preorder, int preStart, int preEnd, int [] postorder, int postStart, int postEnd){
        if(preStart > preEnd || postStart > postEnd){
            return null;
        }

        if(preStart == preEnd){
            return new TreeNode(preorder[preStart]);
        }

        TreeNode root = new TreeNode(preorder[preStart]);

        int leftSubTreeRootInPreorder = preStart + 1;
        int leftSubTreeRootInPostorder = postorderMap.get(preorder[leftSubTreeRootInPreorder]);
        int numberOfElementsInLeftSubTree = leftSubTreeRootInPostorder - postStart;
        int leftSubTree_End_InPre = leftSubTreeRootInPreorder + numberOfElementsInLeftSubTree;

        root.left = constructBinaryTree(preorder, leftSubTreeRootInPreorder, leftSubTree_End_InPre, postorder, postStart, leftSubTreeRootInPostorder);
        root.right = constructBinaryTree(preorder, leftSubTree_End_InPre+1, preEnd, postorder, leftSubTreeRootInPostorder+1, postEnd - 1);

        return root;
    }
}