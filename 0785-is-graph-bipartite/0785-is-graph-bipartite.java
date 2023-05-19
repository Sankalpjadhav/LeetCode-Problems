class Solution {
    
    public boolean isBipartiteOrNot(int[][] graph, int vertex, int [] visited){
        if(visited[vertex]==-1) visited[vertex] = 0;
        
        for(int adjacentNode : graph[vertex]){
            if(visited[adjacentNode]==-1){
                visited[adjacentNode] = 1 - visited[vertex];
                if(!isBipartiteOrNot(graph, adjacentNode, visited)){
                    return false;
                }
            }
            else if(visited[adjacentNode]==visited[vertex]){
                return false;
            }
            
        }
        return true;
    }
    
    public boolean isBipartite(int[][] graph) {
        int[] visited = new int[graph.length];
        Arrays.fill(visited, -1);
        for(int i=0;i<graph.length;i++){
            if(visited[i]==-1){
                boolean isGraphBipartite = isBipartiteOrNot(graph, i, visited);
                if(isGraphBipartite==false){
                    return false;
                }
            }
        }
        return true;
    }
}