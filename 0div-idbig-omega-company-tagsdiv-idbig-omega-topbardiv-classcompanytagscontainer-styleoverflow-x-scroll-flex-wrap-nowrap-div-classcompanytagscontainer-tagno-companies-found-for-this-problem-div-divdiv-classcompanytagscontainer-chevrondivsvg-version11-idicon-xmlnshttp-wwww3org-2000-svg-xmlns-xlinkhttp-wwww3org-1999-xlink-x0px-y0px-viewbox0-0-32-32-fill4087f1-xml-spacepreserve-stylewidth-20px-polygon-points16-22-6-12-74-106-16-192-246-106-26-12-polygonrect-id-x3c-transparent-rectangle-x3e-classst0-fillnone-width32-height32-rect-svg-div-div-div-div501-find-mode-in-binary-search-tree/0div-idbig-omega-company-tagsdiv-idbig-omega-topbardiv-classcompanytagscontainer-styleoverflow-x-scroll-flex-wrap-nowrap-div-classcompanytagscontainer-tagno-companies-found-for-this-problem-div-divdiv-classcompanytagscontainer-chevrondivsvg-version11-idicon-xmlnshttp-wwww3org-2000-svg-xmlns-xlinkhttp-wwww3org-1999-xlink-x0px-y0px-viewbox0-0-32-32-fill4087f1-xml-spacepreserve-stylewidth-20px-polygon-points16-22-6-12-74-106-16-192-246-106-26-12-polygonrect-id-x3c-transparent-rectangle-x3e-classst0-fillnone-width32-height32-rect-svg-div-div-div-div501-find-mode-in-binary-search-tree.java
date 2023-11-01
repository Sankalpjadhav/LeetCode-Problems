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
    public int[] findMode(TreeNode root) {
        if(root == null){
            return new int[0];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int [] maxCount = {1}; 
        preorderTraversal(root, map, maxCount);
        int [] result = new int[map.size()];
        int index = 0;
        for(Integer key : map.keySet()){
            if(map.get(key) == maxCount[0]){
                result[index++] = key;
            }
        }
        
        return Arrays.copyOf(result, index);
    }
    
    private void preorderTraversal(TreeNode root, HashMap<Integer, Integer> map, int [] maxCount){
        if(root == null){
            return;
        }
        
        if(map.containsKey(root.val)){
            int count = map.get(root.val);
            map.put(root.val, count+1);
            maxCount[0] = Math.max(maxCount[0], count+1);
        }
        else{
            map.put(root.val, 1);
        }
        
        preorderTraversal(root.left, map, maxCount);
        preorderTraversal(root.right, map, maxCount);
    }

    
}