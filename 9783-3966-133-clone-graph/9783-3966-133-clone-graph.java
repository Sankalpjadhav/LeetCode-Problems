/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }

        HashMap<Node, Node> oldToNewMap = new HashMap<>();
        oldToNewMap.put(node, new Node(node.val));

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()){
            Node currentNode = queue.poll();
            for(Node adjNode : currentNode.neighbors){
                if(!oldToNewMap.containsKey(adjNode)){
                    oldToNewMap.put(adjNode, new Node(adjNode.val));
                    queue.add(adjNode);
                }
                oldToNewMap.get(currentNode).neighbors.add(oldToNewMap.get(adjNode));
            }
        }

        return oldToNewMap.get(node);
    }
}