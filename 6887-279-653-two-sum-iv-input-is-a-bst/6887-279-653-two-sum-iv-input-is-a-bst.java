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
    class BSTIterator {
        Stack<TreeNode> stack;
        private boolean smallest;

        BSTIterator(TreeNode root, boolean _smallest) {
            stack = new Stack<>();
            smallest = _smallest;
            pushAll(root);
        }

        public int next() {
            TreeNode node = stack.pop();
            // Dynamically push the next subtree based on the iterator direction
            if (smallest) {
                pushAll(node.right);
            } else {
                pushAll(node.left);
            }
            return node.val;
        }

        private void pushAll(TreeNode node) {
            while (node != null) {
                stack.push(node);
                // Traverse in the appropriate direction
                node = smallest ? node.left : node.right;
            }
        }
    }
    public boolean findTarget(TreeNode root, int k) {
        // Optimal: Here we will use the BSTIterrator to calculate the nextSmaller and nextBigger element
        if(root == null) return false;
        BSTIterator leftSmallest = new BSTIterator(root, true);
        BSTIterator rightBiggest = new BSTIterator(root, false); 

        int i = leftSmallest.next();
        int j = rightBiggest.next();

        while(i < j){
            if(i + j == k){
                return true;
            }
            else if(i + j < k){
                i = leftSmallest.next();
            }
            else{
                j = rightBiggest.next();
            }
        }

        return false;

    }


}

/*
    public boolean findTarget(TreeNode root, int k) {
        //  Brute force: We will perform inorder traversal and store the results in list.
        // Then apply two pointers technique to check if we get sum == k.
        // Time complexity: O(N) + O(N)
        List<Integer> list = new ArrayList<>();
        inorder(root, list);

        int left = 0, right = list.size()-1;

        while(left < right){
            if(list.get(left) + list.get(right) == k){
                return true;
            }
            else if(list.get(left) + list.get(right) > k){
                right--;
            }
            else{
                left++;
            }
        }

        return false;
    }

    private void inorder(TreeNode root, List<Integer> list){
        if(root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
*/