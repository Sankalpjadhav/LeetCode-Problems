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

class BSTIterator{
    Stack<TreeNode> stack = new Stack<>();
    boolean flag = true; // true -> to find next smaller element, false -> to find previous greater number
    
    BSTIterator(TreeNode root, boolean _flag){
        flag = _flag;
        pushAll(root);
    }
    
    private void pushAll(TreeNode root){
        while(root!=null){
            stack.push(root);
            if(flag == true){
                root = root.left;
            }
            else{
                root = root.right;
            }
        }
    }
    
    public int next(){
        TreeNode node = stack.pop();
        if(flag == true){
            pushAll(node.right);
        }
        else{
            pushAll(node.left);
        }
        return node.val;
    }
    
    public boolean hasNext(){
        return !stack.isEmpty();
    }
}

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        BSTIterator smaller = new BSTIterator(root, true);
        BSTIterator greater = new BSTIterator(root, false);
        
        int left = smaller.next();
        int right = greater.next();
        
        while(left < right){
            if(left + right == k){
                return true;
            }
            else if(left + right < k){
                left = smaller.next();
            }
            else{
                right = greater.next();
            }
        }
        
        return false;
    }
}