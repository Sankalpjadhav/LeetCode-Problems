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
    public int rob(TreeNode root) {
        HashMap<TreeNode, Integer> memo = new HashMap<>();
        return letsRob(root, memo);
    }

    private int letsRob(TreeNode node, HashMap<TreeNode, Integer> memo){
        if(node == null){
            return 0;
        }

        if(memo.containsKey(node)){
            return memo.get(node);
        }

        int pick = node.val;
        if(node.left != null){
            pick += letsRob(node.left.left, memo) + letsRob(node.left.right, memo);
        }
        if(node.right != null){
            pick += letsRob(node.right.right, memo) + letsRob(node.right.left, memo);
        }

        int notPick = 0 + letsRob(node.left, memo) + letsRob(node.right, memo);

        int result = Math.max(pick, notPick);
        memo.put(node, result);
        return result;
    }
}

/*
Recursion: TC: Exponential

public int rob(TreeNode root) {
        return letsRob(root);
    }

    private int letsRob(TreeNode node){
        if(node == null){
            return 0;
        }

        int pick = node.val;
        if(node.left != null){
            pick += letsRob(node.left.left) + letsRob(node.left.right);
        }
        if(node.right != null){
            pick += letsRob(node.right.right) + letsRob(node.right.left);
        }

        int notPick = 0 + letsRob(node.left) + letsRob(node.right);

        return Math.max(pick, notPick);
    }

    TRIED APPLYING BFS ALGORITHM, HALF OF THE TEST CASES PASSED
    public int rob(TreeNode root) {
        return Math.max(applyBfs(root, true), applyBfs(root, false));
    }
    
    private int applyBfs(TreeNode root, boolean toInclude){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int totalAmount = 0;
        if(toInclude==true){
            totalAmount += root.val;
        }
        
        while(!queue.isEmpty()){
            int levelNodes = queue.size();
            toInclude = !toInclude;
            for(int i=0;i<levelNodes;i++){
                TreeNode node = queue.poll();
                if(node.left!=null){
                    queue.add(node.left);
                    if(toInclude){
                        totalAmount += node.left.val;
                    }
                }
                if(node.right!=null){
                    queue.add(node.right);
                    if(toInclude){
                        totalAmount += node.right.val;
                    }
                }
            }
        }
        return totalAmount;
    }
*/