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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> allPaths = new ArrayList<>();
        getAllPaths(root, "", allPaths);

        return allPaths;
    }

    private void getAllPaths(TreeNode root, String path, List<String> allPaths){
        if(root == null) return;
        String initialPath = path;
        path += root.val + "->";

        if(root.left == null && root.right == null){
             initialPath += root.val;
            allPaths.add(initialPath);
            return;
        }

        getAllPaths(root.left, path, allPaths);
        getAllPaths(root.right, path, allPaths);
    }
}