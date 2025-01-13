class Solution {
   public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int [] parent = new int[n+1];
        int [] rank = new int[n+1];

        for(int i=1;i<=n;i++){
            parent[i] = i;
            rank[i] = 1;
        }

        for(int [] edge: edges){
            if(!union(edge[0], edge[1], parent, rank)){
                return edge;
            }
        }

        return new int[]{};
    } 

    private int findParent(int node, int [] parent){
        if(node == parent[node]){
            return node;
        }
        return parent[node] = findParent(parent[node], parent);
    }

    private boolean union(int node1, int node2, int [] parent, int [] rank){
        int parent1 = findParent(node1, parent);
        int parent2 = findParent(node2, parent);

        if(parent1 == parent2){
            // Redundant edge
            return false;
        }

        if(rank[parent1] > rank[parent2])
        {
            parent[parent2] = parent1;
            rank[parent1] += rank[parent2];
        }
        else{
            parent[parent1] = parent2;
            rank[parent2] += rank[parent1];
        }

        return true;

    }
}

/*
public int[] findRedundantConnection(int[][] edges) {
        // TC: O(E * (V + E))
        // Initially, it did not contained any cycle. However, after adding an extra edge
        // now it is bound to have a cycle.

        // My Approach is to find out nodes which contribute to have a cycle using BFS algorithm.

        // We will be taking individual edges acting as node and its parent.

        int n = edges.length;
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<=n;i++){
            adj.add(i, new ArrayList<>());
        }

        for(int [] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Set<Integer> nodesContributeToCycle = new HashSet<>();
        for(int [] edge: edges){
            bfs(edge[0], edge[1], nodesContributeToCycle, adj);
        }

        for(int i=edges.length-1;i>=0;i--){
            int node1 = edges[i][0];
            int node2 = edges[i][1];
            if(nodesContributeToCycle.contains(node1) && nodesContributeToCycle.contains(node2)){
                return new int[]{node1, node2};
            }
        }

        return new int[]{};
    } 

    private void bfs(int node, int parent, Set<Integer> nodesContributeToCycle, 
    List<List<Integer>> adj){
        Queue<int []> queue = new LinkedList<>();
        boolean [] visited = new boolean[adj.size()];
        queue.add(new int[]{node, parent});
        visited[node] = true;

        while(!queue.isEmpty()){
            int [] pair = queue.poll();
            int currentNode = pair[0];
            int currentParent = pair[1];

            for(int adjNode: adj.get(currentNode)){
                if(adjNode == currentParent) continue;
                if(!visited[adjNode]){
                    queue.add(new int[]{adjNode, currentNode});
                    visited[adjNode] = true;
                }
                else if(currentParent!=adjNode){
                    nodesContributeToCycle.add(adjNode);
                    nodesContributeToCycle.add(currentNode);
                    return;
                }
            }
        }

        return;
    }
*/