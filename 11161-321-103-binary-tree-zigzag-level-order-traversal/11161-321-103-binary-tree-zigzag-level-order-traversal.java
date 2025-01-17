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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = false;

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> subList = new ArrayList<>();

            while(size-- > 0){
                TreeNode currentNode = queue.poll();
                if(currentNode.left != null){
                    queue.add(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.add(currentNode.right);
                }
                if(flag == false){
                    subList.add(currentNode.val);
                }
                else{
                    subList.add(0, currentNode.val);
                }
            }


            flag = !flag;
            result.add(subList);
        }

        return result;
    }
}


/*
Brute force: O(n) + O(2*N)
O(N) : Applying BFS to traverse all nodes
O(2*N) : The final result has N nodes, lets say we are reversing half of the nodes.
public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // Store all the nodes level wise from left to right manner
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> subList = new ArrayList<>();

            while(size-- > 0){
                TreeNode currentNode = queue.poll();
                subList.add(currentNode.val);
                if(currentNode.left != null){
                    queue.add(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.add(currentNode.right);
                }
            }
            result.add(subList);
        }

        // Reverse odd index list in the result list.
        for(int i=1;i<result.size();i+=2){
            List<Integer> sub = result.get(i);
            int left = 0;
            int right = sub.size()-1;
            while(left < right){
                int temp = sub.get(left);
                sub.set(left, sub.get(right));
                sub.set(right, temp);
                left++;
                right--;
            }
        }

        return result;
    }
*/