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
    private TreeNode startNode;
    public int amountOfTime(TreeNode root, int start) {
        startNode = null;
        int timeTaken = -1;
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        parentMapping(root, start, map);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(startNode);
        Set<TreeNode> visited = new HashSet<>();
        visited.add(startNode);

        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                TreeNode currentNode = queue.poll();

                if(currentNode.left!=null && !visited.contains(currentNode.left)){
                    visited.add(currentNode.left);
                    queue.add(currentNode.left);
                }

                if(currentNode.right!=null && !visited.contains(currentNode.right)){
                    visited.add(currentNode.right);
                    queue.add(currentNode.right);
                }

                if(map.get(currentNode)!=null && !visited.contains(map.get(currentNode))){
                    visited.add(map.get(currentNode));
                    queue.add(map.get(currentNode));
                }
            }
            timeTaken++;
        }

        return timeTaken;
    }

    private void parentMapping(TreeNode root, int start, HashMap<TreeNode, TreeNode> map){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                TreeNode currentNode = queue.poll();

                if(currentNode.val == start){
                    startNode = currentNode;
                }

                if(currentNode.left != null){
                    map.put(currentNode.left, currentNode);
                    queue.add(currentNode.left);
                }

                if(currentNode.right != null){
                    map.put(currentNode.right, currentNode);
                    queue.add(currentNode.right);
                }
            }
        }
    }
}