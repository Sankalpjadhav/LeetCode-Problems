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
    
    public int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        
        TreeNode startNode = bfs(root, map, start);
        
        // System.out.println(startNode.val);
        /*
        Print map to check parent mapping is correct or not
        for(TreeNode n: map.keySet()){
            System.out.println(n.val +"->" + map.get(n).val);
        }
        */
        
        Set<Integer> visited = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.add(startNode);
        visited.add(startNode.val);
        
        int numberOfMinutes = -1;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            numberOfMinutes++;
            while(size-- > 0){
                TreeNode node = queue.poll();
                
                if(node.left!=null && !visited.contains(node.left.val)){
                    visited.add(node.left.val);
                    queue.add(node.left);
                }

                if(node.right!=null && !visited.contains(node.right.val)){
                    visited.add(node.right.val);
                    queue.add(node.right);
                }

                if(map.containsKey(node) && !visited.contains(map.get(node).val)){
                   visited.add(map.get(node).val);
                    queue.add(map.get(node)); 
                }
            }
        }
        
        return numberOfMinutes;
        
    }
    
    private TreeNode bfs(TreeNode root, HashMap<TreeNode, TreeNode> map, int start){
        TreeNode startNode = null;
        
        TreeNode curr = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            
            if(start == node.val){
                startNode = node;
            }
            
            if(node.left!=null){
                queue.add(node.left);
                map.put(node.left, node);
            }
            
            if(node.right!=null){
                queue.add(node.right);
                map.put(node.right, node);
            }
        }
        
        return startNode;
    }
}