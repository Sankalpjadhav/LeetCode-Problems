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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        dfs(root, map, result);
        return result;
    }
    
    
    private String dfs(TreeNode root, HashMap<String, Integer> map, List<TreeNode> result){
        if(root == null){
            return "N";
        }
        
        String left = dfs(root.left, map, result);
        String right = dfs(root.right, map, result);
        
        String current = root.val+ "#" + left + "#" + right;
        
        map.put(current, map.getOrDefault(current, 0)+1);
        
        if(map.get(current) == 2){
            result.add(root);
        }
        
        return current;
    }
}