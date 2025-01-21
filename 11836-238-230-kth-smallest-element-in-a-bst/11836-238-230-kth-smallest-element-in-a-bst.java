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
    private int count;
    public int kthSmallest(TreeNode root, int k) {
        // Optimal 2 : Just perform inorder traversal and instead of storing the nodes we will count and store the kth value itself
        count = 0;
        int [] kthValue = {-1};
        dfs(root, kthValue, k);
        return kthValue[0];
    }

    private void dfs(TreeNode root, int [] kthValue, int k){
        if(root == null) return;
        dfs(root.left, kthValue, k);
        count++;
        if(count == k){
            kthValue[0] = root.val;
        }
        dfs(root.right, kthValue, k);
    }
}

/*
Time complexity: O(N)
Space complexity: O(N)
public int kthSmallest(TreeNode root, int k) {
        // Optimal 1 : Just perform inorder traversal and store the nodes value in the Data structure.
        // finally get the kth smallest element
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        return list.get(k-1);
    }

    private void dfs(TreeNode root, List<Integer> list){
        if(root == null) return;
        dfs(root.left, list);
        list.add(root.val); // Inorder by default will store the nodes in sorted order.
        dfs(root.right, list);
    }


Brute force approach:
Time complexity: O(N) + O(NlogN)
Space complexity: O(N) + O(LogN) for recursion stack space.
public int kthSmallest(TreeNode root, int k) {
        // Brute Force : Just perform any of the traversals and store the nodes value in Data structure.
        // Sort the data structure and finally get the kth smallest element
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        Collections.sort(list);
        return list.get(k-1);
    }

    private void dfs(TreeNode root, List<Integer> list){
        if(root == null) return;
        list.add(root.val);
        dfs(root.left, list);
        dfs(root.right, list);
    }
*/