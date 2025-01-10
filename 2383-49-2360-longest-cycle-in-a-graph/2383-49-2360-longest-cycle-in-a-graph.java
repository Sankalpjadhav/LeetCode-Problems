class Solution {
    public int longestCycle(int[] edges) {
        int n = edges.length;
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(i, new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            if(edges[i] != -1){
                adjList.get(i).add(edges[i]);
            }
        }

        int [] visited = new int[n];
        int [] dfsVisited = new int[n];
        int [] distance = new int[n];
        int [] maxCycleLength = new int[]{-1};

        // Do DFS for all the components
        for(int i=0;i<n;i++){
            if(visited[i] == 0){
                dfs(i, 0, distance, maxCycleLength, visited, dfsVisited, adjList);
            }
        }

        return maxCycleLength[0];
    }

    private void dfs(int node, int currentDistance, int [] distance, int [] maxCycleLength, int [] visited, int [] dfsVisited, List<List<Integer>> adjList){
        visited[node] = 1;
        dfsVisited[node] = 1;
        distance[node] = currentDistance;

        for(int adjNode: adjList.get(node)){
            if(visited[adjNode] == 0){
                dfs(adjNode, currentDistance+1, distance, maxCycleLength, visited, dfsVisited, adjList);
            }
            else if(dfsVisited[adjNode] == 1){
                // Cycle detected
                System.out.println("Dist: "+currentDistance);
                maxCycleLength[0] = Math.max(maxCycleLength[0], currentDistance + 1 - distance[adjNode]);

            }
        }

        dfsVisited[node] = 0;
    }  
}