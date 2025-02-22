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
    public TreeNode recoverFromPreorder(String traversal) {
        Stack<TreeNode> stack = new Stack<>();
        int index = 0, n = traversal.length();

        while (index < n) {
            int level = 0;

            // Count the number of dashes to determine the level
            while (index < n && traversal.charAt(index) == '-') {
                level++;
                index++;
            }

            // Extract the node value
            int value = 0;
            while (index < n && Character.isDigit(traversal.charAt(index))) {
                value = value * 10 + (traversal.charAt(index) - '0');
                index++;
            }

            // Create the new node
            TreeNode node = new TreeNode(value);

            // If the stack size is greater than the current level, pop from the stack
            while (stack.size() > level) {
                stack.pop();
            }

            // Attach the node to the left or right of the last node in the stack
            if (!stack.isEmpty()) {
                if (stack.peek().left == null) {
                    stack.peek().left = node;
                } else {
                    stack.peek().right = node;
                }
            }

            // Push the current node to the stack
            stack.push(node);
        }

        // The root of the tree is the bottom-most node in the stack
        while (stack.size() > 1) {
            stack.pop();
        }

        return stack.peek();
    }

}