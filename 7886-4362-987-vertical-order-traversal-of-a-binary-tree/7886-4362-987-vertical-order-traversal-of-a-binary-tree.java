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
    class Pair{
        TreeNode node;
        int vertical, level;
        Pair(TreeNode _node, int _vertical, int _level){
            node = _node;
            vertical = _vertical;
            level = _level;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0, 0));
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                Pair current = queue.poll();
                TreeNode currentNode = current.node;
                int currentVertical = current.vertical;
                int currentLevel = current.level;
                map.putIfAbsent(currentVertical, new TreeMap<>());
                map.get(currentVertical).putIfAbsent(currentLevel, new PriorityQueue<>());
                map.get(currentVertical).get(currentLevel).add(currentNode.val);

                if(currentNode.left != null){
                    queue.add(new Pair(currentNode.left, currentVertical-1, currentLevel+1));
                }

                if(currentNode.right != null){
                    queue.add(new Pair(currentNode.right, currentVertical+1, currentLevel+1));
                }
            }
        }

        for(TreeMap<Integer, PriorityQueue<Integer>> subMap: map.values()){
            List<Integer> subList = new ArrayList<>();
            for(PriorityQueue<Integer> pq: subMap.values()){
                while(!pq.isEmpty()){
                    subList.add(pq.poll());
                }
            }
            result.add(subList);
        }

        return result;
    }
}