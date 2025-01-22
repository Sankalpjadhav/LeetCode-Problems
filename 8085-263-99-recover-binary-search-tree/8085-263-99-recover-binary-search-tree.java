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
    // Optimal
    private TreeNode prev, middle, firstViolation, secondViolation;
    public void recoverTree(TreeNode root) {
        prev = new TreeNode(Integer.MIN_VALUE);
        middle = null;
        firstViolation = null;
        secondViolation = null;

        inorderTraversal(root);

        if(firstViolation != null && secondViolation != null){
            // The nodes are not adjacent
            int temp = firstViolation.val;
            firstViolation.val = secondViolation.val;
            secondViolation.val = temp;
        }
        else{
            // THe nodes are adjacent
            int temp = firstViolation.val;
            firstViolation.val = middle.val;
            middle.val = temp;
        }
    }

    private void inorderTraversal(TreeNode root){
        if(root == null) return;
        inorderTraversal(root.left);
        if(prev!=null && prev.val > root.val){
            if(firstViolation == null){
                // That means it is first violation
                firstViolation = prev;
                middle = root;
            }
            else{
                // That means this is second violation
                secondViolation = root;
            }
        }
        prev = root;
        inorderTraversal(root.right);
    }
}

/*
// Brute force approach:
    int i;
    public void recoverTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorderTraversal(root, list);

        Collections.sort(list);
        System.out.println(list);
        i = 0;

        inorderTraversal(root, list);
    }

    private void inorderTraversal(TreeNode root, List<Integer> list){
        if(root == null) return;
        inorderTraversal(root.left, list);
        if(root.val != list.get(i)){
            root.val = list.get(i);
        }
        i++;
        inorderTraversal(root.right, list);
    }

    private void preorderTraversal(TreeNode root, List<Integer> list){
        if(root == null) return;
        list.add(root.val);
        preorderTraversal(root.left, list);
        preorderTraversal(root.right, list);
    }
*/