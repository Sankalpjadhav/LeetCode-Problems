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

    public boolean isValidBST(TreeNode root) {
        return preorderTraversal(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean preorderTraversal(TreeNode root, long min, long max){
        if(root == null) return true;
        if(root.val >= max || root.val <= min){
            return false;
        }

        return preorderTraversal(root.left, min, root.val) && preorderTraversal(root.right, root.val, max);
    }
}

/*

Optimal approach 1:

private boolean isBst;
    public boolean isValidBST(TreeNode root) {
        isBst = true;
        long [] prev = {Long.MIN_VALUE};
        inorderTraversal(root, prev);

        return isBst;
    }

    private void inorderTraversal(TreeNode root, long [] prev){
        if(root == null) return;
        inorderTraversal(root.left, prev);
        if(prev[0] >= root.val){
            isBst = false;
        }
        prev[0] = root.val;
        inorderTraversal(root.right, prev);
    }

Brute force: Here we are checking if the property of BST holds good meaning inorder should be sorted.
Here we are storing all the inorder values in a list and then comparing.

public boolean isValidBST(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        inorderTraversal(root, inorder);

        for(int i=1;i<inorder.size();i++){
            if(inorder.get(i) <= inorder.get(i-1)){
                return false;
            }
        }

        return true;
    }

    private void inorderTraversal(TreeNode root, List<Integer> list){
        if(root == null) return;
        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }
*/