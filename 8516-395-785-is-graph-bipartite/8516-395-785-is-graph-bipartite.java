class Solution {
    /* 
        There is no need to construct adjList since the input given is adjList
        Using BFS
        TC: O(N + 2*E) + O(N) + O(N+E)

        O(N + 2*E) is for constructing adjList
        O(N) is for filling the color
        O(N + E) is to traverse through all the nodes using BFS and E for all edges overall
    */
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> adjList = new ArrayList<>();

        // Construct adjacency list structure
        for(int i=0;i<n;i++){
            adjList.add(i, new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<graph[i].length;j++){
                    adjList.get(i).add(graph[i][j]);
                    adjList.get(graph[i][j]).add(i);
            }
        }

        // We can also consider this to be visited array. 
        // If the node is not colored it means it is not visited.

        int [] colors = new int[n];
        Arrays.fill(colors, -1);

        // Apply BFS for each component as the graph is disconnected
        for(int i=0;i<n;i++){
            if(colors[i] == -1){
                if(bfs(i, colors, adjList) == false){ // If one of the component is not Bipartite then there is no need to check for other components.
                    return false;
                }
            }
        }

        return true;
    }

    private boolean bfs(int node, int [] colors, List<List<Integer>> adjList){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(node);
        colors[node] = 0; // We can color first node with any color

        while(!queue.isEmpty()){
            int currNode = queue.poll();
            for(Integer adjNode: adjList.get(currNode)){
                if(colors[adjNode] == -1){
                    queue.add(adjNode);
                    colors[adjNode] = 1 - colors[currNode]; // 0 becomes 1, or 1 becomes 0
                }
                else if(colors[adjNode] == colors[currNode]){
                    // this means that adjNode is already colored and has the same color as that of currNode
                    return false;
                }
            }
        }

        return true;
    }
}