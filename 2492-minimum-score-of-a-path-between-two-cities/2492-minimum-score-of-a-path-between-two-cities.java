class Solution {
    public int minScore(int n, int[][] roads) {
        List<List<int[]>> list = new ArrayList<>();
        
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }
        
        for(int [] road : roads){
            list.get(road[0]).add(new int[]{road[1],road[2]});
            list.get(road[1]).add(new int[]{road[0],road[2]});
        }
        
        return bfs(1, list, roads, n);
    }
    
    private int bfs(int node, List<List<int[]>> list, int [][] roads, int n){
        boolean [] visited = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;
        int result = Integer.MAX_VALUE;
        
        while(!queue.isEmpty()){
            int vertex = queue.poll();
            
            for(int [] adjNode: list.get(vertex)){
                result = Math.min(adjNode[1], result);
                if(!visited[adjNode[0]]){
                    visited[adjNode[0]] = true;
                    queue.add(adjNode[0]);
                }
            }
        }
        
        return result;
    }
}