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
    public int rangeSumBST(TreeNode root, int low, int high) {
        ArrayList<Integer> elements = new ArrayList<>();
        TreeNode currNode = root;
        inorderTraversal(currNode, elements);
        int sum = 0;
        boolean startConsideringValues = false;
        for(int i=0;i<elements.size();i++){
            if(elements.get(i) == low){
                startConsideringValues = true;
            }
            if(elements.get(i) == high){
                sum += elements.get(i);
                startConsideringValues = false;
            }
            if(startConsideringValues){
                sum += elements.get(i);
            }
        }

        return sum;
    }

    private void inorderTraversal(TreeNode root, ArrayList<Integer> elements){
        if(root == null){
            return ;
        }

        inorderTraversal(root.left, elements);
        elements.add(root.val);
        inorderTraversal(root.right, elements);
    }
}