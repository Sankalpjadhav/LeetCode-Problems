class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> list = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        
        for(int [] edge:edges){
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }
        boolean [] visited = new boolean[n];
        int time = dfs(0, list, hasApple, visited);
        return time == 0 ? 0 : time - 2; // if statement written below will add +2 for node 0 too so we will substract 2
    }
    
    private int dfs(int node, List<List<Integer>> list, List<Boolean> hasApple, boolean [] visited){

        visited[node] = true;
        int time = 0;
        for(int adjNode: list.get(node)){
            if(!visited[adjNode]){
                time += dfs(adjNode, list, hasApple, visited);
            }
        }
        
        if(time > 0 || hasApple.get(node)){
            time += 2; // 2 bcoz to travserse an edge we require time = 2
        }
        
        return time;
    }
}