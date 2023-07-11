/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private void parentMapping(TreeNode root, HashMap<TreeNode,TreeNode> parentMap){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.left!=null){
                queue.add(node.left);
                parentMap.put(node.left,node);
            }
            if(node.right!=null){
                queue.add(node.right);
                parentMap.put(node.right,node);
            }
        }
    }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode,TreeNode> parentMap = new HashMap<>();
        parentMapping(root,parentMap);
        Queue<TreeNode> q = new LinkedList<>();
        HashMap<TreeNode,Boolean> visited = new HashMap<>();
        q.offer(target);
        visited.put(target,true);
        int distance = 0;
        while(!q.isEmpty()){
            int size = q.size();
            if(distance == k) break;
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                if(node.left!=null && visited.get(node.left)==null){
                    q.add(node.left);
                    visited.put(node.left,true);
                }
                if(node.right!=null && visited.get(node.right)==null){
                    q.add(node.right);
                    visited.put(node.right,true);
                }
                if(parentMap.get(node)!=null && visited.get(parentMap.get(node))==null){
                    q.add(parentMap.get(node));
                    visited.put(parentMap.get(node),true);
                }
            }
            distance++;    
        }
        
        List<Integer> result = new ArrayList<>();
        while(!q.isEmpty()){
            result.add(q.poll().val);
        }
        
        return result;
    }
}