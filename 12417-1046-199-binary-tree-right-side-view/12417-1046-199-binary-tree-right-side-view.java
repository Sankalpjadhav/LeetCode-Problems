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
    public List<Integer> rightSideView(TreeNode root) {
        // Lets apply dfs which has auxillary space of O(log N)
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;

        reversePreOrderTraversal(root, result, 0);        

        return result;
    }

    private void reversePreOrderTraversal(TreeNode node, List<Integer> result, int level){
        if(node == null) return;

        if(result.size() == level){
            result.add(node.val);
        }

        reversePreOrderTraversal(node.right, result, level+1);
        reversePreOrderTraversal(node.left, result, level+1);
    }
}

/*
 class Pair{
        TreeNode node;
        int level;
        Pair(TreeNode _node, int _level){
            node = _node;
            level = _level;
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
        // Lets apply level order traversal which is Brute force approach is per Space complexity (N).
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        HashMap<Integer, Integer> map = new HashMap<>();

        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                Pair current = queue.poll();
                TreeNode currentNode = current.node;
                int currentLevel = current.level;

                map.put(currentLevel, currentNode.val);

                if(currentNode.left != null) queue.add(new Pair(currentNode.left, currentLevel+1));
                if(currentNode.right != null) queue.add(new Pair(currentNode.right, currentLevel+1));
            }
        }

        for(int i=0;map.containsKey(i);i++){
            result.add(map.get(i));
        }

        return result;
    }
*/