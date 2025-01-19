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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();

        if(root.left == null && root.right == null){
            if(k == 0){
                result.add(root.val);
                return result;
            }

            return result;
        }

        HashMap<TreeNode, TreeNode> parentPtr = new HashMap<>();
        findParents(root, parentPtr);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);
        Set<TreeNode> visited = new HashSet<>();

        while(!queue.isEmpty()){
            int size = queue.size();
            k--;
            if(k < 0){
                break;
            }
            while(size-- > 0){
                TreeNode currentNode = queue.poll();
                visited.add(currentNode);

                if(currentNode.left != null && !visited.contains(currentNode.left)){
                    visited.add(currentNode.left);
                    queue.add(currentNode.left);
                }
                if(currentNode.right != null && !visited.contains(currentNode.right)){
                    visited.add(currentNode.right);
                    queue.add(currentNode.right);
                }
                if(parentPtr.get(currentNode) != null && !visited.contains(parentPtr.get(currentNode))){
                    visited.add(parentPtr.get(currentNode));
                    queue.add(parentPtr.get(currentNode));
                }
            }
            if(k == 0){
                break;
            }
        }

        while(!queue.isEmpty()){
            result.add(queue.poll().val);
        }

        return result;
    }

    private void findParents(TreeNode root, HashMap<TreeNode, TreeNode> parentPtr){
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                TreeNode currentNode = queue.poll();
                if(currentNode.left != null){
                    parentPtr.put(currentNode.left, currentNode);
                    queue.add(currentNode.left);
                }
                if(currentNode.right != null){
                    parentPtr.put(currentNode.right, currentNode);
                    queue.add(currentNode.right);
                }
            }
        }
    }
}