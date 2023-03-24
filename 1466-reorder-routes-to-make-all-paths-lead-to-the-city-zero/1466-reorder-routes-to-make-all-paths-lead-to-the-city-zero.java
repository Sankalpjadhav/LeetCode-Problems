class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<int[]>> adjList = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        
        for(int [] connection: connections){
            adjList.get(connection[0]).add(new int[]{connection[1], 1});
            adjList.get(connection[1]).add(new int[]{connection[0], 0});
        }
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        boolean [] visited = new boolean[n];
        visited[0] = true;
        int cost = 0;
        
        while(!queue.isEmpty()){
            int node = queue.poll();
            
            for(int [] adjNode:adjList.get(node)){
                if(!visited[adjNode[0]]){
                    visited[adjNode[0]] = true;
                    cost += adjNode[1];
                    queue.add(adjNode[0]);
                }
            }
        }
        
        return cost;
    }
}