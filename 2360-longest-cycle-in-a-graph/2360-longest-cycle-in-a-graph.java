class Solution {
    public int longestCycle(int[] edges) {
        int n = edges.length;
        
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            adjList.add(new ArrayList<>());
        }
        
        for(int i=0; i<n; i++){
            if(edges[i] != -1){
                adjList.get(i).add(edges[i]);
            }
        }
        
        int [] distance = new int[n];

        boolean [] visited = new boolean[n];
        boolean [] dfsVisited = new boolean[n];
        int [] maxDistance = new int[]{-1};
        
        for(int i=0; i<n; i++){
            if(!visited[i]){
                dfs(i, maxDistance, 0, distance, visited, adjList, dfsVisited);
            }
        }
        
        return maxDistance[0];
    }
    
    private void dfs(int node, int [] maxDistance, int dist, int [] distance, boolean [] visited, ArrayList<ArrayList<Integer>> adjList, boolean [] dfsVisited){
        visited[node] = true;
        dfsVisited[node] = true;
        distance[node] = dist;
        
        for(int adjNode: adjList.get(node)){
            if(!visited[adjNode]){
                dfs(adjNode, maxDistance, dist+1, distance, visited, adjList, dfsVisited);
            }
            else if(dfsVisited[adjNode]){
                maxDistance[0] = Math.max(maxDistance[0], (dist + 1) - distance[adjNode]);
            }
        }
        
        dfsVisited[node] = false;
    }
}


/*

Gives TLE: Passes 67/76 cases

public int longestCycle(int[] edges) {
        int n = edges.length;
        
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            adjList.add(new ArrayList<>());
        }
        
        for(int i=0; i<n; i++){
            if(edges[i] != -1){
                adjList.get(i).add(edges[i]);
            }
        }
        
        int [] cycleDistance = new int[n];

        boolean [] visited = new boolean[n];
        for(int i=0; i<n; i++){
            dfs(i, new int[]{i}, 0, cycleDistance, visited, adjList);
        }
        
        int max = 0;
        
        for(int i=0;i<n;i++){
            max = Math.max(max, cycleDistance[i]);
        }
        
        return max == 0 ? -1 : max;
    }
    
    private void dfs(int node, int [] possibleNode, int dist, int [] cycleDistance, boolean [] visited, ArrayList<ArrayList<Integer>> adjList){
        visited[node] = true;
        
        for(int adjNode: adjList.get(node)){
            if(visited[adjNode]){
                if(possibleNode[0] == adjNode){
                    cycleDistance[adjNode] = Math.max(cycleDistance[adjNode], dist+1);
                }
            }
            else{
                dfs(adjNode, possibleNode, dist+1, cycleDistance, visited, adjList);
            }
        }
        
        visited[node] = false;
    }

*/