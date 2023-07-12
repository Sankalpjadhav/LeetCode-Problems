class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> adjList = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        
        for(int i=0;i<graph.length;i++){
            for(int node: graph[i]){
                adjList.get(i).add(node);
            }
        }
        
        int [] visited = new int[n];
        int [] dfsVisited = new int[n];
        int [] check = new int[n];
        
        for(int i=0;i<n;i++){
            if(visited[i] == 0){
                dfs(i, adjList, visited, dfsVisited, check);
            }
        }
        
        List<Integer> safeNodes = new ArrayList<>();
        
        for(int i=0;i<check.length;i++){
            if(check[i] == 1){
                safeNodes.add(i);
            }
        }
        
        return safeNodes;
    }
    
    private boolean dfs(int node, List<List<Integer>> adjList, int [] visited, int [] dfsVisited, int [] check){
        visited[node] = 1;
        dfsVisited[node] = 1;
        check[node] = 0;
        
        for(int adjNode: adjList.get(node)){
            if(visited[adjNode] == 0){
                if(dfs(adjNode, adjList, visited, dfsVisited, check)){
                    return true;
                }
            }
            else{
                if(dfsVisited[adjNode] == 1){
                    // Cycle
                    return true;
                }
            }
        }
        
        check[node] = 1;
        dfsVisited[node] = 0;
        return false;
    }
}