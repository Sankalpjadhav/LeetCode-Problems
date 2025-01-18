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
        int index;
        Pair(TreeNode _node, int _index){
            node = _node;
            index = _index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        int maxWidth = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        while(!queue.isEmpty()){
            int size = queue.size();
            int minimumAtThatLevel = queue.peek().index; // This will be always first node index in that level
            int leftIndex = 0, rightIndex = 0;
            for(int i=0;i<size;i++){
                Pair current = queue.poll();
                TreeNode currentNode = current.node;
                int currentIndex = current.index - minimumAtThatLevel;

                if(i == 0) leftIndex = currentIndex;
                if(i == size-1) rightIndex = currentIndex;

                if(currentNode.left != null) queue.add(new Pair(currentNode.left, currentIndex*2+1));
                if(currentNode.right != null) queue.add(new Pair(currentNode.right, currentIndex*2+2));
            } 
            maxWidth = Math.max(maxWidth, rightIndex - leftIndex + 1);
        }

        return maxWidth;
    }
}